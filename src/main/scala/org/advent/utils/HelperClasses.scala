package org.advent.utils

import play.api.libs.json._

import scala.concurrent.duration.*

object HelperClasses {
  case class CombinedLimiter(part1Answer: Boolean = false, part2Answer: Boolean = false)

  case class DurationDetails(time: Long = -1.seconds.fromNow.time.toNanos,
                             timeUnit: String = -1.seconds.fromNow.time._2.toString.toLowerCase) {
    def toFiniteDuration: FiniteDuration = FiniteDuration(time, timeUnit)
  }

  case class LimitDetails(lastRun: DurationDetails = DurationDetails(),
                          dayToPartSoledMap: Map[Int, CombinedLimiter] = Map.empty.withDefaultValue(CombinedLimiter()))

  implicit val combinedLimiterFormat: Format[CombinedLimiter] = Json.format[CombinedLimiter]
  implicit val durationDetailsFormat: Format[DurationDetails] = Json.format[DurationDetails]
  implicit val limitDetailsFormat: Format[LimitDetails] = Json.format[LimitDetails]
}
