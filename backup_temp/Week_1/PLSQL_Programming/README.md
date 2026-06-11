# PL/SQL Programming

This component contains database scripts and PL/SQL blocks developed to handle advanced database logic. The exercises cover relational database structures, stored procedures, exception handling, custom functions, event-driven triggers, explicit cursors, and modular packages.

---

## Repository Files

* **schema.sql**: Database schema (DDL) creating the tables: `Customers` (with VIP flag), `Accounts`, `Transactions`, `Loans`, `Employees`, and `AuditLog`.
* **sample_data.sql**: Seed data inserting records to demonstrate script execution.
* **exercise1.sql (Control Structures)**:
  - Updates senior customer loan rates by applying a 1% discount.
  - Automatically flags customers as VIP if their balance exceeds $10,000.
  - Queries and prints loan payment reminders for loans due in 30 days.
* **exercise2.sql (Error Handling)**:
  - `SafeTransferFunds`: Transaction-managed fund transfer with validation check, rollback, and custom error logging.
  - `UpdateSalary`: Updates employee salaries and logs a message if the Employee ID does not exist (`NO_DATA_FOUND`).
  - `AddNewCustomer`: Prevents duplicate inserts by catching `DUP_VAL_ON_INDEX` violations.
* **exercise3.sql (Stored Procedures)**:
  - `ProcessMonthlyInterest`: Bulk updates savings accounts by adding 1% interest.
  - `UpdateEmployeeBonus`: Updates employee salaries by department.
  - `TransferFunds`: Core fund transfer logic checking balance requirements.
* **exercise4.sql (Functions)**:
  - `CalculateAge`: Computes customer age based on date of birth.
  - `CalculateMonthlyInstallment`: Formulaic computation of monthly loan installments.
  - `HasSufficientBalance`: Returns a boolean indicating if an account balance satisfies a target amount.
* **exercise5.sql (Triggers)**:
  - `UpdateCustomerLastModified`: Updates the `LastModified` column when a customer is edited.
  - `LogTransaction`: Automatically appends records to the `AuditLog` table on transaction insertions.
  - `CheckTransactionRules`: Ensures withdrawals do not exceed account balances and deposits are positive.
* **exercise6.sql (Cursors)**:
  - Explicit cursor statement printing monthly transactions statements.
  - Deducts a $50 annual fee from all accounts.
  - Updates loan interest rates based on policy changes.
* **exercise7.sql (Packages)**:
  - `CustomerManagement`: Procedures to add/update customers, and retrieve balances.
  - `EmployeeManagement`: Decouples HR hiring and salary operations.
  - `AccountOperations`: Bundles account lifecycle operations (open, close, balance aggregation).

---

## Detailed PL/SQL Learnings

### 1. Variables and Flow Control
* PL/SQL extends SQL with procedural features. We used blocks (`DECLARE`, `BEGIN`, `EXCEPTION`, `END;`) to control execution flow. Conditional branches (`IF-THEN-ELSIF`) check specific criteria (e.g., senior discounts or VIP thresholds) during row iterations.

### 2. Exception Handling
* Unhandled database errors can crash client applications or leave data in corrupted states. We implemented explicit error handling (`EXCEPTION` block):
  - Catching predefined Oracle exceptions like `NO_DATA_FOUND` or `DUP_VAL_ON_INDEX`.
  - Creating custom exceptions using `RAISE` and returning application errors via `RAISE_APPLICATION_ERROR(-20001, 'Message')`.
  - Enforcing transaction safety using `ROLLBACK` inside exception handlers to undo changes if a transfer fails.

### 3. Cursors
* SQL queries return result sets in bulk, which procedural code cannot process row-by-row. Cursors solve this by acting as pointers to database queries:
  - **Implicit Cursors**: Automatically created for single-row `SELECT INTO` queries.
  - **Explicit Cursors**: Declared and controlled manually (`OPEN`, `FETCH`, `CLOSE`, or loop structures) to iterate through multiple rows.
  - **Cursor For Loops**: Simplifies explicit cursor syntax by automatically opening, fetching, and closing the cursor.

### 4. Triggers
* Triggers are stored programs executed automatically in response to database events (e.g., `BEFORE INSERT` or `AFTER UPDATE`). We used them to:
  - Automatically audit data (logging transaction events).
  - Enforce database-level data integrity rules (preventing negative deposits).
  - Maintain timestamps (`LastModified`) transparently without requiring modifications in application layer code.

### 5. Packages
* Packages group logically related procedures, functions, variables, and cursors. They consist of:
  - **Specification**: Public interface visible to the schema.
  - **Body**: Concrete private implementation details.
  - *Benefits*: Promotes encapsulation, modularity, and database performance via compilation caching.

---

## How to Test

These scripts can be executed inside any Oracle database command-line utility (SQL*Plus, SQL Developer, SQLcl, or an APEX SQL Workshop):

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
