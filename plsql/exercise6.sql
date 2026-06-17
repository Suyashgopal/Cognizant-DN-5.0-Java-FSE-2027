-- Exercise 6: Cursors

-- Scenario 1: print this month's transactions for each customer
DECLARE
  CURSOR c_txn IS
    SELECT a.CustomerID, t.TransactionID, t.Amount, t.TransactionType
    FROM Transactions t
    JOIN Accounts a ON t.AccountID = a.AccountID
    WHERE TO_CHAR(t.TransactionDate, 'MMYYYY') = TO_CHAR(SYSDATE, 'MMYYYY');
BEGIN
  FOR r IN c_txn LOOP
    DBMS_OUTPUT.PUT_LINE('Customer ' || r.CustomerID || ': ' ||
                         r.TransactionType || ' of ' || r.Amount);
  END LOOP;
END;
/

-- Scenario 2: deduct annual fee from every account
DECLARE
  CURSOR c_acc IS SELECT AccountID FROM Accounts;
  v_fee NUMBER := 100;  -- yearly fee
BEGIN
  FOR a IN c_acc LOOP
    UPDATE Accounts
    SET Balance = Balance - v_fee
    WHERE AccountID = a.AccountID;
  END LOOP;
  COMMIT;
END;
/

-- Scenario 3: bump loan rates by 0.5% as per new policy
DECLARE
  CURSOR c_loan IS SELECT LoanID FROM Loans;
BEGIN
  FOR l IN c_loan LOOP
    UPDATE Loans
    SET InterestRate = InterestRate + 0.5
    WHERE LoanID = l.LoanID;
  END LOOP;
  COMMIT;
END;
/
