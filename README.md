<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a id="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![Advent of Code][aoc-shield]][aoc-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://aplwiki.com/images/0/0d/Advent_Of_Code_Logo.png">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">Advent of Code Scala Framework</h3>

  <p align="center">
    A useful template library to get started in Advent of Code with Scala
    <br />
    <br />
    <a href="https://github.com/Kevincav/AdventOfCodeFramework/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
    ·
    <a href="https://github.com/Kevincav/AdventOfCodeFramework/issues/new?labels=enhancement&template=feature-request---.md">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a>
        <ul>
            <li><a href="#setting-up-for-a-new-aoc-day">Setting up for a new AoC day</a></li>
            <li><a href="#building-your-solution">Building your solution</a></li>
            <li><a href="#testing-your-solution">Testing your solution</a></li>
            <li><a href="#submitting-your-changes-and-grabbing-solution-results">Submitting your changes and grabbing solution results</a></li>
        </ul>
    </li>
    <li><a href="#rate-limiter">Rate Limiter</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This project is a framework for scala users to easily get started with Advent of Code submissions.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

 [![Scala][Scala.js]][Scala-url]<br>
 [![Github-Actions][Github-actions.js]][Github-actions-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple example steps.

### Prerequisites

* java
  ```sh
  brew install openjdk
  ```

* scala
  ```sh
  brew install scala
  ```
  
* [Fetch your Advent of Code Session Cookie](https://github.com/GreenLightning/advent-of-code-downloader?tab=readme-ov-file#how-do-i-get-my-session-cookie)
 

* Set your cookie session
  ```shell
  echo 'export AOC_COOKIE_SESSION="<cookie session>"' >> ~/.zshrc
  ```

* Set your user agent
  ```shell
  echo 'export AOC_USER_AGENT="https://github.com/yourrepo/AdventOfCode by youremail@domain.com"' >> ~/.zshrc
  ```

* Set the flag to submit answers programmatically
  ```shell
  echo 'export AOC_SUBMIT_ANSWERS=true' >> ~/.zshrc
  ```

* Set the throttle flag
  ```shell
  echo 'export AOC_SUBMISSION_THROTTLE=5' >> ~/.zshrc
  ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/Kevincav/AdventOfCodeFramework.git
   ```
2. Change git remote url to avoid accidental pushes to base project
   ```sh
   git remote set-url origin Kevincav/AdventOfCodeFramework
   git remote -v # confirm the changes
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

### Setting up for a new AoC day

1. Run the Github Action [File Downloader](https://github.com/Kevincav/AdventOfCodeFramework/actions/workflows/build-daily-files.yml) (This action should run at midnight every day from Dec 1st - 25th)

3. Pull the newest version of the code
   ```sh
    git pull
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Building your solution

1. Parse your input into the needed data type for the run and add that to the setup function
2. Write the code for solution 1 and add that to the solution1 function
3. Write the code for solution 2 and add that to the solution2 function

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Testing your solution
1. Run the days solutions with the example data
   ```shell
   sbt 'testOnly *org.advent.year{year}.Day{day}Test' 
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>
   
### Submitting your changes and grabbing solution results
1. Make your changes
   ```
   git add .
   git commit -am "I have made some changes."
   ```
2. Push your commit
   ```
   git push origin develop
   ```
3. Check your most recent [actions run](https://github.com/Kevincav/AdventOfCodeFramework/actions) for details

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- RATE LIMITING -->
## Rate Limiter

This repo/tool does follow the [automation guidelines](https://www.reddit.com/r/adventofcode/wiki/faqs/automation) on the /r/adventofcode community wiki. Specifically:

1. Outbound calls are throttled to every N minutes (defined by environmental variable AOC_SUBMISSION_THROTTLE) in pushAnswer()
2. Automated submissions can be turned off by setting the environmental variable AOC_SUBMIT_ANSWERS to false
3. Solution inputs are downloaded and committed daily at midnight through GitHub Actions (only December 1-25 every year)
4. Once inputs are downloaded, they are cached locally in `src/main/resources`
5. If you suspect your input is corrupted, you can manually request a fresh copy by running the `input-aoc-solution-data` [GitHub Action](https://github.com/Kevincav/AdventOfCodeFramework/actions/workflows/input-aoc-solution-data.yml)
6. The User-Agent header is set through GitHub Action Secrets

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ROADMAP -->
## Roadmap
* Setup API / REST call to submit answers for the day (instead of manual submissions)
* Setup Rate Limiter for REST submission


See the [open issues](https://github.com/Kevincav/AdventOfCodeFramework/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Top contributors:

<a href="https://github.com/Kevincav/AdventOfCodeFramework/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Kevincav/AdventOfCodeFramework" alt="contrib.rocks image" />
</a>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Project Link: [https://github.com/Kevincav/AdventOfCodeFramework](https://github.com/Kevincav/AdventOfCodeFramework)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* []()

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/Kevincav/AdventOfCodeFramework.svg?style=for-the-badge
[contributors-url]: https://github.com/Kevincav/AdventOfCodeFramework/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/Kevincav/AdventOfCodeFramework.svg?style=for-the-badge
[forks-url]: https://github.com/Kevincav/AdventOfCodeFramework/network/members
[stars-shield]: https://img.shields.io/github/stars/Kevincav/AdventOfCodeFramework.svg?style=for-the-badge
[stars-url]: https://github.com/Kevincav/AdventOfCodeFramework/stargazers
[issues-shield]: https://img.shields.io/github/issues/Kevincav/AdventOfCodeFramework.svg?style=for-the-badge
[issues-url]: https://github.com/Kevincav/AdventOfCodeFramework/issues
[license-shield]: https://img.shields.io/github/license/Kevincav/AdventOfCodeFramework.svg?style=for-the-badge
[license-url]: https://github.com/Kevincav/AdventOfCodeFramework/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 
[Scala.js]: https://img.shields.io/badge/Scala-20232A?style=for-the-badge&logo=scala&logoColor=61DAFB
[Scala-url]: https://www.scala-lang.org/
[aoc-shield]: https://img.shields.io/badge/Advent%20Of%20Code-0769AD?style=for-the-badge&logo=adventofcode&logoColor=white
[aoc-url]: https://adventofcode.com/
[Github-actions.js]: https://img.shields.io/badge/Github%20Actions-20232A?style=for-the-badge&logo=githubactions&logoColor=61DAFB
[Github-actions-url]: https://github.com/features/actions
