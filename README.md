# Programmer's Friend Log Binding for Log4j2

The Programmer's Friend (PF) libraries are all logging against their own logging API provided by component *pf-logging*.  
That has the advantage of not having a fixed dependency to any of the multiple logging frameworks in the Java world.

However, when using PF libraries in any application, the logging of the PF libraries should be routed to loggers of the
logging framework the application is using.

Therefore PF provides binding libraries for the most prominent logging frameworks.

This component is providing the binding to the [Apache Log4J2 logging framework](https://logging.apache.org/log4j/2.x/manual/).  
It is compiled with **Java 6**.

## Usage

In order to route all PF logging to *log4j2*, put *pf-logbind-log4j2-x.x.x.jar* on the classpath and activate it with
the following system property:

> -Dorg.pfsw.logging.binding=LOG4J2

Alternatively you can activate the log binding programmatically by executing the following:

````java
org.pfsw.logging.LoggerFactoryProvider.setDefaultFactoryName("LOG4J2")
````

## Dependency Management

You can find this library in *Programmer's Friend* maven repository ``http://pfsw.org/maven/repo/``
or on *jcenter*.

The library itself has *runtime* dependencies to **org.pfsw:pf-logging:3.1.0** and **org.apache.logging.log4j:log4j-api:2.3**.


Include the library into your project:

**Gradle:**

````
compile group: 'org.pfsw', name: 'pf-logbind-log4j2', version: '1.1.0'
````

**Maven:**

````
<dependency>
    <groupId>org.pfsw</groupId>
    <artifactId>pf-logbind-log4j2</artifactId>
    <version>1.1.0</version>
</dependency>
````


## Build

The library can be build with its associated gradle wrapper:

``./gradlew clean build``

