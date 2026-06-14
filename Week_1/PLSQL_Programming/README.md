# PL/SQL Programming

This component contains database scripts and PL/SQL blocks covering control structures and stored procedures.

## Repository Files

* **schema.sql**: Database schema (DDL) creating the tables: `Customers`, `Accounts`, `Transactions`, `Loans`, `Employees`, and `AuditLog`.
* **sample_data.sql**: Seed data inserting records to demonstrate script execution.
* **exercise1.sql (Control Structures)**:
  - Updates senior customer loan rates by applying a 1% discount.
  - Automatically flags customers as VIP if their balance exceeds $10,000.
  - Queries and prints loan payment reminders for loans due in 30 days.
* **exercise3.sql (Stored Procedures)**:
  - `ProcessMonthlyInterest`: Bulk updates savings accounts by adding 1% interest.
  - `UpdateEmployeeBonus`: Updates employee salaries by department.
  - `TransferFunds`: Core fund transfer logic checking balance requirements.

## How to Test

These scripts can be executed inside any Oracle database command-line utility:

1. Run the database setup script:
   ```sql
   @schema.sql
   ```
2. Insert sample data:
   ```sql
   @sample_data.sql
   ```
3. Execute any specific PL/SQL exercise script:
   ```sql
   @exercise1.sql
   ```
