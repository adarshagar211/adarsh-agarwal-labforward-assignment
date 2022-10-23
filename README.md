
# Labforward Data Service - Web Application

Labforward Data Service - Application production ready Springboot Web Application built using Spring 5 / Java 11 .

LabForward Web Application contains "Search"  and "Index" textboxs  and three buttons "Frequency" ,"Matching" , "ClearAll"  .

 - "Frequency" button -> Calls API to find frequency of word pattern in
   lab entry
 - "Matching" button  -> Calls API to find similar words in lab entry
   matching with word
 - "ClearAll" button  -> Clears all result

            
After running the application you can check below link: 
```shell
 http://localhost
```           
          
[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

 - Java JDK 11 
 - Spring 5
 - UI (HTML ,JQuery, AJAX, BootStrap)
 - Maven 3+ or higher
 - Git

## About the project
 
 Its created as a SpringBoot production ready application which runs on embedded Tomcat server. This project can simply be imported as maven project and can run on Eclipse or IntelliJ or run directly using below command. 
 
 ```shell
mvn spring-boot:run
```
It has no external dependencies and reads internal file  "labnotes.txt" to find the lab entries. Scheduler is used for optimizing API's response . UI gives good look and feel to application and useful for testing. 
 
 Two APi's built : 
 - Getting Frequency of word in labnotes ->  /api/data/frequency/{pattern}?labEntryIndex={value} 
 - Getting similar words in labnotes     ->  /api/data/similar/{pattern}?labEntryIndex={value}  
 
Added some Junits around controller for API and validation testing
API thows Exception Error  : 
 -  search word is not alphanumeric - Response status is 422
   Unprocessable Entity. 
  - labnotes is empty  - Response status is
   500 Internal Server Error  
  - Incase of unexpected error on
   server - Response status is 500 Internal Server Error

 

Please check swagger URL for testing and more documentation on API's

## Running test cases

Run a Spring Boot test cases

There are several ways to run a tests on your local machine. One way is to execute the `Run as-> Junit Test` on src/test/java folder from STS IDE.

Other way is to run below command on root folder : 

```shell
mvn clean test
```

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.labforward.DataServiceApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## After running the application

Once Application is up and running on jvm , check the API documentation on below swagger url : 

```shell
UI url       : http://localhost

Swagger URL  :  http://localhost/docs
Swagger URL  :  http://localhost/swagger-ui/index.html
```

## Scope for Improvements

We could add spring security like token, OAuth, decouple different component to give better architecture,  dockerize the whole application, add more test cases ,add caching and feature wise made application more dynamic e.g. ability to add/update lab entry through UI . 
  
### Contact

Adarsh Agarwal - adarsh.agar211@gmail.com

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
