-- Exercise 7: Packages

-- customer management package
CREATE OR REPLACE PACKAGE CustomerManagement AS
  PROCEDURE AddCustomer (p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_bal NUMBER);
  PROCEDURE UpdateCustomer (p_id NUMBER, p_name VARCHAR2);
  FUNCTION GetBalance (p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

  PROCEDURE AddCustomer (p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_bal NUMBER) IS
  BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_id, p_name, p_dob, p_bal, SYSDATE);
  END;

  PROCEDURE UpdateCustomer (p_id NUMBER, p_name VARCHAR2) IS
  BEGIN
    UPDATE Customers SET Name = p_name WHERE CustomerID = p_id;
  END;

  FUNCTION GetBalance (p_id NUMBER) RETURN NUMBER IS
    v_bal NUMBER;
  BEGIN
    SELECT Balance INTO v_bal FROM Customers WHERE CustomerID = p_id;
    RETURN v_bal;
  END;

END CustomerManagement;
/

-- Scenario 2: employee management package
CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee (p_id NUMBER, p_name VARCHAR2, p_pos VARCHAR2,
                          p_sal NUMBER, p_dept VARCHAR2);
  PROCEDURE UpdateEmployee (p_id NUMBER, p_pos VARCHAR2, p_dept VARCHAR2);
  FUNCTION AnnualSalary (p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

  PROCEDURE HireEmployee (p_id NUMBER, p_name VARCHAR2, p_pos VARCHAR2,
                          p_sal NUMBER, p_dept VARCHAR2) IS
  BEGIN
    INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
    VALUES (p_id, p_name, p_pos, p_sal, p_dept, SYSDATE);
  END;

  PROCEDURE UpdateEmployee (p_id NUMBER, p_pos VARCHAR2, p_dept VARCHAR2) IS
  BEGIN
    UPDATE Employees SET Position = p_pos, Department = p_dept
    WHERE EmployeeID = p_id;
  END;

  FUNCTION AnnualSalary (p_id NUMBER) RETURN NUMBER IS
    v_sal NUMBER;
  BEGIN
    SELECT Salary INTO v_sal FROM Employees WHERE EmployeeID = p_id;
    RETURN v_sal * 12;
  END;

END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount (p_id NUMBER, p_cust NUMBER, p_type VARCHAR2, p_bal NUMBER);
  PROCEDURE CloseAccount (p_id NUMBER);
  FUNCTION TotalBalance (p_cust NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

  PROCEDURE OpenAccount (p_id NUMBER, p_cust NUMBER, p_type VARCHAR2, p_bal NUMBER) IS
  BEGIN
    INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
    VALUES (p_id, p_cust, p_type, p_bal, SYSDATE);
  END;

  PROCEDURE CloseAccount (p_id NUMBER) IS
  BEGIN
    DELETE FROM Accounts WHERE AccountID = p_id;
  END;

  FUNCTION TotalBalance (p_cust NUMBER) RETURN NUMBER IS
    v_total NUMBER;
  BEGIN
    SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = p_cust;
    RETURN NVL(v_total, 0);
  END;

END AccountOperations;
/
