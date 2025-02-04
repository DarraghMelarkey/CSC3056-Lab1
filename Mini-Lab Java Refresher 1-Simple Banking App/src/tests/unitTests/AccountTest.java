package tests.unitTests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Account;

public class AccountTest {
    public static void main(String[] args) {
        try {
            // Convert string to Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date openingDate = dateFormat.parse("31/12/2000");

            // Create an Account object
            Account testAccount = new Account("1111111", "testusername", "Standard", openingDate);

            // Print test account (calls toString automatically)
            System.out.println(testAccount);

        } catch (ParseException e) {
            System.out.println("Invalid date format: " + e.getMessage());
        }
    }
}
