package Sample_Day10_Programs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile_Program {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\91830\\Downloads\\Sample2.txt";  
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("This is the first line.");
            writer.newLine();
            writer.write("This is the second line.");
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}


