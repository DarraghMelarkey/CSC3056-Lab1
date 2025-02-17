package tests.unitTests;
import utils.TestUtils;
import model.Transaction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TransactionTest {
   public static void main(String[] args) {
       testTransactionConstructor();
   }
   public static void testTransactionConstructor() {
       System.out.println("Starting the assertions of the test method: testTransactionConstructor");
       // 1 - Setup (test data)
       String test_account_number = "1111111";
       double test_transaction_amount = 150.75;
       Date test_transaction_date = null;
       try {
           SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
           test_transaction_date = dateFormat.parse("15/02/2025");
       } catch (ParseException e) {
           System.out.println("Invalid date format: " + e.getMessage());
       }
       // 2 - Exercise (create Transaction object)
       Transaction testTransaction = new Transaction(test_account_number, test_transaction_amount, test_transaction_date);
       // 3 - Verify (Assertions)
       // TC1: Verify Account Number
       String test_case_name1 = "TC1-getAccountNumber";
       if (testTransaction.getAccount_number().equals(test_account_number))
           TestUtils.printTestPassed(test_case_name1);
       else
           TestUtils.printTestFailed(test_case_name1);
       // TC2: Verify Transaction Amount
       String test_case_name2 = "TC2-getTransactionAmount";
       if (testTransaction.getTransaction_amount() == test_transaction_amount)
           TestUtils.printTestPassed(test_case_name2);
       else
           TestUtils.printTestFailed(test_case_name2);
       // TC3: Verify Transaction Date
       String test_case_name3 = "TC3-getTransactionDate";
       if (testTransaction.getTransaction_date().equals(test_transaction_date))
           TestUtils.printTestPassed(test_case_name3);
       else
           TestUtils.printTestFailed(test_case_name3);
       
       boolean passed = true;
       if (passed)
           System.out.println("All TC's passed.");
       if (!testTransaction.getAccount_number().equals(test_account_number)) {
           System.out.println("TC1 failed: Account Number did not match");
           passed = false;
       }
       if (testTransaction.getTransaction_amount() != test_transaction_amount) {
           System.out.println("TC2 failed: Transaction Amount did not match");
           passed = false;
       }
       if (!testTransaction.getTransaction_date().equals(test_transaction_date)) {
           System.out.println("TC3 failed: Transaction Date did not match");
           passed = false;
       }
       // Final Assertions
       assert testTransaction.getAccount_number().equals(test_account_number);
       assert testTransaction.getTransaction_amount() == test_transaction_amount;
       assert testTransaction.getTransaction_date().equals(test_transaction_date);
       System.out.println("All Java assertions in the test suite passed (none failed)");
   }
}
