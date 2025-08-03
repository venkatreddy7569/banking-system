// File: gui/LoginFrame.java
package gui;

import main.AccountManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("🏦 Java Bank - Login");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("Welcome to Java Bank", JLabel.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titleLabel.setForeground(new Color(33, 150, 243));

        JLabel accLabel = new JLabel("Account Number:");
        JTextField accField = new JTextField();

        JLabel pinLabel = new JLabel("PIN:");
        JPasswordField pinField = new JPasswordField();

        JButton loginBtn = new JButton("🔐 Login");
        JButton registerBtn = new JButton("📝 Register");

        loginBtn.setBackground(new Color(76, 175, 80));
        loginBtn.setForeground(Color.WHITE);

        registerBtn.setBackground(new Color(255, 193, 7));
        registerBtn.setForeground(Color.BLACK);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panel.add(titleLabel);
        panel.add(accLabel);
        panel.add(accField);
        panel.add(pinLabel);
        panel.add(pinField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(loginBtn);
        buttonPanel.add(registerBtn);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accNum = accField.getText().trim();
                String pin = new String(pinField.getPassword());
                if (AccountManager.login(accNum, pin)) {
                    dispose();
                    new DashboardFrame(accNum).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "❌ Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegisterFrame().setVisible(true);
            }
        });
    }
}
