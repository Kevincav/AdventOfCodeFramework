package org.advent.utils

import better.files.File
import cats.effect.IO
import org.advent.utils.HelperClasses.{CombinedLimiter, DurationDetails, LimitDetails}
import play.api.libs.json.Json

import sys.process.*
import scala.concurrent.*
import scala.concurrent.duration.*
import scala.io.Source
import scala.language.postfixOps

case class RateLimiter(year: Int, day: Int) {
  private val file: File = File(s"src/main/resources/year$year/limiters")
  file.createIfNotExists(asDirectory = false, createParents = true)

  private def pushAnswer(answer: Long, part: Int): IO[(DurationDetails, Boolean)] = {
    val result = List("curl", "-X", "POST", "--cookie", s"'session=${sys.env("AOC_COOKIE_SESSION")}'", "-H",
      s"'User-Agent: ${sys.env("AOC_COOKIE_SESSION")}'", "--data", s"'level=$part&answer=$answer'",
      s"https://adventofcode.com/$year/day/$day/answer").mkString(" ") !!

    println(s"Submitting part $part for day $day, Answer for part $part: ${result.contains("That's the right answer") ||
      result.contains("Did you already complete it")}")

    IO {
      (DurationDetails(sys.env("AOC_SUBMISSION_THROTTLE").toInt.minutes.fromNow.time.toNanos,
        sys.env("AOC_SUBMISSION_THROTTLE").toInt.minutes.fromNow.time._2.toString.toLowerCase),
        result.contains("That's the right answer") || result.contains("Did you already complete it"))
    }
  }

  def publishAnswer(part1: Long, part2: Long): IO[Unit] = if (sys.env("AOC_SUBMIT_ANSWERS").toBoolean) {
    // Fetch last publish run data for the current part
    val dayLimiter: LimitDetails = if (file.isEmpty) LimitDetails() else
      Json.fromJson[LimitDetails](Json.parse(Source.fromResource(s"year$year/limiters").mkString)).get

    // Fetch last run time
    val lastRunTime = Deadline(dayLimiter.lastRun.toFiniteDuration)
    val dayCombinedLimiter = dayLimiter.dayToPartSoledMap.withDefaultValue(CombinedLimiter())(day)

    // Check results for successful answer / submission and Save new limiter results
    if (lastRunTime.isOverdue()) {
      val part1Result = if (!dayCombinedLimiter.part1Answer) pushAnswer(part1, 1).map((duration, result) =>
        (duration, dayCombinedLimiter.copy(part1Answer = result))) else IO { (dayLimiter.lastRun, dayCombinedLimiter) }
      val part2Result = part1Result.flatMap((duration, combinedLimiter) => if (!dayCombinedLimiter.part2Answer)
        pushAnswer(part2, 2).map((lastDuration, result) => (lastDuration, combinedLimiter.copy(part2Answer = result))) else
        IO { (duration, combinedLimiter) })
      val dayResults = part2Result.map((lastRun, combinedLimiter) =>
        dayLimiter.copy(lastRun = lastRun, dayToPartSoledMap = dayLimiter.dayToPartSoledMap.updated(day, combinedLimiter)))

      // Update limiter data
      dayResults.map(limitDetails => file.writeText(Json.prettyPrint(Json.toJson(limitDetails))))
    } else IO { println(s"Unable to update results, time remaining: ${lastRunTime.timeLeft.toMinutes} minutes") }
  } else IO {}
}
