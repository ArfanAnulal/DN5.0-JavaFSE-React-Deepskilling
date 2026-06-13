-- Exercise 5: Triggers

-- Scenario 1: UpdateCustomerLastModified trigger
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :new.LastModified := SYSDATE;
END;
/

-- Scenario 2: LogTransaction audit logging trigger
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, AccountID, TransactionDate, Amount, TransactionType, LogDate)
    VALUES (:new.TransactionID, :new.AccountID, :new.TransactionDate, :new.Amount, :new.TransactionType, SYSDATE);
END;
/

-- Scenario 3: CheckTransactionRules trigger
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_Balance NUMBER;
BEGIN
    IF :new.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Transaction amount must be positive.');
    END IF;

    IF :new.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_Balance FROM Accounts WHERE AccountID = :new.AccountID;
        IF v_Balance < :new.Amount THEN
            RAISE_APPLICATION_ERROR(-20003, 'Withdrawal amount exceeds account balance.');
        END IF;
    END IF;
END;
/
