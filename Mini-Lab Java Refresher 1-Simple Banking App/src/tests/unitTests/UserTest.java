package tests.unitTests;

import utils.TestUtils;
import model.User;

public class UserTest {
	public static void main(String[] args) {
		
		testUserConstructor();
	}
/*	public static void main(String[] args) {
		User testUser = new User("mike", "my_password", "Mike", "Smith", "07771234567");
		System.out.println(testUser);
	}*/
		
	// Automated Testing
	
	public static void testUserConstructor() {
	
	// 1 - Setup
	String test_username = "mike";
	String test_password = "password";
	String test_first_name = "Mike";
	String test_last_name = "Test"; //Intentional Injected defect, last name = null
	String test_mobile_number = "0771234567";
	
	// 2 - Exercise, run the object under test (constructor)
	User testUser = new User(test_username, test_password, test_first_name,
			test_last_name, test_mobile_number);
	
	// 3 - Verify (Assert)
	System.out.println("Starting the assertions of the test method: testUserConstructor");
	String test_case_name = "TC1-getUsername";
	if (testUser.getUsername() == test_username)
		//before refactoring
		//System.out.println(TestUtils.TEXT_COLOR_GREEN +  "TC1-getUsername-Passed" + TestUtils.TEXT_COLOR_RESET);
		//after refactoring
		TestUtils.printTestPassed(test_case_name);
	else
		//before refactoring
		//System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-FAILED" + TestUtils.TEXT_COLOR_RESET);
		// after refactoring
		TestUtils.printTestFailed(test_case_name);
	
	String test_case_name2 = "TC2-getPassword";
	if (testUser.getPassword() == test_password)
		//before refactoring
		//System.out.println(TestUtils.TEXT_COLOR_GREEN +  "TC1-getPassword-Passed" + TestUtils.TEXT_COLOR_RESET);
		//after refactoring
		TestUtils.printTestPassed(test_case_name2);
	else
		//before refactoring
		//System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getPassword-FAILED" + TestUtils.TEXT_COLOR_RESET);
		//after refactoring
		TestUtils.printTestFailed(test_case_name2);
		
	String test_case_name3 = "TC3-getFirst_name";
	if (testUser.getFirst_name() == test_first_name)
		//before refactoring
		//System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getFirst_name-Passed" + TestUtils.TEXT_COLOR_RESET);
		//after refactoring
		TestUtils.printTestPassed(test_case_name3);
	else
		//before refactoring
		//System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getFirst_name-FAILED" + TestUtils.TEXT_COLOR_RESET);
		//after refactoring
		TestUtils.printTestFailed(test_case_name3);
	
	String test_case_name4 = "TC4-getLast_name";
	if (testUser.getLast_name() == test_last_name)
		//before refactoring
		//System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getLast_name-Passed" + TestUtils.TEXT_COLOR_RESET);
		TestUtils.printTestPassed(test_case_name4);
	else
		//before refactoring
		//System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getLast_name-FAILED" + TestUtils.TEXT_COLOR_RESET);
		//after refactoring
		TestUtils.printTestFailed(test_case_name4);
	
	String test_case_name5 = "TC5-getMobile_number";
	if (testUser.getMobile_number() == test_mobile_number)
		//before refactoring
		//System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getMobile_number-Passed" + TestUtils.TEXT_COLOR_RESET);
		//after refactoring
		TestUtils.printTestPassed(test_case_name5); 
	else
		//before refactoring
		//System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getMobile_number-FAILED" + TestUtils.TEXT_COLOR_RESET);
		//after refactoring
		TestUtils.printTestFailed(test_case_name5);
	
	
	boolean passed = true;
	if (passed)
		System.out.println("All TC's passed.");
	
	if (testUser.getUsername() != test_username) {
		System.out.println("TC1 failed: username did not match");
		passed = false;
	}
	
	if (testUser.getPassword() != test_password) {
		System.out.println("TC2 failed: password did not match");
		passed = false;
	}
	
	if (testUser.getFirst_name() != test_first_name) {
		System.out.println("TC3 failed: first_name did not match");
		passed = false;
	}
	
	if (testUser.getLast_name() != test_last_name) {
		System.out.println("TC4 failed: last_name did not match");
		passed = false;
	}
	
	if (testUser.getMobile_number() != test_mobile_number) {
		System.out.println("TC5 failed: mobile_number did not match");
		passed = false;
	}
	
	assert testUser.getUsername() == test_username;
	assert testUser.getPassword() == test_password;
	assert testUser.getFirst_name() == test_first_name;
	assert testUser.getLast_name() == test_last_name;
	assert testUser.getMobile_number() == test_mobile_number;
	
	System.out.println("All Java assertions in the test suite passed (none failed)");
	
	}
}	
