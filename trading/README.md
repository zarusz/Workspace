# Small FX trading REST service

## How to launch?

1. Navigate to the parent pom file (where the mvnw file is).

2. Install all dependencies:

`mvnw install`

3. Launch service

`mvnw spring-boot:run -pl fx-service`

4. Launch client
`mvnw spring-boot:run -pl fx-client`

## Technology Stack

* Java 8
* Spring Boot
* Spring Framework
* Maven

## Architecture

The project is a multi-module maven project.

Layers
* `fx-domain-model` - domain model, if there would be more domain logic (beyond just validation) it would go here.
* `fx-data-access-mock` - mocks for some external services or infrastructure (db).
* `fx-service` - the web application (WAR), spring web/mvc that exposes the REST service.
* `fx-client` - the console application (JAR), that posts the sample trades to the service. 
* `fx-service-model` -  DTOs (data transfer objects) defining the contract of the REST endpoint. This is shared between client and service.

## Assumptions

* Few additional validation rules were added.
* Infrastructure has been mocked (no DB connectivity).
* Validation should be extensible.