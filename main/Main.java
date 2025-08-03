package main;
import java.util.Scanner;

import gui.LoginFrame;
import main.AccountManager;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountManager manager = new AccountManager();
        new LoginFrame(manager);


        while (true) {
            System.out.println("\n=== Welcome to SBI Bank ===");
            System.out.println("1. Create Account\n2. Login\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Account Number: ");
                String accNum = sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter PIN: ");
                String pin = sc.nextLine();
                manager.createAccount(accNum, name, pin);
            } else if (choice == 2) {
                System.out.print("Enter Account Number: ");
                String accNum = sc.nextLine();
                System.out.print("Enter PIN: ");
                String pin = sc.nextLine();
                Account acc = manager.login(accNum, pin);

                if (acc != null) {
                    boolean loggedIn = true;
                    while (loggedIn) {
                        System.out.println("\nWelcome, " + acc.getName() + "!");
                        System.out.println("1. View Details\n2. Deposit\n3. Withdraw\n4. Transfer\n5. Change PIN\n6. Delete Account\n7. Logout");
                        int action = sc.nextInt();
                        sc.nextLine();

                        switch (action) {
                            case 1:
                                acc.displayDetails();
                                break;
                            case 2:
                                System.out.print("Enter deposit amount: ");
                                acc.deposit(sc.nextDouble());
                                sc.nextLine();
                                break;
                            case 3:
                                System.out.print("Enter withdraw amount: ");
                                if (!acc.withdraw(sc.nextDouble())) {
                                    System.out.println("Insufficient funds.");
                                }
                                sc.nextLine();
                                break;
                            case 4:
                                System.out.print("Enter receiver account number: ");
                                String toAcc = sc.nextLine();
                                Account receiver = manager.getAccount(toAcc);
                                if (receiver != null) {
                                    System.out.print("Enter amount: ");
                                    double amount = sc.nextDouble();
                                    sc.nextLine();
                                    if (!acc.transfer(receiver, amount)) {
                                        System.out.println("Transfer failed.");
                                    }
                                } else {
                                    System.out.println("Receiver not found.");
                                }
                                break;
                            case 5:
                                System.out.print("Enter new PIN: ");
                                acc.changePin(sc.nextLine());
                                System.out.println("PIN updated.");
                                break;
                            case 6:
                                manager.deleteAccount(acc.getAccountNumber());
                                System.out.println("Account deleted.");
                                loggedIn = false;
                                break;
                            case 7:
                                manager.saveAccounts();
                                loggedIn = false;
                                break;
                        }
                    }
                } else {
                    System.out.println("Invalid login!");
                }
            } else {
                System.out.println("Goodbye!");
                break;
            }
        }
        sc.close();
    }
}
