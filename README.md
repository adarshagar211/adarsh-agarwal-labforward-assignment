# Labforward Data Service - Microservice

Labforward Data Service - MicroService production ready Springboot application built on Spring 5 / Java 11 .

it contains two api's :  1) To find frequency of word pattern in labnotes 
                         2) To find similar words in labnotes matching with word pattern  

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:
 
Java JDK 11
Maven 3+ or higher
Git
Spring 5

Clone the project and use Maven to build the server

$ mvn clean install

## Running test cases

Run a Spring Boot test cases

There are several ways to run a tests on your local machine. One way is to execute the `Run as-> Junit Test` on src/test/java folder from STS IDE.

Other way is to run below command on root folder : 

```shell
mvn clean test
```

## Running the application locally

Prerequisite : Existing PostGres running on "localhost", portno "5432", database "postgres" with username :postgres & password: password

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.payconiq.StocksApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## After running the application

Once Application is up and running on docker or on jvm , check the API documentation on below swagger url : 

```shell
Swagger URL  :  http://localhost:8080/docs
Swagger URL  :  http://localhost:8080/swagger-ui/index.html
```
  
### Contact

Adarsh Agarwal - adarsh.agar211@gmail.com

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
