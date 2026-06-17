-- Exercise 3: Stored Procedures

--  add 1% monthly interest to all savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  UPDATE Accounts
  SET Balance = Balance + (Balance * 0.01)
  WHERE AccountType = 'Savings';
  COMMIT;
END;
/

--  give bonus to all employees in a department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_dept IN VARCHAR2,
  p_pct  IN NUMBER
) IS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_pct / 100)
  WHERE Department = p_dept;
  COMMIT;
END;
/

--  transfer amount, check source balance first
CREATE OR REPLACE PROCEDURE TransferFunds (
  p_from   IN NUMBER,
  p_to     IN NUMBER,
  p_amount IN NUMBER
) IS
  v_bal NUMBER;
BEGIN
  SELECT Balance INTO v_bal FROM Accounts WHERE AccountID = p_from;

  IF v_bal >= p_amount THEN
    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to;
    COMMIT;
  ELSE
    DBMS_OUTPUT.PUT_LINE('Not enough balance in account ' || p_from);
  END IF;
END;
/
