package main;
import java.io.*;
import java.util.*;
import main.Account;

public class AccountManager {
    private HashMap<String, Account> accounts = new HashMap<>();
    private final String FILE_PATH = "Data/accounts.ser";

    public AccountManager() {
        loadAccounts();
    }

    public void createAccount(String accNum, String name, String pin) {
        if (accounts.containsKey(accNum)) {
            System.out.println("Account already exists!");
        } else {
            Account acc = new Account(accNum, name, pin);
            accounts.put(accNum, acc);
            saveAccounts();
            System.out.println("Account created successfully!");
        }
    }

    public Account login(String accNum, String pin) {
        Account acc = accounts.get(accNum);
        return (acc != null && acc.checkPin(pin)) ? acc : null;
    }

    public Account getAccount(String accNum) {
        return accounts.get(accNum);
    }

    public void deleteAccount(String accNum) {
        accounts.remove(accNum);
        File file = new File("Data/transactions/" + accNum + ".txt");
        if (file.exists()) file.delete();
        saveAccounts();
    }

    public void saveAccounts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadAccounts() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            accounts = (HashMap<String, Account>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading accounts.");
        }
    }
}
