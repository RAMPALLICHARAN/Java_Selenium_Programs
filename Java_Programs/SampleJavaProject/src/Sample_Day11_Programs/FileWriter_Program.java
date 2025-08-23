package Sample_Day11_Programs;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileWriter_Program {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\91830\\Downloads\\Sample2.txt";

        
        String content = "Months\nYears\nDays";

        
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.close();
            System.out.println("Date information written to file successfully.");
        } catch (IOException e) {
            System.out.println(" Error writing to file: " + e.getMessage());
        }

        
        System.out.println("Reading content from the file:  ");
        try {
            FileReader reader = new FileReader(filePath);
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}



