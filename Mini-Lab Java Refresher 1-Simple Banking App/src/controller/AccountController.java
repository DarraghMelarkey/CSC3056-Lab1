package controller;
import model.Transaction;
import model.Account;
import java.util.Vector;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;
public class AccountController {
   public static Vector<Transaction> transactions = new Vector<>();
   public static Vector<Account> accounts = new Vector<>();
  
   public static Vector<Account> loadAccountData() {
       Account anAccount;
       try {
           anAccount = new Account("5495-1234", "mike", "Standard",
           		new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"));
           accounts.add(anAccount);
           anAccount = new Account("5495-1239", "mike", "Standard",
           		new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"));
           accounts.add(anAccount);
           anAccount = new Account("5495-1291", "mike", "Saving",
           		new SimpleDateFormat("dd/MM/yyyy").parse("21/07/2019"));
           accounts.add(anAccount);
           anAccount = new Account("5495-6789", "David.McDonald@gmail.com", "Saving",
           		new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"));
           accounts.add(anAccount);
       } catch (ParseException e) {           
           e.printStackTrace();
       }
       return accounts;
   }
   public static void printAllAccounts() {
       System.out.println("There are: " + accounts.size() + " accounts in the system.");
     
       System.out.println(String.format("%-10s| %-30s| %-10s| %-15s| %-10s",
               "Account #", "Username of Account Holder", "Type", "Opening Date", "Balance"));
       System.out.println("----------------------------------------------------------------------------");
       for (Account acc : accounts) {
           System.out.println(String.format("%-10s| %-30s| %-10s| %-15s| $%-9.2f",
                   acc.getAccount_number(), acc.getUsername_of_account_holder(),
                   acc.getAccount_type(), new SimpleDateFormat("dd/MM/yyyy").format(acc.getAccount_opening_date()),
                   getBalance(acc.getAccount_number())));
       }
       System.out.println();
   }
   /**
    * Validate if the account exists in the system
    */
   public static boolean isValidAccount(String accountNumber) {
       return accounts.stream().anyMatch(account -> account.getAccount_number().equals(accountNumber));
   }
   /**
    * Enhanced addTransaction() with error checking
    */
   public static void addTransaction(String accountNumber, double amount) {
       if (amount == 0) {
           throw new IllegalArgumentException("Transaction amount cannot be zero.");
       }
       if (!isValidAccount(accountNumber)) {
           throw new NoSuchElementException("Account not found: " + accountNumber);
       }
       transactions.add(new Transaction(accountNumber, amount, new java.util.Date()));
   }
   /**
    * Get balance of an account after validating its existence
    */
   public static double getBalance(String accountNumber) {
       if (!isValidAccount(accountNumber)) {
           throw new NoSuchElementException("Account not found: " + accountNumber);
       }
       return transactions.stream()
               .filter(t -> t.getAccount_number().equals(accountNumber))
               .mapToDouble(Transaction::getTransaction_amount)
               .sum();
   }
   /**
    * Retrieve transaction history for a specific account
    */
   public static Vector<Transaction> getTransactionHistory(String accountNumber) {
       if (!isValidAccount(accountNumber)) {
           throw new NoSuchElementException("Account not found: " + accountNumber);
       }
       Vector<Transaction> history = new Vector<>();
       for (Transaction t : transactions) {
           if (t.getAccount_number().equals(accountNumber)) {
               history.add(t);
           }
       }
       return history;
   }
   /**
    * Transfer funds between two accounts
    */
   public static void transferFunds(String fromAccount, String toAccount, double amount) {
       if (amount <= 0) {
           throw new IllegalArgumentException("Transfer amount must be greater than zero.");
       }
       if (!isValidAccount(fromAccount) || !isValidAccount(toAccount)) {
           throw new NoSuchElementException("One or both accounts do not exist.");
       }
       if (getBalance(fromAccount) < amount) {
           throw new IllegalArgumentException("Insufficient funds for transfer.");
       }
       addTransaction(fromAccount, -amount);
       addTransaction(toAccount, amount);
   }
}
