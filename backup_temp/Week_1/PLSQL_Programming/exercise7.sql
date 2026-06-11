-- Exercise 7: Packages

-- Scenario 1: CustomerManagement Package Specification
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddNewCustomer(p_CustomerID NUMBER, p_Name VARCHAR2, p_DOB DATE, p_Balance NUMBER);
    PROCEDURE UpdateCustomer(p_CustomerID NUMBER, p_Name VARCHAR2, p_Balance NUMBER);
    FUNCTION GetCustomerBalance(p_CustomerID NUMBER) RETURN NUMBER;
END CustomerManagement;
/

-- CustomerManagement Package Body
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddNewCustomer(p_CustomerID NUMBER, p_Name VARCHAR2, p_DOB DATE, p_Balance NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
        VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE, 'FALSE');
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Customer ID ' || p_CustomerID || ' already exists.');
    END AddNewCustomer;

    PROCEDURE UpdateCustomer(p_CustomerID NUMBER, p_Name VARCHAR2, p_Balance NUMBER) IS
    BEGIN
        UPDATE Customers
        SET Name = p_Name, Balance = p_Balance, LastModified = SYSDATE
        WHERE CustomerID = p_CustomerID;
        COMMIT;
    END UpdateCustomer;

    FUNCTION GetCustomerBalance(p_CustomerID NUMBER) RETURN NUMBER IS
        v_Balance NUMBER;
    BEGIN
        SELECT Balance INTO v_Balance FROM Customers WHERE CustomerID = p_CustomerID;
        RETURN v_Balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN -1;
    END GetCustomerBalance;
END CustomerManagement;
/

-- Scenario 2: EmployeeManagement Package Specification
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_EmployeeID NUMBER, p_Name VARCHAR2, p_Position VARCHAR2, p_Salary NUMBER, p_Department VARCHAR2, p_HireDate DATE);
    PROCEDURE UpdateEmployee(p_EmployeeID NUMBER, p_Position VARCHAR2, p_Salary NUMBER);
    FUNCTION CalculateAnnualSalary(p_EmployeeID NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

-- EmployeeManagement Package Body
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireEmployee(p_EmployeeID NUMBER, p_Name VARCHAR2, p_Position VARCHAR2, p_Salary NUMBER, p_Department VARCHAR2, p_HireDate DATE) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_EmployeeID, p_Name, p_Position, p_Salary, p_Department, p_HireDate);
        COMMIT;
    END HireEmployee;

    PROCEDURE UpdateEmployee(p_EmployeeID NUMBER, p_Position VARCHAR2, p_Salary NUMBER) IS
    BEGIN
        UPDATE Employees
        SET Position = p_Position, Salary = p_Salary
        WHERE EmployeeID = p_EmployeeID;
        COMMIT;
    END UpdateEmployee;

    FUNCTION CalculateAnnualSalary(p_EmployeeID NUMBER) RETURN NUMBER IS
        v_Salary NUMBER;
    BEGIN
        SELECT Salary INTO v_Salary FROM Employees WHERE EmployeeID = p_EmployeeID;
        RETURN v_Salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN -1;
    END CalculateAnnualSalary;
END EmployeeManagement;
/

-- Scenario 3: AccountOperations Package Specification
CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_AccountID NUMBER, p_CustomerID NUMBER, p_AccountType VARCHAR2, p_Balance NUMBER);
    PROCEDURE CloseAccount(p_AccountID NUMBER);
    FUNCTION GetTotalBalance(p_CustomerID NUMBER) RETURN NUMBER;
END AccountOperations;
/

-- AccountOperations Package Body
CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE OpenAccount(p_AccountID NUMBER, p_CustomerID NUMBER, p_AccountType VARCHAR2, p_Balance NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_AccountID, p_CustomerID, p_AccountType, p_Balance, SYSDATE);
        COMMIT;
    END OpenAccount;

    PROCEDURE CloseAccount(p_AccountID NUMBER) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_AccountID;
        COMMIT;
    END CloseAccount;

    FUNCTION GetTotalBalance(p_CustomerID NUMBER) RETURN NUMBER IS
        v_TotalBalance NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_TotalBalance FROM Accounts WHERE CustomerID = p_CustomerID;
        RETURN NVL(v_TotalBalance, 0);
    END GetTotalBalance;
END AccountOperations;
/
