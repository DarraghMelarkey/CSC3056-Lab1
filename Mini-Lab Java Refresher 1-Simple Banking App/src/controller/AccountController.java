package controller;

import model.Transaction;
import java.util.Vector;

public class AccountController {
    public static Vector<Transaction> transactions = new Vector<Transaction>();

    /**
     * Calculate the balance of a given account (by its number). To do that, it needs to go over all transactions
     * that match the account and get their sum total. For example, if an account has only two transactions in the
     * system, with values = $10.79 and $-140, the balance would be $-129.21
     *
     * @param account_number
     * @return A double value, being the balance of the account
     */
    public static double getBalance(String account_number) {
        double balance = 0.0; // Initialize balance to zero
        // Iterate through the transactions and sum amounts for the given account
        for (Transaction transaction : transactions) {
            if (transaction.getAccount_number().equals(account_number)) {
                balance += transaction.getTransaction_amount();
            }
        }
        return balance; // Return the computed balance
    }
}
