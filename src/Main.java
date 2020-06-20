import java.util.Scanner;

/* This Banking Application will:
   - Display "Welcome" message to the user with his or her name
   - Display 5 options to the user (Check Balance, Deposit, Withdraw, Check Previous Transaction, Exit)
   - Afterwards user will be allowed to make a choice
   - Once made the corresponding functionality will be executed
*/

public class Main {

    public static void main(String[] args) {

        BankAccount bA = new BankAccount("John Smith", "BA00025627");
        bA.showMenu();
    }
}

class BankAccount {

    // Fields
    private int balance;
    private int previousTransaction;
    private String customerName;
    private String customerID;

    // Constructor
    BankAccount (String cName, String cID) {
        customerName = cName;
        customerID = cID;
    }

    void deposit (int amount) {

        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw (int amount) {

        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction () {

        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    void showMenu () {

        char option = '0';
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerID);
        System.out.println();
        System.out.println("Here are the follow options to choose from:");
        System.out.println("A) Check Balance");
        System.out.println("B) Deposit");
        System.out.println("C) Withdraw");
        System.out.println("D) Check Previous Transactions");
        System.out.println("E) Exit");

        do {
            System.out.println("**********************************************************");
            System.out.println("Please enter an option:");
            System.out.println("**********************************************************");
            option = sc.next().charAt(0);
            System.out.println();

            switch(option) {

                case 'A':
                    System.out.println("**********************************************************");
                    System.out.println("You currently have " + balance + " available.");
                    System.out.println("**********************************************************");
                    System.out.println();
                    break;

                case 'B':
                    System.out.println("**********************************************************");
                    System.out.println("Enter an amount you wish to deposit:");
                    System.out.println("**********************************************************");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;

                case 'C':
                    System.out.println("**********************************************************");
                    System.out.println("Enter an amount you wish to have withdrawn:");
                    System.out.println("**********************************************************");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;

                case 'D':
                    System.out.println("**********************************************************");
                    getPreviousTransaction();
                    System.out.println("**********************************************************");
                    System.out.println();
                    break;

                case 'E':
                    System.out.println("**********************************************************");
                    break;

                default:
                    System.out.println("Invalid Entry. Please try again.");
                    break;
            }

        } while (option != 'E');

        System.out.println("Exiting now, Thankyou for banking with us!");
        System.out.println("Have a wonderful day");
    }

}
