# JUnit, Mockito, and SLF4J Component

This project demonstrates software testing and enterprise logging best practices, utilizing JUnit 5 (JUnit Jupiter), Mockito 5, and the SLF4J facade with Logback as the underlying logging provider.

## Component Structure

* **com.testing.junit.BankAccount**: Simple bank domain class containing business logic (depositing, withdrawing, and validation checks).
* **com.testing.junit.BankAccountTest**: Unit test suite verifying lifecycle annotations (`@BeforeEach`, `@AfterEach`) and assertions (`assertEquals`, `assertThrows`, `assertNull`, `assertNotNull`).
* **com.testing.mockito.ExternalApi**: Decoupled interface representing a remote service or database dependency.
* **com.testing.mockito.MyService**: Service class utilizing dependency injection to perform operations using the ExternalApi.
* **com.testing.mockito.MyServiceTest**: Mockito test suite showcasing stubbing and interaction verification.
* **com.testing.logging.LoggingService**: Logs error messages using SLF4J.
* **com.testing.logging.LoggingTest**: Verification test asserting that SLF4J appends error logs to a local file (`app.log`).

## How to Run

Compile and run all unit tests:
```bash
mvn clean test
```
