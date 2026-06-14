# JUnit, Mockito, and SLF4J Component

This project demonstrates software testing and enterprise logging best practices, utilizing JUnit 5 (JUnit Jupiter), Mockito 5, and the SLF4J facade with Logback as the underlying logging provider.

---

## Component Structure

* **com.testing.junit.BankAccount**: Simple bank domain class containing business logic (depositing, withdrawing, and validation checks).
* **com.testing.junit.BankAccountTest**: Unit test suite verifying lifecycle annotations (`@BeforeEach`, `@AfterEach`) and assertions (`assertEquals`, `assertThrows`, `assertNull`, `assertNotNull`).
* **com.testing.mockito.ExternalApi**: Decoupled interface representing a remote service or database dependency.
* **com.testing.mockito.MyService**: Service class utilizing dependency injection to perform operations using the ExternalApi.
* **com.testing.mockito.MyServiceTest**: Mockito test suite showcasing stubbing, verifications, argument matching, exception triggers, and interaction order checks.
* **com.testing.logging.LoggingService**: Logs messages at multiple threshold levels (`TRACE`, `DEBUG`, `INFO`, `WARN`, `ERROR`) and demonstrates parameterized logging.
* **com.testing.logging.LoggingTest**: Verification test asserting that SLF4J appends outputs to a local file (`app.log`).

---

## Detailed Learnings

### 1. Unit Testing with JUnit 5
* **Arrange-Act-Assert (AAA)**: Tests are divided into three distinct steps:
  1. *Arrange*: Set up the test state and instantiate target classes.
  2. *Act*: Trigger the target behavior (method invocation).
  3. *Assert*: Check results against expectations.
* **Test Fixtures & Lifecycles**: `@BeforeEach` instantiates a fresh class fixture before every test run, and `@AfterEach` performs cleanup. This ensures test independence, avoiding shared state errors.
* **Assertions**: We used specific assertions rather than simple boolean checks. For instance, `assertThrows` validates exception boundaries, ensuring negative inputs throw correct exception classes.

### 2. Decoupling and Mocking with Mockito
* **Mocks**: Simulates dependency structures. It prevents unit tests from triggering network or database operations.
* **Stubbing**: Configuring mock interfaces to return predefined values when target methods are called (`when().thenReturn()`). We stubbed:
  - Simple responses.
  - Multi-return sequences (returning different strings on subsequent calls).
* **Interaction Verification**: Enforces behavior verification. Using `verify()` and `times()`, we assert that the service calls its dependencies the expected number of times. We also used `inOrder()` to verify execution sequences.
* **Argument Matching**: Using matchers like `anyString()` or `eq()` to stub methods without binding tests to static values.
* **Exception Triggers**: Simulating system failures by stubbing void methods to throw exceptions (`doThrow().when()`).

### 3. Enterprise Logging with SLF4J and Logback
* **Facade Pattern**: SLF4J is a facade (abstraction) for logging. It decouples the application from concrete logging engines (like Logback or Log4j). If we switch logging frameworks, we do not edit logging statements in our code.
* **Logging Levels**: We categorized logs to filter outputs:
  - `TRACE` / `DEBUG`: Detailed information for developers.
  - `INFO`: Significant runtime milestones.
  - `WARN`: Recoverable anomalies.
  - `ERROR`: Major operations failures.
* **Parameterized Logging**: Using placeholders `logger.info("User {} logged in", username)`. The framework avoids runtime string concatenations when log levels are disabled, saving memory and CPU cycles.
* **Appenders**: Configured in [logback.xml](file:///c:/Users/bened/Downloads/Misson_Cognizant/Week_1/JUnit_Mockito_SLF4J/src/main/resources/logback.xml):
  - *ConsoleAppender*: Prints formatted logs to standard output.
  - *FileAppender*: Appends logs to `app.log` in the project root directory.

---

## How to Run

Compile and run all unit tests:
```bash
mvn clean test
```

### Verified Execution Output

```text
[INFO] Running com.testing.junit.BankAccountTest
Test setup: account initialized with $1000
Test teardown complete.
Test setup: account initialized with $1000
Test teardown complete.
Test setup: account initialized with $1000
Test teardown complete.
Test setup: account initialized with $1000
Test teardown complete.
Test setup: account initialized with $1000
Test teardown complete.
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.079 s -- in com.testing.junit.BankAccountTest
[INFO] Running com.testing.logging.LoggingTest
22:33:03.550 [main] DEBUG com.testing.logging.LoggingService - Debug log message
22:33:03.551 [main] INFO  com.testing.logging.LoggingService - Info log message
22:33:03.552 [main] WARN  com.testing.logging.LoggingService - Warn log message
22:33:03.552 [main] ERROR com.testing.logging.LoggingService - Error log message
22:33:03.552 [main] INFO  com.testing.logging.LoggingService - User 'johndoe' performed action 'PAY_LOAN' with transaction reference #12345
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.278 s -- in com.testing.logging.LoggingTest
[INFO] Running com.testing.mockito.MyServiceTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.160 s -- in com.testing.mockito.MyServiceTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
```
