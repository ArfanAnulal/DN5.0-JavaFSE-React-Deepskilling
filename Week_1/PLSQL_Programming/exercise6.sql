-- Exercise 6: Cursors

-- Scenario 1: GenerateMonthlyStatements
DECLARE
    CURSOR c_statements IS
        SELECT t.AccountID, c.Name, t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);
BEGIN
    DBMS_OUTPUT.PUT_LINE('=== MONTHLY TRANSACTIONS STATEMENT ===');
    FOR r IN c_statements LOOP
        DBMS_OUTPUT.PUT_LINE('Acc ID: ' || r.AccountID || ' | Cust: ' || r.Name || 
                             ' | Tx ID: ' || r.TransactionID || ' | Type: ' || r.TransactionType || 
                             ' | Amt: $' || r.Amount || ' | Date: ' || TO_CHAR(r.TransactionDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/

-- Scenario 2: ApplyAnnualFee
DECLARE
    CURSOR c_accounts IS
        SELECT AccountID, Balance FROM Accounts FOR UPDATE;
    v_Fee CONSTANT NUMBER := 50; -- annual maintenance fee
BEGIN
    FOR r IN c_accounts LOOP
        UPDATE Accounts
        SET Balance = Balance - v_Fee,
            LastModified = SYSDATE
        WHERE CURRENT OF c_accounts;
        DBMS_OUTPUT.PUT_LINE('Deducted $50 annual fee from Account ID: ' || r.AccountID);
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: UpdateLoanInterestRates
DECLARE
    CURSOR c_loans IS
        SELECT LoanID, InterestRate FROM Loans FOR UPDATE;
    v_NewPolicyRate CONSTANT NUMBER := 0.5; -- rate adjustment
BEGIN
    FOR r IN c_loans LOOP
        UPDATE Loans
        SET InterestRate = InterestRate + v_NewPolicyRate
        WHERE CURRENT OF c_loans;
        DBMS_OUTPUT.PUT_LINE('Adjusted interest rate for Loan ID: ' || r.LoanID);
    END LOOP;
    COMMIT;
END;
/
