# SpeakingClock
SpeakingClock
 

## Description
This utility is used to convert digital time to human readable time

## Technology

- **Spring Boot**     - Server side framework
- **Lombok**          - Provides automated getter/setters
- **Swagger**         - In-built swagger documentation support
- **Junit**           - Unit testing framework

## Application Structure

## Running the server locally
The Speaking Clock application can be started using your favourite IDE and its run configuration support. If you are a terminal savvy, please use the following command -

````
mvn spring-boot:run
````
 

## Swagger Documentation
Swagger documentation is in-built in this starter-kit and can be accessed at the following URL -
````
http://localhost:8086/swagger-ui.html
http://localhost:8086/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/clock-controller/getReadableTime
````


## Unit test cases
There are multiple unit test cases written to cover the different components of the application.
````
mvn clean test  
````
 
