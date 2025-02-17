package controller;

import java.util.Vector;

import model.User;

public class UserController {
	
	public static Vector<User> loadUserData() {
		Vector<User> users = new Vector<User>();
		// structure of each record: username (email address), password, first_name, last_name, mobile_number
		
		// in the ideal case (real deployment of the app), we will read from file or database, but let's hard-code for now
		users.add(new User("mike", "my_passwd", "Mike", "Smith", "07771234567"));
		
		
		users.add(new User("james.cameron@gmail.com", "angel", "James", "Cameron",  "07777654321"));
		
		
		users.add(new User("julia.roberts@gmail.com", "change_me",   "Julia", "roberts",   "07770123456"));
		
		return users;
	}
}
