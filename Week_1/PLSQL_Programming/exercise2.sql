-- Exercise 2: Error Handling

-- Scenario 1: SafeTransferFunds
CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_FromAccountID IN NUMBER,
    p_ToAccountID   IN NUMBER,
    p_Amount        IN NUMBER
) IS
    v_FromBalance NUMBER;
    v_ToBalance   NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    -- Check balance of source account
    SELECT Balance INTO v_FromBalance FROM Accounts WHERE AccountID = p_FromAccountID FOR UPDATE;
    SELECT Balance INTO v_ToBalance FROM Accounts WHERE AccountID = p_ToAccountID FOR UPDATE;

    IF v_FromBalance < p_Amount THEN
        RAISE insufficient_funds;
    END IF;

    -- Update balances
    UPDATE Accounts SET Balance = Balance - p_Amount WHERE AccountID = p_FromAccountID;
    UPDATE Accounts SET Balance = Balance + p_Amount WHERE AccountID = p_ToAccountID;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transferred $' || p_Amount || ' successfully.');
EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in account ' || p_FromAccountID);
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Account ID not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Unhandled Error: ' || SQLERRM);
END SafeTransferFunds;
/

-- Scenario 2: UpdateSalary
CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_EmployeeID IN NUMBER,
    p_Percentage IN NUMBER
) IS
    v_CurrentSalary NUMBER;
BEGIN
    SELECT Salary INTO v_CurrentSalary FROM Employees WHERE EmployeeID = p_EmployeeID FOR UPDATE;

    UPDATE Employees 
    SET Salary = Salary * (1 + (p_Percentage / 100)) 
    WHERE EmployeeID = p_EmployeeID;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated successfully for Employee ID: ' || p_EmployeeID);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_EmployeeID || ' does not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Unhandled Error: ' || SQLERRM);
END UpdateSalary;
/

-- Scenario 3: AddNewCustomer
CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_CustomerID IN NUMBER,
    p_Name       IN VARCHAR2,
    p_DOB        IN DATE,
    p_Balance    IN NUMBER
) IS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
    VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE, 'FALSE');

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer ' || p_Name || ' added successfully.');
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_CustomerID || ' already exists.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Unhandled Error: ' || SQLERRM);
END AddNewCustomer;
/
