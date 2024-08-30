package unit_1;

import java.util.ArrayList;
import java.util.Scanner;

class Bank {
    ArrayList<SavingsAccount> savingsAccounts = new ArrayList<>();
    ArrayList<CurrentAccount> currentAccounts = new ArrayList<>();

    void addSavingsAccount(SavingsAccount sa) {
        savingsAccounts.add(sa);
        System.out.println("Savings account added for " + sa.account_name);
    }

    void addCurrentAccount(CurrentAccount ca) {
        currentAccounts.add(ca);
        System.out.println("Current account added for " + ca.account_name);
    }

    SavingsAccount findSavingsAccount(String accountName) {
        for (SavingsAccount account : savingsAccounts) {
            if (account.account_name.equals(accountName)) {
                return account;
            }
        }
        return null;
    }

    CurrentAccount findCurrentAccount(String accountName) {
        for (CurrentAccount account : currentAccounts) {
            if (account.account_name.equals(accountName)) {
                return account;
            }
        }
        return null;
    }
}

interface Accounts {
    void deposit(double depositAmount);
    void withdraw(double withdrawAmount);
    void calculateInterest();
    void viewBalance();
}

class SavingsAccount implements Accounts {
    double initial_balance;
    double interest;
    String account_name;
    private double balance;

    SavingsAccount(double initial_balance, double interest, String account_name) {
        this.interest = interest;
        this.initial_balance = initial_balance;
        this.balance = initial_balance;
        this.account_name = account_name;
    }

    @Override
    public void deposit(double depositAmount) {
        balance += depositAmount;
        System.out.println("Deposited " + depositAmount + ". New balance: " + balance);
    }

    @Override
    public void withdraw(double withdrawAmount) {
        if (withdrawAmount > balance) {
            System.out.println("Not enough balance :(");
        } else {
            balance -= withdrawAmount;
            System.out.println(withdrawAmount + " is withdrawn. Your current balance is: " + balance);
        }
    }

    @Override
    public void calculateInterest() {
        double rate = balance * interest / 100;
        System.out.println("Interest: " + rate);
    }

    @Override
    public void viewBalance() {
        System.out.println("Current balance: " + balance);
    }
}

class CurrentAccount implements Accounts {
    double initial_amount;
    double overdraft_limit;
    String account_name;
    private double balance;

    CurrentAccount(double initial_amount, double overdraft_limit, String account_name) {
        this.initial_amount = initial_amount;
        this.overdraft_limit = overdraft_limit;
        this.balance = initial_amount;
        this.account_name = account_name;
    }

    @Override
    public void deposit(double depositAmount) {
        balance += depositAmount;
        System.out.println("Deposited " + depositAmount + ". New balance: " + balance);
    }

    @Override
    public void withdraw(double withdrawAmount) {
        if (balance - withdrawAmount < -overdraft_limit) {
            System.out.println("Not enough balance or overdraft limit exceeded.");
        } else {
            balance -= withdrawAmount;
            System.out.println(withdrawAmount + " is withdrawn. Your current balance is: " + balance);
        }
    }

    @Override
    public void calculateInterest() {
        System.out.println("No interest for Current Accounts.");
    }

    @Override
    public void viewBalance() {
        if (balance < 0) {
            System.out.println("Your account is in overdraft. Overdraft amount: " + (-balance));
        } else {
            System.out.println("Your current balance: " + balance);
        }
    }
}

public class q6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("(1) Add Account:");
            System.out.println("(2) Account Operations");
            System.out.println("(3) Exit");
            int mainChoice = input.nextInt();

            if (mainChoice == 1) {
                System.out.println("Enter the Type of Account:");
                System.out.println("(1) Savings Account");
                System.out.println("(2) Current Account");

                int accChoice = input.nextInt();
                if (accChoice == 1) {
                    System.out.println("Enter the initial amount:");
                    double initial_amount = input.nextDouble();
                    System.out.println("Enter the interest rate:");
                    double interest = input.nextDouble();
                    System.out.println("Enter the account name:");
                    String account_name = input.next();
                    SavingsAccount sa = new SavingsAccount(initial_amount, interest, account_name);
                    bank.addSavingsAccount(sa);
                } else if (accChoice == 2) {
                    System.out.println("Enter the initial amount:");
                    double initial_amount = input.nextDouble();
                    System.out.println("Enter the overdraft limit:");
                    double overdraft_limit = input.nextDouble();
                    System.out.println("Enter the account name:");
                    String account_name = input.next();
                    CurrentAccount ca = new CurrentAccount(initial_amount, overdraft_limit, account_name);
                    bank.addCurrentAccount(ca);
                } else {
                    System.out.println("Invalid option.");
                }
            } else if (mainChoice == 2) {
                System.out.println("Enter Account Name:");
                String accountName = input.next();

                SavingsAccount sa = bank.findSavingsAccount(accountName);
                CurrentAccount ca = bank.findCurrentAccount(accountName);

                if (sa != null || ca != null) {
                    Accounts account = sa != null ? sa : ca;
                    System.out.println("(1) Check balance");
                    System.out.println("(2) Deposit");
                    System.out.println("(3) Withdraw");
                    System.out.println("(4) Calculate interest");
                    int choice = input.nextInt();

                    switch (choice) {
                        case 1:
                            account.viewBalance();
                            break;
                        case 2:
                            System.out.println("Enter deposit amount:");
                            double depositAmount = input.nextDouble();
                            account.deposit(depositAmount);
                            break;
                        case 3:
                            System.out.println("Enter withdrawal amount:");
                            double withdrawAmount = input.nextDouble();
                            account.withdraw(withdrawAmount);
                            break;
                        case 4:
                            account.calculateInterest();
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }
                } else {
                    System.out.println("Account not found.");
                }
            } else if (mainChoice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
        input.close();
    }
}
