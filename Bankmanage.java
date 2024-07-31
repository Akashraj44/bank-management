import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}

class Bank {
    private ArrayList<Account> accounts;
    private Scanner scanner;

    public Bank() {
        accounts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void openAccount() {
        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();
        System.out.println("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // consume the newline

        Account newAccount = new Account(accountNumber, accountHolderName, initialBalance);
        accounts.add(newAccount);
        System.out.println("Account created successfully.");
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void depositMoney() {
        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.println("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // consume the newline
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdrawMoney() {
        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.println("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // consume the newline
            account.withdraw(amount);
        } else {
            System.out.println("insufficient balence.");
        }
    }

    public void displayAccount() {
        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);

        if (account != null) {
            account.displayAccount();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nBank Management System Menu:");
            System.out.println("a) Open account");
            System.out.println("b) Deposit money");
            System.out.println("c) Withdraw money");
            System.out.println("d) Display account");
            System.out.println("e) Exit");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            switch (option.toLowerCase()) {
                case "a":
                    openAccount();
                    break;
                case "b":
                    depositMoney();
                    break;
                case "c":
                    withdrawMoney();
                    break;
                case "d":
                    displayAccount();
                    break;
                case "e":
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

public class Bankmanage {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.showMenu();
    }
}