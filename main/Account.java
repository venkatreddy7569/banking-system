package main;
import utils.FileUtil;
import java.io.Serializable;


public class Account implements Serializable {
    private String accountNumber, name, pin;
    private double balance;

    public Account(String accountNumber, String name, String pin) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.pin = pin;
        this.balance = 0.0;
    }

    public boolean checkPin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public void deposit(double amount) {
        this.balance += amount;
        FileUtil.writeTransaction(accountNumber, "Deposited ₹" + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
            FileUtil.writeTransaction(accountNumber, "Withdrew ₹" + amount);
            return true;
        }
        return false;
    }

    public boolean transfer(Account receiver, double amount) {
        if (this.withdraw(amount)) {
            receiver.deposit(amount);
            FileUtil.writeTransaction(accountNumber, "Transferred ₹" + amount + " to " + receiver.accountNumber);
            FileUtil.writeTransaction(receiver.accountNumber, "Received ₹" + amount + " from " + accountNumber);
            return true;
        }
        return false;
    }

    public void changePin(String newPin) {
        this.pin = newPin;
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: ₹" + balance);
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public String getName() { return name; }
}
