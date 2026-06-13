-- Exercise 4: Functions

-- Scenario 1: CalculateAge
CREATE OR REPLACE FUNCTION CalculateAge (
    p_DOB IN DATE
) RETURN NUMBER IS
BEGIN
    RETURN FLOOR(MONTHS_BETWEEN(SYSDATE, p_DOB) / 12);
END CalculateAge;
/

-- Scenario 2: CalculateMonthlyInstallment
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_LoanAmount IN NUMBER,
    p_InterestRate IN NUMBER,
    p_DurationYears IN NUMBER
) RETURN NUMBER IS
    v_MonthlyRate NUMBER;
    v_TotalMonths NUMBER;
    v_Installment NUMBER;
BEGIN
    v_MonthlyRate := (p_InterestRate / 100) / 12;
    v_TotalMonths := p_DurationYears * 12;

    IF v_MonthlyRate = 0 THEN
        RETURN p_LoanAmount / v_TotalMonths;
    END IF;

    v_Installment := (p_LoanAmount * v_MonthlyRate * POWER(1 + v_MonthlyRate, v_TotalMonths)) / 
                     (POWER(1 + v_MonthlyRate, v_TotalMonths) - 1);
    RETURN v_Installment;
END CalculateMonthlyInstallment;
/

-- Scenario 3: HasSufficientBalance
CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_AccountID IN NUMBER,
    p_Amount    IN NUMBER
) RETURN BOOLEAN IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance INTO v_Balance FROM Accounts WHERE AccountID = p_AccountID;
    IF v_Balance >= p_Amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END HasSufficientBalance;
/
