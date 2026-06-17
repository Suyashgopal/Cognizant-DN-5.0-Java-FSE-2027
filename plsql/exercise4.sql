-- Exercise 4: Functions

--return age in years from date of birth
CREATE OR REPLACE FUNCTION CalculateAge (
  p_dob IN DATE
) RETURN NUMBER IS
  v_age NUMBER;
BEGIN
  v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
  RETURN v_age;
END;
/

--  monthly installment for a loan (simple interest)
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
  p_amount IN NUMBER,
  p_rate   IN NUMBER,
  p_years  IN NUMBER
) RETURN NUMBER IS
  v_total  NUMBER;
  v_months NUMBER;
BEGIN
  v_months := p_years * 12;
  -- principal + simple interest
  v_total := p_amount + (p_amount * p_rate / 100 * p_years);
  RETURN v_total / v_months;
END;
/

--  check if account has at least the given amount
CREATE OR REPLACE FUNCTION HasSufficientBalance (
  p_acc    IN NUMBER,
  p_amount IN NUMBER
) RETURN BOOLEAN IS
  v_bal NUMBER;
BEGIN
  SELECT Balance INTO v_bal FROM Accounts WHERE AccountID = p_acc;
  IF v_bal >= p_amount THEN
    RETURN TRUE;
  ELSE
    RETURN FALSE;
  END IF;
END;
/
