# Programmer's Friend Log Binding for Log4j2

The Programmer's Friend (PF) libraries are all logging against their own logging API provided by component _pf-logging_.  
That has the advantage of not having a fixed dependency to any of the multiple logging frameworks in the Java world.

However, when using PF libraries in any application, the logging of the PF libraries should be routed to loggers of the
logging framework the application is using.

Therefore PF provides binding libraries for the most prominent logging frameworks.

This component is providing the binding to the [Apache Log4J2 logging framework](https://logging.apache.org/log4j/2.x/manual/).  
It is compiled with __Java 6__.

## Usage

In order to route all PF logging to _log4j2_, put _pf-logbind-log4j2-x.x.x.jar_ on the classpath and activate it with
the following system property:

> -Dorg.pfsw.logging.binding=LOG4J2

Alternatively you can activate the log binding programmatically by executing the following:

```java
org.pfsw.logging.LoggerFactoryProvider.setDefaultFactoryName("LOG4J2")
```

## Dependency Management

You can find this library in _Programmer's Friend_ maven repository ``http://pfsw.org/maven/repo/``
or on _jcenter_.

The library itself has _runtime_ dependencies to __org.pfsw:pf-logging:3.1.0__ and __org.apache.logging.log4j:log4j-api:2.3__.


Include the library into your project:

__Gradle:__

```
compile group: 'org.pfsw', name: 'pf-logbind-log4j2', version: '1.0.0'
```

__Maven:__

```
<dependency>
    <groupId>org.pfsw</groupId>
    <artifactId>pf-logbind-log4j2</artifactId>
    <version>1.0.0</version>
</dependency>
```


## Build

The library can be build with its associated gradle wrapper:

``./gradlew clean build``

