-- Exercise 1: Control Structures

-- Scenario 1: Apply 1% interest rate discount to loans for customers above 60
DECLARE
    CURSOR cur_senior_customers IS
        SELECT ln.LoanID, ln.InterestRate, cust.DOB 
        FROM Loans ln
        JOIN Customers cust ON ln.CustomerID = cust.CustomerID;
    cust_age NUMBER;
BEGIN
    FOR r IN cur_senior_customers LOOP
        cust_age := MONTHS_BETWEEN(SYSDATE, r.DOB) / 12;
        IF cust_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = r.LoanID;
            DBMS_OUTPUT.PUT_LINE('Loan ID ' || r.LoanID || ': interest rate discounted by 1% for senior customer.');
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Promote customers with balance > $10,000 to VIP
DECLARE
    CURSOR cur_vip_candidates IS
        SELECT CustomerID, Balance FROM Customers;
BEGIN
    FOR r IN cur_vip_candidates LOOP
        IF r.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = r.CustomerID;
            DBMS_OUTPUT.PUT_LINE('Customer ' || r.CustomerID || ' has been elevated to VIP status.');
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Print alerts for loans expiring within 30 days
DECLARE
    CURSOR cur_upcoming_dues IS
        SELECT ln.LoanID, cust.Name, ln.EndDate
        FROM Loans ln
        JOIN Customers cust ON ln.CustomerID = cust.CustomerID
        WHERE ln.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR r IN cur_upcoming_dues LOOP
        DBMS_OUTPUT.PUT_LINE('ALERT: Loan ' || r.LoanID || ' for customer ' || r.Name || ' is expiring on ' || TO_CHAR(r.EndDate, 'YYYY-MM-DD') || '. Send reminder.');
    END LOOP;
END;
/
