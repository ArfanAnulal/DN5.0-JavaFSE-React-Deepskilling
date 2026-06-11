# Spring Data JPA and Hibernate Exercises

This directory contains the Spring Data JPA implementation for the employee, country, and stock querying exercises.

## Project Structure

- **[orm-learn](file:///c:/Users/bened/Downloads/Misson_Cognizant/Week_2/SpringDataJPA/orm-learn)**: Spring Boot project implementing JPA repositories, custom query methods, exception handling, and database schemas.
- **[schema.sql](file:///c:/Users/bened/Downloads/Misson_Cognizant/Week_2/SpringDataJPA/orm-learn/src/main/resources/schema.sql)**: DDL schema script initializing the H2 database tables.
- **[data.sql](file:///c:/Users/bened/Downloads/Misson_Cognizant/Week_2/SpringDataJPA/orm-learn/src/main/resources/data.sql)**: DML script seeding test data for countries and stocks.

## Implementations Covered

1. **JPA Entity Mapping**:
   - `Country`: Maps 2-character country codes and names.
   - `Stock`: Maps ticker codes, dates, prices (open/close), and trading volumes.
2. **Derived Query Methods**:
   - `findByNameContaining`: Finding matching records by partial name substring.
   - `findByNameContainingOrderByNameAsc`: Retrieving partial matches sorted alphabetically.
   - `findByNameStartingWith`: Matching country prefixes.
3. **Custom Ticker Enquiries**:
   - Querying stocks within date windows (`findByCodeAndDateBetween`).
   - Querying closing prices above a value threshold (`findByCodeAndCloseGreaterThan`).
   - Slicing top metrics using `findTop3ByOrderByVolumeDesc` and `findTop3ByCodeOrderByCloseAsc`.

## Execution Logs

The build and console execution output is located in [output_june17.txt](file:///c:/Users/bened/Downloads/Misson_Cognizant/Week_2/SpringDataJPA/orm-learn/output_june17.txt).
