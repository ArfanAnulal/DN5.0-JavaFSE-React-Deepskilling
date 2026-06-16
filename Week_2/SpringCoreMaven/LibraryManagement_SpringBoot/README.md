# LibraryManagement - Spring Boot Bootstrap

This module migrates the Library Management application to Spring Boot 3, using starter dependencies and standard autoconfiguration bootstrap.

## Features Implemented

1. **Spring Boot Bootstrap (Exercise 9)**:
   - Configures `spring-boot-starter-parent` and standard starter dependencies.
   - Initialized via a main class annotated with `@SpringBootApplication`.
   - Uses `SpringApplication.run` to automatically create and refresh the ApplicationContext.
2. **Spring Boot Auto-configuration**:
   - Leverages Boot to eliminate the need for XML configuration, using `@SpringBootApplication` which includes `@ComponentScan` and `@EnableAutoConfiguration` under the hood.

## Execution and Logs

The Spring Boot runtime and console outputs are captured in [output.txt](file:///c:/Users/bened/Downloads/Misson_Cognizant/Week_2/SpringCoreMaven/LibraryManagement_SpringBoot/output.txt).
