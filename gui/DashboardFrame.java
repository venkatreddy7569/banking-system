package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import main.AccountManager;
import main.Account;
import utils.PdfGenerator;

public class DashboardFrame extends JFrame {
    private AccountManager manager;
    private Account account;

    public DashboardFrame(AccountManager manager, Account account) {
        this.manager = manager;
        this.account = account;

        setTitle("Java Bank - Dashboard");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 1));

        JButton viewBtn = new JButton("View Account Info");
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton transferBtn = new JButton("Transfer");
        JButton pinBtn = new JButton("Change PIN");
        JButton pdfBtn = new JButton("Download Transactions (PDF)");
        JButton logoutBtn = new JButton("Logout");

        add(new JLabel("Welcome, " + account.getName() + "!", JLabel.CENTER));
        add(viewBtn);
        add(depositBtn);
        add(withdrawBtn);
        add(transferBtn);
        add(pinBtn);
        add(pdfBtn);
        add(logoutBtn);

        viewBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                "Account: " + account.getAccountNumber() +
                "\nName: " + account.getName() +
                "\nBalance: ₹" + account.getBalance());
        });

        depositBtn.addActionListener(e -> {
            String amtStr = JOptionPane.showInputDialog("Enter deposit amount:");
            double amt = Double.parseDouble(amtStr);
            account.deposit(amt);
            manager.saveAccounts();
        });

        withdrawBtn.addActionListener(e -> {
            String amtStr = JOptionPane.showInputDialog("Enter withdrawal amount:");
            double amt = Double.parseDouble(amtStr);
            if (!account.withdraw(amt)) {
                JOptionPane.showMessageDialog(this, "Insufficient balance.");
            }
            manager.saveAccounts();
        });

        transferBtn.addActionListener(e -> {
            String toAcc = JOptionPane.showInputDialog("Enter receiver account number:");
            Account receiver = manager.getAccount(toAcc);
            if (receiver == null) {
                JOptionPane.showMessageDialog(this, "Receiver not found.");
                return;
            }
            String amtStr = JOptionPane.showInputDialog("Enter transfer amount:");
            double amt = Double.parseDouble(amtStr);
            if (!account.transfer(receiver, amt)) {
                JOptionPane.showMessageDialog(this, "Transfer failed.");
            }
            manager.saveAccounts();
        });

        pinBtn.addActionListener(e -> {
            String newPin = JOptionPane.showInputDialog("Enter new PIN:");
            account.changePin(newPin);
            manager.saveAccounts();
            JOptionPane.showMessageDialog(this, "PIN updated.");
        });

        pdfBtn.addActionListener(e -> {
            PdfGenerator.generateTransactionPDF(account.getAccountNumber());
            JOptionPane.showMessageDialog(this, "Transaction PDF saved in Data/transactions/");
        });

        logoutBtn.addActionListener(e -> {
            manager.saveAccounts();
            dispose();
            new LoginFrame(manager);
        });

        setVisible(true);
    }
}
