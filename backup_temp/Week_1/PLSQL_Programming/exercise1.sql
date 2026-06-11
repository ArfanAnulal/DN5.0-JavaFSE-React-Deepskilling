-- Exercise 1: Control Structures

-- Scenario 1: Apply a 1% discount to loan interest rates for customers above 60 years old.
DECLARE
    CURSOR c_senior_loans IS
        SELECT l.LoanID, l.InterestRate, c.DOB 
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID;
    v_age NUMBER;
BEGIN
    FOR r IN c_senior_loans LOOP
        v_age := MONTHS_BETWEEN(SYSDATE, r.DOB) / 12;
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = r.LoanID;
            DBMS_OUTPUT.PUT_LINE('Applied 1% discount to Loan ID: ' || r.LoanID);
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Promote customers to VIP status (IsVIP = TRUE) if balance > 10,000.
DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Balance FROM Customers;
BEGIN
    FOR r IN c_customers LOOP
        IF r.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = r.CustomerID;
            DBMS_OUTPUT.PUT_LINE('Promoted Customer ID: ' || r.CustomerID || ' to VIP.');
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Send reminders to customers whose loans are due within the next 30 days.
DECLARE
    CURSOR c_due_loans IS
        SELECT l.LoanID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR r IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || r.Name || ' (Loan ID: ' || r.LoanID || ') has a loan due on ' || TO_CHAR(r.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/
