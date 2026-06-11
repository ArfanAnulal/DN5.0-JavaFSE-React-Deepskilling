# LibraryManagement - Spring XML & AOP

This module demonstrates the traditional XML configuration and AOP wiring in Spring Core.

## Features Implemented

1. **Spring Beans Configuration (Exercise 1 & 5)**:
   - Configures the `BookRepository` and `BookService` beans in the Spring IoC container using XML metadata in `applicationContext.xml`.
2. **Dependency Injection (Exercise 2 & 7)**:
   - Implements both setter injection and constructor injection.
   - Beans are wired in the configuration via `<property>` attributes referencing the target beans.
3. **AspectJ Logging (Exercise 3 & 8)**:
   - Uses AspectJ runtime and weaver to define AOP logging aspects.
   - Tracks method execution times with Around advice.
   - Logs entry and exit points of service layer methods using Before and After advices.

## Execution and Logs

The application compile-and-run output is logged in [output.txt](file:///c:/Users/bened/Downloads/Misson_Cognizant/Week_2/SpringCoreMaven/LibraryManagement_XML/output.txt).
