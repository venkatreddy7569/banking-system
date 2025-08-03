package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import main.AccountManager;
import main.Account;

public class RegisterFrame extends JFrame {
    private JTextField accNumField, nameField;
    private JPasswordField pinField;
    private AccountManager manager;

    public RegisterFrame(AccountManager manager) {
        this.manager = manager;

        setTitle("Java Bank - Register");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 1));

        accNumField = new JTextField();
        nameField = new JTextField();
        pinField = new JPasswordField();

        JButton createBtn = new JButton("Create Account");

        add(new JLabel("Account Number:"));
        add(accNumField);
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("PIN:"));
        add(pinField);
        add(createBtn);

        createBtn.addActionListener(e -> {
            String accNum = accNumField.getText();
            String name = nameField.getText();
            String pin = new String(pinField.getPassword());

            manager.createAccount(accNum, name, pin);
            JOptionPane.showMessageDialog(this, "Account created successfully!");
            dispose();
            new LoginFrame(manager);
        });

        setVisible(true);
    }
}
