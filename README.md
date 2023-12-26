## primechecker-azure-java

An Azure Function implemented in Java for checking whether or not a number is prime.

## Build status

[![Build and deploy Java project to Azure Function App - primechecker](https://github.com/lucproglangcourse/primechecker-azure-java/actions/workflows/main_primechecker.yml/badge.svg)](https://github.com/lucproglangcourse/primechecker-azure-java/actions/workflows/main_primechecker.yml)

[![CodeQL](https://github.com/lucproglangcourse/primechecker-azure-java/actions/workflows/codeql.yml/badge.svg)](https://github.com/lucproglangcourse/primechecker-azure-java/actions/workflows/codeql.yml)

## Learning objectives

- Show how CPU-intensive computation can be off-loaded from a mobile app to
  the cloud, by comparison to a mobile device, an unlimited resource for
  computation and storage.

- End-to-end example of continuous integration (CI), continuous
  deployment/delivery (CD), and DevOps in Java using Azure Functions.

See also the
[corresponding mobile app](https://github.com/LoyolaChicagoCode/primenumbers-android-scala).

## Prerequisites

See [Quickstart: Create a Java function in Azure from the command line](https://learn.microsoft.com/en-us/azure/azure-functions/create-first-function-cli-java).


## How to use

Test with

    $ mvn test

Run locally with

    $ mvn azure-functions:run

and use via the provided local URLs.

## Sample prime numbers to try

- [1013](https://primechecker.azurewebsites.net/api/isPrime?number=1013)
- [10007](https://primechecker.azurewebsites.net/api/isPrime?number=10007)
- [100003](https://primechecker.azurewebsites.net/api/isPrime?number=100003)
- [1000003](https://primechecker.azurewebsites.net/api/isPrime?number=1000003)
- [10000169](https://primechecker.azurewebsites.net/api/isPrime?number=10000169)
- [100000007](https://primechecker.azurewebsites.net/api/isPrime?number=100000007)

## Sample non-prime numbers to try

- [999989](https://primechecker.azurewebsites.net/api/isPrime?number=999989)

## References

- [Jason Christensen's OOPSLA 2009 presentation](http://www.slideshare.net/jasonc411/oopsla-2009-combining-rest-and-cloud-a-practitioners-report)
- [James Earl Douglas's SBTB 2014 presentation](https://www.youtube.com/watch?v=sZYAFWTyOlE)
- [Quickstart: Create a Java function in Azure from the command line](https://learn.microsoft.com/en-us/azure/azure-functions/create-first-function-cli-java)
