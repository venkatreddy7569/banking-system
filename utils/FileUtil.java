package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import main.Account;


public class FileUtil {
    public static void writeTransaction(String accNum, String log) {
        try {
            File dir = new File("Data/transactions");
            if (!dir.exists()) dir.mkdirs();
            FileWriter fw = new FileWriter("Data/transactions/" + accNum + ".txt", true);
            fw.write(log + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Failed to write transaction log.");
        }
    }
}
