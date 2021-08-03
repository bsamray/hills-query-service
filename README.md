## Project for querying hills using various criteria

## Getting Started

This is a project built with [Spring Boot](http://projects.spring.io/spring-boot/) REST web services application.

## API Documentation

The Swagger API specification for accessing REST API exposed by this project is available at 
resources/public/spec-api.yml

This specification can also be accessed when the service is running at the /spec-api.yml 
endpoint (e.g. http://localhost:8080/spec-api.yml)
Sample query for the application when running is given below:

http://localhost:8080/v1/hills?sort=NAME&order=ASC&limit=10&min_ht=3200&max_ht=3500

## Installation

### Getting the project

Clone the [hills-query-service](https://github.com/bsamray/hills-query-service.git) project on GitHub.  

### Dependencies

The project requires the following dependencies be installed on the host machine:
Java Development Kit 11 or later
Maven

### Code Style

This project uses Intellij IDEA Default code styling

## Running

The project supports [Maven](http://maven.apache.org/) for managing the project lifecycle.  

### Important commands

Below maven goals are used in important commands issued at the project root directory to operate the project

#### spring-boot:run

Below command is for a non-prod environment and this launches the application on the embedded Tomcat server.
The version and artifact attributes are part of the JAR file name.
Please use the 'server.port' argument if you wish to change the default HTTP port 8080.

```
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=8089"
```

#### test

The command below runs the unit test suites against the main source code.

```
./mvnw clean test
```

#### package

The command below prepares the JAR deployable file in the target directory for distribution to server environments.

```
./mvnw clean package
```
The JAR file can be run using the below command at the project root. 
The version and artifact attributes are part of the JAR file name. 
Please use the 'server.port' argument if you wish to change the default HTTP port 8080.
```
java -jar target/hills-query-service-0.0.1-SNAPSHOT.jar --server.port=8089
```

## Health check and Monitoring

The actuator endpoints for health check and monitoring are available at the following endpoints 
(assumes 8080 is the server port)

Application Health
```
http://localhost:8080/actuator/health

```
Application Information
```
http://localhost:8080/actuator/info

```
Application Information
```
    http://localhost:8080/actuator/info

```
Application loggers
```
http://localhost:8080/actuator/loggers

```
## Containerisation

A docker image can be built using the Dockerfile in the project root directory using the Dockerfile provided. 
The tag name is provided in the command.

```
docker build . -t xd/hills-service
```
Once this successfully runs, below command can be used to see the new image in the list of docker images.
```
docker images
```
The image can be run on a container using the below command. 
8080 is the target port, which can be changed with providing an accompanying server port environment variable. 
```
docker run  -e -p 8080:8080 xd/hills-service
```


