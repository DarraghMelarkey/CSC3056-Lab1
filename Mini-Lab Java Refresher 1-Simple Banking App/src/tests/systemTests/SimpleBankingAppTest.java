package tests.systemTests;
import java.util.NoSuchElementException;
import app.SimpleBankingApp;
import controller.AccountController;
import controller.UserController;
import utils.TestUtils;
public class SimpleBankingAppTest {
 	// system under test (SUT):
	//static SimpleBankingApp mainApp = new SimpleBankingApp ();
	// this test method (test case) verifies if the data load feature of the class (unit or component)
	// under test (UUT) works properly
	public static void testLoadData() {
		// Reminder: the classical Four-Phase test pattern (Setup-Exercise-Verify-Teardown
		// http://xunitpatterns.com/Four%20Phase%20Test.html
		
		// 1-Setup phase: none
		
		// 2-Exercise phase
		UserController.loadUserData();
		// 3-Verify phase
		// we see in the load function of the UUT that we have loaded 3 users, so let's verify that
		if (UserController.users.size() == 3)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadUserData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadUserData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);
		// The above only verification is basic (simple, weak)
		// To do STRONGER verification, we would need more assertions for user names and account balances, etc.
		
		AccountController.loadAccountData();
		if (AccountController.accounts.size() == 4)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadAccountData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadAccountData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		// 4-Teardown phase: if our goal was to only test the load, as Teardown (mainApp.accounts)
		// we would have deleted the loaded deleted from memory (variables users, and accounts), but we want
		// to use those data in the other tests, thus, we do not do any Teardown in this test case
	}
	
	// this test method (test case) verifies if the Deposit feature works properly
	public static void testDeposits() {
		// 1-Setup phase
		double balanceBefore = AccountController.getBalance("5495-1234");
		double depositAmount = 50.21;
		
		// 2-Exercise phase
		SimpleBankingApp.addTransaction("5495-1234", depositAmount);
		double balanceAfter = AccountController.getBalance("5495-1234");
		
		// 3-verify
		assert balanceBefore + depositAmount == balanceAfter;
		if (balanceBefore + depositAmount == balanceAfter)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testDeposits: TC1 passed"+ TestUtils.TEXT_COLOR_RESET);
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "testDeposits: TC1 FAILED XXX: balanceBefore + depositAmount != balanceAfter");
			System.out.format("testDeposits: balanceBefore = %.2f ; depositAmount = %.2f ; balanceAfter = %.2f %s\n",
					balanceBefore , depositAmount , balanceAfter, TestUtils.TEXT_COLOR_RESET);
		}
		
		// 4-tear-down: put the system state back in where it was
		// read more about the tear-down phase of test cases: http://xunitpatterns.com/Four%20Phase%20Test.html
		SimpleBankingApp.addTransaction("5495-1234", -depositAmount);
	}
	// this test method (test case) verifies if the Withdraw feature works properly
	// TODO
	public static void testWithdrawals() {
	    // 1 - Setup phase: Get initial balance and define withdrawal amount
	    double initialBalance = AccountController.getBalance("5495-1234");
	    double withdrawalAmount = -100.00; // Withdraw $100
	    // 2 - Exercise phase: Perform the withdrawal
	    SimpleBankingApp.addTransaction("5495-1234", withdrawalAmount);
	    double newBalance = AccountController.getBalance("5495-1234");
	    // 3 - Verify phase: Check if balance was correctly reduced
	    assert newBalance == (initialBalance + withdrawalAmount) :
	        "Failed: Balance did not update correctly after withdrawal!";
	    if (newBalance == (initialBalance + withdrawalAmount)) {
	        System.out.println(TestUtils.TEXT_COLOR_GREEN + "testWithdrawals: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
	    } else {
	        System.out.println(TestUtils.TEXT_COLOR_RED + "testWithdrawals: TC1 FAILED XXX: Balance incorrect" + TestUtils.TEXT_COLOR_RESET);
	        System.out.format("Expected Balance: %.2f, Actual Balance: %.2f %s\n",
	                (initialBalance + withdrawalAmount), newBalance, TestUtils.TEXT_COLOR_RESET);
	    }
	    // 4 - Tear-down phase: Reverse the withdrawal
	    SimpleBankingApp.addTransaction("5495-1234", -withdrawalAmount);
	}
	
	public static void testAddTransaction() {
       try {
           AccountController.addTransaction("5495-1234", 0);
           System.out.println(TestUtils.TEXT_COLOR_RED + "testAddTransaction: failed"
           + TestUtils.TEXT_COLOR_RESET);
       } catch (IllegalArgumentException e) {
           System.out.println(TestUtils.TEXT_COLOR_GREEN + "testAddTransaction: passed"
       + TestUtils.TEXT_COLOR_RESET);
       }
       try {
           AccountController.addTransaction("9999-1111", 50);
           System.out.println(TestUtils.TEXT_COLOR_RED + "testAddTransaction: failed"
           + TestUtils.TEXT_COLOR_RESET);
       } catch (NoSuchElementException e) {
           System.out.println(TestUtils.TEXT_COLOR_GREEN + "testAddTransaction: passed"
       + TestUtils.TEXT_COLOR_RESET);
       }
   }
	
   public static void testGetBalance() {
       try {
           AccountController.getBalance("9999-1111");
           System.out.println(TestUtils.TEXT_COLOR_RED + "testGetBalance: failed"
           + TestUtils.TEXT_COLOR_RESET);
       } catch (NoSuchElementException e) {
           System.out.println(TestUtils.TEXT_COLOR_GREEN + "testGetBalance: passed"
       + TestUtils.TEXT_COLOR_RESET);
       }
   }
   public static void testGetTransactionHistory() {
       try {
           AccountController.getTransactionHistory("9999-1111");
           System.out.println(TestUtils.TEXT_COLOR_RED + "testGetTransactionHistory: failed"
           + TestUtils.TEXT_COLOR_RESET);
       } catch (NoSuchElementException e) {
           System.out.println(TestUtils.TEXT_COLOR_GREEN + "testGetTransactionHistory: passed"
       + TestUtils.TEXT_COLOR_RESET);
       }
   }
  
   public static void testTransferFunds() {
      
       try {
           AccountController.transferFunds("5495-1234", "9999-1111", 20);
           System.out.println(TestUtils.TEXT_COLOR_RED + "testTransferFunds: failed"
           + TestUtils.TEXT_COLOR_RESET);
       } catch (NoSuchElementException e) {
           System.out.println(TestUtils.TEXT_COLOR_GREEN + "testTransferFunds: passed"
       + TestUtils.TEXT_COLOR_RESET);
       }
       try {
           AccountController.transferFunds("5495-1234", "5495-6789", -10);
           System.out.println(TestUtils.TEXT_COLOR_RED + "testTransferFunds: failed"
           + TestUtils.TEXT_COLOR_RESET);
       } catch (IllegalArgumentException e) {
           System.out.println(TestUtils.TEXT_COLOR_GREEN + "testTransferFunds: passed"
       + TestUtils.TEXT_COLOR_RESET);
       }
   }
	
	public static void main(String[] args) {
		// we need to call our test cases (methods)
		testLoadData();
		testDeposits();
		testWithdrawals();
		testAddTransaction();
		testGetBalance();
		testGetTransactionHistory();	
		testTransferFunds();
		}
}


