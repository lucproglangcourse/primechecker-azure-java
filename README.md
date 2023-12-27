## primechecker-azure-java

An Azure Function implemented in Java for checking whether or not a number is prime.

## Build status

- Dynamic  
[![7-day Uptime Azure](https://img.shields.io/uptimerobot/ratio/7/m796031558-dca4663f9bf08f06224b02a3)](https://primechecker.azurewebsites.net/api/isPrime)
[![Build and deploy Java project to Azure Function App - primechecker](https://github.com/lucproglangcourse/primechecker-azure-java/actions/workflows/main_primechecker.yml/badge.svg)](https://github.com/lucproglangcourse/primechecker-azure-java/actions/workflows/main_primechecker.yml)
![Commit Activity](https://img.shields.io/github/commit-activity/m/lucproglangcourse/primechecker-azure-java)
[![Average time to resolve an issue](http://isitmaintained.com/badge/resolution/lucproglangcourse/primechecker-azure-java.svg)](http://isitmaintained.com/project/lucproglangcourse/primechecker-azure-java "Average time to resolve an issue")
[![Percentage of issues still open](http://isitmaintained.com/badge/open/lucproglangcourse/primechecker-azure-java.svg)](http://isitmaintained.com/project/lucproglangcourse/primechecker-azure-java "Percentage of issues still open")
- Structural  
![Code Size](https://img.shields.io/github/languages/code-size/lucproglangcourse/primechecker-azure-java)
[![codecov](https://img.shields.io/codecov/c/github/lucproglangcourse/primechecker-azure-java)](https://codecov.io/gh/lucproglangcourse/primechecker-azure-java)
[![CodeQL](https://github.com/lucproglangcourse/primechecker-azure-java/actions/workflows/codeql.yml/badge.svg)](https://github.com/lucproglangcourse/primechecker-azure-java/actions/workflows/codeql.yml)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/daea3df369bf457396bd7782a18a9aed)](https://app.codacy.com/gh/lucproglangcourse/primechecker-azure-java/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)
[![CodeFactor](https://img.shields.io/codefactor/grade/github/lucproglangcourse/primechecker-azure-java)](https://www.codefactor.io/repository/github/lucproglangcourse/primechecker-azure-java)
[![Maintainability](https://img.shields.io/codeclimate/maintainability/lucproglangcourse/primechecker-azure-java)](https://codeclimate.com/github/lucproglangcourse/primechecker-azure-java/maintainability)
[![Technical Debt](https://img.shields.io/codeclimate/tech-debt/lucproglangcourse/primechecker-azure-java)](https://codeclimate.com/github/lucproglangcourse/primechecker-azure-java/trends/technical_debt)
- Other  
[![License](http://img.shields.io/:license-apache-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)


## Learning objectives

- Show how CPU-intensive computation can be off-loaded from a mobile app to
  the cloud, by comparison to a mobile device, an unlimited resource for
  computation and storage.

- End-to-end example of continuous integration (CI), continuous
  deployment/delivery (CD), and DevOps in Java using Azure Functions.

See also the
[corresponding mobile app](https://github.com/LoyolaChicagoCode/primenumbers-android-scala).

## How to use

To use, put the number to be checked in the query string of the deployed function, e.g.

    https://primechecker.azurewebsites.net/api/isPrime?number=7


### Some sample primes to try

- [1013](https://primechecker.azurewebsites.net/api/isPrime?number=1013)
- [10007](https://primechecker.azurewebsites.net/api/isPrime?number=10007)
- [100003](https://primechecker.azurewebsites.net/api/isPrime?number=100003)
- [1000003](https://primechecker.azurewebsites.net/api/isPrime?number=1000003)
- [10000169](https://primechecker.azurewebsites.net/api/isPrime?number=10000169)
- [100000007](https://primechecker.azurewebsites.net/api/isPrime?number=100000007)
- [1000000000169](https://primechecker.azurewebsites.net/api/isPrime?number=1000000000169)
- [100000000000169](https://primechecker.azurewebsites.net/api/isPrime?number=100000000000169)

### Some non-primes to try

- [999989](https://primechecker.azurewebsites.net/api/isPrime?number=999989)
- [Long.MAX_VALUE](https://primechecker.azurewebsites.net/api/isPrime?number=9223372036854775807)
- [10000000000000000169](https://primechecker.azurewebsites.net/api/isPrime?number=10000000000000000169)
- [2 * Long.MAX_VALUE + 3](https://primechecker.azurewebsites.net/api/isPrime?number=18446744073709551617)

## Development

### Prerequisites

See [Quickstart: Create a Java function in Azure from the command line](https://learn.microsoft.com/en-us/azure/azure-functions/create-first-function-cli-java).

### Building and testing locally

Test with

    $ mvn test

Run locally with

    $ mvn azure-functions:run

and use via the provided local URLs.

### Managing via the Azure portal

Visit the [Function App](https://portal.azure.com/#view/HubsExtension/BrowseResource/resourceType/Microsoft.Web%2Fsites/kind/functionapp) section of the Azure portal.

A function app can have one or more functions.
Drill into a specific function:

    Home > Function App > primechecker > isPrime

In it's *Code + Test* section, you can verify the mapping between the function's published entry point and the corresponding method implementation:

    "entryPoint": "edu.luc.cs.cs371.primechecker.web.PrimeCheckerFunction.run",

<img src="doc/images/config.png" alt="JSON configuration for isPrime function" width="600"/>

There, you can press the *Test/Run* button to interact directly with the function:

<img src="doc/images/input.png" alt="JSON configuration for isPrime function" width="200"/>

<img src="doc/images/output.png" alt="JSON configuration for isPrime function" width="200"/>

## References

- [Jason Christensen's OOPSLA 2009 presentation](http://www.slideshare.net/jasonc411/oopsla-2009-combining-rest-and-cloud-a-practitioners-report)
- [James Earl Douglas's SBTB 2014 presentation](https://www.youtube.com/watch?v=sZYAFWTyOlE)
- [Quickstart: Create a Java function in Azure from the command line](https://learn.microsoft.com/en-us/azure/azure-functions/create-first-function-cli-java)
