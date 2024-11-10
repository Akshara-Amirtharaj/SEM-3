package labs.lab_11;

class Bank {
    public Double balance;

    Bank(Double balance) {
        this.balance = balance;
    }

     synchronized void deposit(Double amount) {
        balance += amount;
        System.out.println(amount + " is deposited. Current Balance: " + balance);
        notify(); // Notify any waiting thread (like the withdraw thread)
    }

    synchronized void withdraw(Double amount) {
        while (balance < amount) { // Loop to handle spurious wake-ups
            try {
                System.out.println("Insufficient balance. Waiting for deposit...");
                wait(); // Wait until enough balance is available
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        balance -= amount;
        System.out.println(amount + " is withdrawn. Current Balance: " + balance);
    }
}

class Depositing extends Thread {
    Bank acc;
    Double amount;

    Depositing(Double amount, Bank acc) {
        this.amount = amount;
        this.acc = acc;
    }

    public void run() {
        acc.deposit(amount);
    }
}

class Withdrawing extends Thread {
    Bank acc;
    Double amount;

    Withdrawing(Double amount, Bank acc) {
        this.amount = amount;
        this.acc = acc;
    }

    public void run() {
        acc.withdraw(amount);
    }
}

public class q3 {
    public static void main(String[] args) {

        Bank acc = new Bank(100.0);

        Depositing deposit1 = new Depositing(15000.0, acc);
        Withdrawing withdraw = new Withdrawing(17000.0, acc);
        Depositing deposit2 = new Depositing(5000.0, acc);

        deposit1.start();
        withdraw.start();
        deposit2.start();
    }
}
