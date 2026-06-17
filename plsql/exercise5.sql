-- Exercise 5: Triggers

CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
  :NEW.LastModified := SYSDATE;
END;
/

-- log every new transaction into auditLog audit table
CREATE TABLE AuditLog (
  LogID         NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  TransactionID NUMBER,
  AccountID     NUMBER,
  Amount        NUMBER,
  LogDate       DATE
);

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog (TransactionID, AccountID, Amount, LogDate)
  VALUES (:NEW.TransactionID, :NEW.AccountID, :NEW.Amount, SYSDATE);
END;
/

-- block bad withdrawals and non pos deposits
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  v_bal NUMBER;
BEGIN
  IF :NEW.TransactionType = 'Withdrawal' THEN
    SELECT Balance INTO v_bal FROM Accounts WHERE AccountID = :NEW.AccountID;
    IF :NEW.Amount > v_bal THEN
      RAISE_APPLICATION_ERROR(-20002, 'Withdrawal exceeds balance');
    END IF;
  ELSIF :NEW.TransactionType = 'Deposit' THEN
    IF :NEW.Amount <= 0 THEN
      RAISE_APPLICATION_ERROR(-20003, 'Deposit must be positive');
    END IF;
  END IF;
END;
/
