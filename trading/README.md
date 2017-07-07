# Small FX trading REST service

## How to launch?

1. Navigate to the parent pom file (where the mvnw file is).
2. Install all dependencies:
```
mvnw install
```
3. Launch service
```
mvnw spring-boot:run -pl fx-service
```
4. Launch client
```
mvnw spring-boot:run -pl fx-client
```

The fx-client will submit the sample trades (`fx-client/src/main/resources/test-trade-data.json`) and if all goes well, you shoudl see something like this:

```
2017-07-07 13:59:30.137  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Starting MainApplication on zarusz with PID 4872 (E:\dev\work\Workspace\trading\fx-client\target\classes started by Tomasz in e:\dev\work\Workspace\trading)
2017-07-07 13:59:30.140  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : No active profile set, falling back to default profiles: default
2017-07-07 13:59:30.268  INFO 4872 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@12e78d25: startup date [Fri Jul 07 13:59:30 CEST 2017]; root of context hierarchy
2017-07-07 13:59:31.888  INFO 4872 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2017-07-07 13:59:31.930  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Loading sample trades...
2017-07-07 13:59:32.421  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Posting trades to REST service (http://localhost:8080/trade/batch)...
2017-07-07 13:59:33.254  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Got response from REST service.
2017-07-07 13:59:33.254  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #1 was successful, transaction ID: 6f18cd13-fb90-404f-8192-6db731d84959
2017-07-07 13:59:33.257  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #2 was successful, transaction ID: 4916afef-a7fa-4b1c-b1ca-0fa5302328e3
2017-07-07 13:59:33.257  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #3 was successful, transaction ID: 578dec11-8243-417c-b5ae-13d18730e30b
2017-07-07 13:59:33.257  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #4 was rejected
2017-07-07 13:59:33.258 ERROR 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #4 validation error #0 - code: ERR0010 message: Value date cannot fall on weekend or non-working day for currency
2017-07-07 13:59:33.258  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #5 was rejected
2017-07-07 13:59:33.258 ERROR 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #5 validation error #0 - code: ERR0010 message: Value date cannot be before trade date
2017-07-07 13:59:33.258  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #6 was rejected
2017-07-07 13:59:33.258 ERROR 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #6 validation error #0 - code: ERR0020 message: The customer is not recognized
2017-07-07 13:59:33.258 ERROR 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #6 validation error #1 - code: ERR0010 message: Value date cannot be before trade date
2017-07-07 13:59:33.258  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #7 was rejected
2017-07-07 13:59:33.259 ERROR 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #7 validation error #0 - code: ERR0020 message: The customer is not recognized
2017-07-07 13:59:33.259  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #8 was successful, transaction ID: 28a9e02a-6dd6-4b1b-9cd1-92cdd1385536
2017-07-07 13:59:33.259  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #9 was successful, transaction ID: d29a421a-f61b-4050-ad57-3901320c2cb4
2017-07-07 13:59:33.259  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #10 was rejected
2017-07-07 13:59:33.259 ERROR 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #10 validation error #0 - code: ERR0070 message: Expiry date must be before the delivery date
2017-07-07 13:59:33.259  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #11 was rejected
2017-07-07 13:59:33.259 ERROR 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #11 validation error #0 - code: ERR0080 message: Premium date must be before the delivery date
2017-07-07 13:59:33.260  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #12 was rejected
2017-07-07 13:59:33.260 ERROR 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #12 validation error #0 - code: ERR0060 message: ExcerciseStartDate must be after trade date
2017-07-07 13:59:33.260 ERROR 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #12 validation error #1 - code: ERR0080 message: Premium date must be before the delivery date
2017-07-07 13:59:33.260  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #13 was rejected
2017-07-07 13:59:33.260 ERROR 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #13 validation error #0 - code: ERR0070 message: Expiry date must be before the delivery date
2017-07-07 13:59:33.260 ERROR 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #13 validation error #1 - code: ERR0080 message: Premium date must be before the delivery date
2017-07-07 13:59:33.260  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #14 was rejected
2017-07-07 13:59:33.260 ERROR 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #14 validation error #0 - code: ERR0060 message: ExcerciseStartDate must be after trade date
2017-07-07 13:59:33.260 ERROR 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #14 validation error #1 - code: ERR0080 message: Premium date must be before the delivery date
2017-07-07 13:59:33.260  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #15 was rejected
2017-07-07 13:59:33.261 ERROR 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #15 validation error #0 - code: ERR0020 message: The customer is not recognized
2017-07-07 13:59:33.261 ERROR 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #15 validation error #1 - code: ERR0060 message: ExcerciseStartDate must be after trade date
2017-07-07 13:59:33.261 ERROR 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Trade #15 validation error #2 - code: ERR0080 message: Premium date must be before the delivery date
2017-07-07 13:59:33.262  INFO 4872 --- [           main] com.cs.fx.fxclient.MainApplication       : Started MainApplication in 4.279 seconds (JVM running for 11.432)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 9.480 s
[INFO] Finished at: 2017-07-07T13:59:33+02:00
[INFO] Final Memory: 35M/536M
[INFO] ------------------------------------------------------------------------
2017-07-07 13:59:33.510  INFO 4872 --- [       Thread-2] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@12e78d25: startup date [Fri Jul 07 13:59:30 CEST 2017]; root of context hierarchy
2017-07-07 13:59:33.513  INFO 4872 --- [       Thread-2] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown

```


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

## Extra

* Add REST API documentation (by using [Spring REST Docs](http://www.baeldung.com/spring-rest-docs) or [Swagger](https://swagger.io/))
* Scalability could be achieved by:
  * Making the REST method [asynchronious](http://carlmartensen.com/completablefuture-deferredresult-async), yet care should be taken to execute orders in order.
  * Partitioning the processing (e.g. based on currency pairs). Also assign more processors to the most popular currency pairs.
  * The OrderManager should be behind some messaging service (scalability and availability). For example for Apache Kafka each topic could be individual currency pair.
  * The implementations (e.g. CustomerRepostitory) could be decorated in a cached implementation (if the mocks would be replaced by DB impementations).
  
