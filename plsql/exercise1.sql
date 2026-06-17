-- Exercise 1: Control Structures

BEGIN
  FOR c IN (SELECT CustomerID, DOB FROM Customers) LOOP
    -- check age
    IF MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE CustomerID = c.CustomerID;
    END IF;
  END LOOP;
  COMMIT;
END;
/

--  set VIP flag for customers with balance over 10000
BEGIN
  FOR c IN (SELECT CustomerID, Balance FROM Customers) LOOP
    IF c.Balance > 10000 THEN
      UPDATE Customers
      SET IsVIP = 'TRUE'
      WHERE CustomerID = c.CustomerID;
    END IF;
  END LOOP;
  COMMIT;
END;
/

--  print reminders for loans due in next 30 days
BEGIN
  FOR l IN (SELECT CustomerID, LoanID, EndDate FROM Loans
            WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || l.CustomerID ||
                         ' loan ' || l.LoanID ||
                         ' is due on ' || l.EndDate);
  END LOOP;
END;
/
