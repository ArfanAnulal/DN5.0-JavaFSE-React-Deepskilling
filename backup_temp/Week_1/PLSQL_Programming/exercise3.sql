-- Exercise 3: Stored Procedures

-- Scenario 1: Process monthly interest for savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01,
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Applied 1% monthly interest to all Savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
END ProcessMonthlyInterest;
/

-- Scenario 2: Update Employee Bonus by Department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_Department IN VARCHAR2,
    p_BonusPercent IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + (p_BonusPercent / 100))
    WHERE Department = p_Department;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus applied to department: ' || p_Department);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonus: ' || SQLERRM);
END UpdateEmployeeBonus;
/

-- Scenario 3: Standard TransferFunds
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_SourceAccountID IN NUMBER,
    p_DestAccountID   IN NUMBER,
    p_Amount          IN NUMBER
) IS
    v_SourceBalance NUMBER;
BEGIN
    SELECT Balance INTO v_SourceBalance FROM Accounts WHERE AccountID = p_SourceAccountID FOR UPDATE;

    IF v_SourceBalance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
    END IF;

    UPDATE Accounts SET Balance = Balance - p_Amount WHERE AccountID = p_SourceAccountID;
    UPDATE Accounts SET Balance = Balance + p_Amount WHERE AccountID = p_DestAccountID;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer of $' || p_Amount || ' completed successfully.');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Account not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END TransferFunds;
/
