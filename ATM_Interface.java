// TASK 03 (ATM INTERFACE)

import java.util.Scanner;

class BankAccount{
    private double balance;

    public BankAccount(double initialBalance){
        balance = initialBalance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }
    public boolean withDraw(double amount){
        if (amount <= balance){
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM{
    private final BankAccount account;

    public ATM(BankAccount bankAccount){
        account = bankAccount;
    }

    public void displayMenu(){
        System.out.println("ATM Menu : ");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        while (true){
            displayMenu();
            System.out.println("Please Select an Option : ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Your Current Balance is "+ account.getBalance() + " Rs");
                    break;
                case 2:
                    System.out.println("Enter Account Number to Deposit Money :");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit Successfully Added. Your Account Balance is " + account.getBalance() + " Rs");
                    break;
                case 3:
                    System.out.println("Enter Account Number to Withdraw : ");
                    double withdrawAmount = sc.nextDouble();
                    if (account.withDraw(withdrawAmount)) {
                        System.out.println("Withdraw Successful. Your Current Account Balance is " + account.getBalance() + " Rs");
                    }else {
                        System.out.println("Insufficient Balance to Withdraw.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for Using ATM !");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Option. Please Select a Valid Option .");
            }
        }
    }
}

public class ATM_Interface {
    public static void main(String[] args) {
        int i = 1000;
        BankAccount userAccount = new BankAccount(i);  // For Initial balance
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}