-- Exercise 2: Error Handling

-- safe transfer between two accounts with rollback on error
CREATE OR REPLACE PROCEDURE SafeTransferFunds (
  p_from   IN NUMBER,
  p_to     IN NUMBER,
  p_amount IN NUMBER
) IS
  v_bal NUMBER;
BEGIN
  -- get source balance
  SELECT Balance INTO v_bal FROM Accounts WHERE AccountID = p_from;

  IF v_bal < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds');
  END IF;

  UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from;
  UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to;
  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/

--  raise salary by a percent, handle missing employee
CREATE OR REPLACE PROCEDURE UpdateSalary (
  p_emp IN NUMBER,
  p_pct IN NUMBER
) IS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_pct / 100)
  WHERE EmployeeID = p_emp;

  IF SQL%ROWCOUNT = 0 THEN
    RAISE NO_DATA_FOUND;
  END IF;
  COMMIT;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('Error: employee ' || p_emp || ' not found');
END;
/

CREATE OR REPLACE PROCEDURE AddNewCustomer (
  p_id   IN NUMBER,
  p_name IN VARCHAR2,
  p_dob  IN DATE,
  p_bal  IN NUMBER
) IS
BEGIN
  INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
  VALUES (p_id, p_name, p_dob, p_bal, SYSDATE);
  COMMIT;
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Error: customer ' || p_id || ' already exists');
END;
/
