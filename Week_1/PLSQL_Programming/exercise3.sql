-- Exercise 3: Stored Procedures

-- Scenario 1: Process monthly interest of 1% for all savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01,
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest calculation completed. All savings balances updated by 1%.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Fatal error calculating monthly interest: ' || SQLERRM);
END ProcessMonthlyInterest;
/

-- Scenario 2: Apply a department-wide employee bonus percentage
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    dept_name IN VARCHAR2,
    bonus_pct IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + (bonus_pct / 100))
    WHERE Department = dept_name;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Success: Salary updated with bonus for all employees in ' || dept_name || '.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Fatal error applying employee bonus: ' || SQLERRM);
END UpdateEmployeeBonus;
/

-- Scenario 3: Fund transfer with balance validation and locking
CREATE OR REPLACE PROCEDURE TransferFunds (
    from_acc   IN NUMBER,
    to_acc     IN NUMBER,
    amount     IN NUMBER
) IS
    source_bal NUMBER;
BEGIN
    -- Select with lock to avoid concurrency anomalies
    SELECT Balance INTO source_bal FROM Accounts WHERE AccountID = from_acc FOR UPDATE;

    IF source_bal < amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
    END IF;

    UPDATE Accounts SET Balance = Balance - amount WHERE AccountID = from_acc;
    UPDATE Accounts SET Balance = Balance + amount WHERE AccountID = to_acc;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successful transfer: $' || amount || ' moved from ' || from_acc || ' to ' || to_acc || '.');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer error: One or both accounts do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer aborted: ' || SQLERRM);
END TransferFunds;
/
