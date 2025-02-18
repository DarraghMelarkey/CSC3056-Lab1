package controller;
import model.User;
import java.util.Vector;
public class UserController {
   public static Vector<User> users = new Vector<User>();
   public static Vector<User> loadUserData() {
       User aUser = new User("mike", "my_passwd", "Mike", "Smith", "07771234567");
       users.add(aUser);
       aUser = new User("james.cameron@gmail.com", "angel", "James", "Cameron",  "07777654321");
       users.add(aUser);
       aUser = new User("julia.roberts@gmail.com", "change_me",   "Julia", "roberts",   "07770123456");
       users.add(aUser);
       return users;
   }
   public static void printAllUsers() {
       System.out.println("There are: " + users.size() + " users in the system.");   
       System.out.println(String.format("%-25s| %-15s| %-15s| %-15s| %-15s",
               "username", "password", "first_name", "last_name", "mobile_number"));
       System.out.println("-------------------------------------------------------------------------------------------");
       for (User user : users) {
           System.out.println(user.toString());
       }
       System.out.println();
   }
}
