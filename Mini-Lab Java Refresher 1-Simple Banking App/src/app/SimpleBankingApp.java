package app;
import java.util.Calendar;
import java.util.Vector;
import controller.AccountController;
import controller.UserController;
import model.Account;
import model.Transaction;
import model.User;
public class SimpleBankingApp {
   public static void addTransaction(String account_number, double amount) {
       Transaction aTransaction =  new Transaction(account_number, amount, Calendar.getInstance().getTime());
       AccountController.transactions.add(aTransaction);
   }
      
       public static void getBalance(String accountNumber) {
           try {
               double balance = AccountController.getBalance(accountNumber);
               System.out.println("Balance for account " + accountNumber + ": $" + balance);
           } catch (Exception e) {
               System.out.println("Error retrieving balance: " + e.getMessage());
           }
       }
      
       public static void getTransactionHistory(String accountNumber) {
           try {
               Vector<Transaction> history = AccountController.getTransactionHistory(accountNumber);
               System.out.println("Transaction history for account " + accountNumber + ":");
               for (Transaction t : history) {
                   System.out.println(t);
               }
           } catch (Exception e) {
               System.out.println("Error retrieving transaction history: " + e.getMessage());
           }
       }
      
       public static void transferFunds(String fromAccount, String toAccount, double amount) {
           try {
               AccountController.transferFunds(fromAccount, toAccount, amount);
               System.out.println("Funds transferred successfully from " + fromAccount + " to " + toAccount);
           } catch (Exception e) {
               System.out.println("Error transferring funds: " + e.getMessage());
           }
   }
   //////////////////////////////////////////////////////
   public static void main(String[] args) {
      
       UserController.loadUserData();
       // let's print them all to see if they have been loaded (populated) properly
       UserController.printAllUsers();
      
       AccountController.loadAccountData();
       // let's print them all to see if they have been loaded (populated) properly
       System.out.println("Accounts: initial state, after loading...");
       AccountController.printAllAccounts();
      
       // let's do some activities on the populated accounts, add transactions, etc.
       // Deposit: adding a transaction with a positive value
       // Withdraw: adding a transaction with a negative value
       addTransaction("5495-1234", -50.21);
       System.out.println("Account: after the 1st addTransaction function call...");
       AccountController.printAllAccounts();
      
       // and some more activities on the accounts
       addTransaction("5495-1234", 520.00);
       addTransaction("9999-1111", 21.00); // it seems this account does not exist in the loaded (populated) data,
                                           // but the addTransaction does not do that check, need to improve that function in future
       // let's print the accounts and their balance to see if the above transaction have impacted their balances
       System.out.println("Account: after the 2nd/3rd addTransaction function calls...");
       AccountController.printAllAccounts();
      
       System.out.println("Adding transactions...");
       addTransaction("5495-1234", 100.00);
       addTransaction("5495-1234", -50.00);
       addTransaction("9999-1111", 20.00);
       System.out.println("Retrieving balances...");
       getBalance("5495-1234");
       getBalance("9999-1111");
       System.out.println("Retrieving transaction history...");
       getTransactionHistory("5495-1234");
       System.out.println("Transferring funds...");
       transferFunds("5495-1234", "5495-6789", 30.00);
   }
}
