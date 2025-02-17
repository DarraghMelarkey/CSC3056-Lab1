package tests.unitTests;
import utils.TestUtils;
import model.Account;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class AccountTest {
   public static void main(String[] args) {
       testAccountConstructor();
   }
   public static void testAccountConstructor() {
       System.out.println("Starting the assertions of the test method: testAccountConstructor");
       // 1 - Setup (test data)
       String test_account_number = "1111111";
       String test_username = "testusername";
       String test_account_type = "Standard";
       Date test_opening_date = null;
       try {
           SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
           test_opening_date = dateFormat.parse("31/12/2000");
       } catch (ParseException e) {
           System.out.println("Invalid date format: " + e.getMessage());
       }
       // 2 - Exercise (create Account object)
       Account testAccount = new Account(test_account_number, test_username, test_account_type, test_opening_date);
       // 3 - Verify (Assertions)
       // TC1: Verify Account Number
       String test_case_name1 = "TC1-getAccountNumber";
       if (testAccount.getAccount_number().equals(test_account_number))
           TestUtils.printTestPassed(test_case_name1);
       else
           TestUtils.printTestFailed(test_case_name1);
       // TC2: Verify Username
       String test_case_name2 = "TC2-getUsername";
       if (testAccount.getUsername_of_account_holder().equals(test_username))
           TestUtils.printTestPassed(test_case_name2);
       else
           TestUtils.printTestFailed(test_case_name2);
       // TC3: Verify Account Type
       String test_case_name3 = "TC3-getAccountType";
       if (testAccount.getAccount_type().equals(test_account_type))
           TestUtils.printTestPassed(test_case_name3);
       else
           TestUtils.printTestFailed(test_case_name3);
       // TC4: Verify Opening Date
       String test_case_name4 = "TC4-getOpeningDate";
       if (testAccount.getAccount_opening_date().equals(test_opening_date))
           TestUtils.printTestPassed(test_case_name4);
       else
           TestUtils.printTestFailed(test_case_name4);
      
       boolean passed = true;
   	if (passed)
   		System.out.println("All TC's passed.");
   	
   	if (testAccount.getAccount_number() != test_account_number) {
   		System.out.println("TC1 failed: Account Number did not match");
   		passed = false;
   	}
   	
   	if (testAccount.getUsername_of_account_holder() != test_username) {
   		System.out.println("TC2 failed: Username did not match");
   		passed = false;
   	}
   	
   	if (testAccount.getAccount_type() != test_account_type) {
   		System.out.println("TC3 failed: Account type did not match");
   		passed = false;
   	}
   	
   	if (testAccount.getAccount_opening_date() != test_opening_date) {
   		System.out.println("TC4 failed: opening date did not match");
   		passed = false;
   	}
   	
       // Final Assertions
       assert testAccount.getAccount_number().equals(test_account_number);
       assert testAccount.getUsername_of_account_holder().equals(test_username);
       assert testAccount.getAccount_type().equals(test_account_type);
       assert testAccount.getAccount_opening_date().equals(test_opening_date);
       System.out.println("All Java assertions in the test suite passed (none failed)");
      
   }
}
