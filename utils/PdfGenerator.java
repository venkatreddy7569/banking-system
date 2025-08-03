package utils;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import main.Account;


public class PdfGenerator {
    public static void generateTransactionPDF(String accNum) {
        String inputPath = "Data/transactions/" + accNum + ".txt";
        String outputPath = "Data/transactions/" + accNum + "_history.pdf";

        try {
            List<String> lines = Files.readAllLines(Paths.get(inputPath));
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(outputPath));
            document.open();

            document.add(new Paragraph("Transaction History for Account: " + accNum));
            document.add(new Paragraph("--------------------------------------------------"));
            for (String line : lines) {
                document.add(new Paragraph(line));
            }

            document.close();
            System.out.println("✅ PDF generated: " + outputPath);
        } catch (IOException | DocumentException e) {
            System.out.println(" Failed to create PDF: " + e.getMessage());
        }
    }
}
