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
	String test_last_name = "Smith";
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
		//before refactor
		//System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-FAILED" + TestUtils.TEXT_COLOR_RESET);
		// after refactor
		TestUtils.printTestFailed(test_case_name);
	
	String test_case_name2 = "TC2-getPassword";
	if (testUser.getPassword() == test_password)
		//System.out.println(TestUtils.TEXT_COLOR_GREEN +  "TC1-getUsername-Passed" + TestUtils.TEXT_COLOR_RESET);
		TestUtils.printTestPassed(test_case_name2);
	else
		//System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getPassword-FAILED" + TestUtils.TEXT_COLOR_RESET);
		TestUtils.printTestFailed(test_case_name2);
		
	String test_case_name3 = "TC3-getFirst_name";
	if (testUser.getFirst_name() == test_first_name)
		//System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getFirst_name-Passed" + TestUtils.TEXT_COLOR_RESET);
		TestUtils.printTestPassed(test_case_name3);
		else
		//System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getFirst_name-FAILED" + TestUtils.TEXT_COLOR_RESET);
			TestUtils.printTestFailed(test_case_name3);
	
	String test_case_name4 = "TC4-getLast_name";
	if (testUser.getLast_name() == test_last_name)
		//System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getLast_name-Passed" + TestUtils.TEXT_COLOR_RESET);
		TestUtils.printTestPassed(test_case_name4);
		else
		//System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getLast_name-FAILED" + TestUtils.TEXT_COLOR_RESET);
			TestUtils.printTestFailed(test_case_name4);
	
	String test_case_name5 = "TC5-getMobile_number";
	if (testUser.getMobile_number() == test_mobile_number)
		//System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getMobile_number-Passed" + TestUtils.TEXT_COLOR_RESET);
	TestUtils.printTestFailed(test_case_name5); // Intentional defect with the wrong result input
	else
		//System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getMobile_number-FAILED" + TestUtils.TEXT_COLOR_RESET);
		TestUtils.printTestFailed(test_case_name5);
	
	
	String test_case_name6 = "TC6-getMobile_number";
	if (testUser.getMobile_number() == test_mobile_number)
		//System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getMobile_number-Passed" + TestUtils.TEXT_COLOR_RESET);
	TestUtils.printTestPassed(test_case_name); // Intentional defect with the wrong result input variable checked
	else
		//System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getMobile_number-FAILED" + TestUtils.TEXT_COLOR_RESET);
		TestUtils.printTestFailed(test_case_name);
	}
}	
