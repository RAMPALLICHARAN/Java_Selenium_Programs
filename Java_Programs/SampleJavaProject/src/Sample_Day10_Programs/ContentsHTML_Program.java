package Sample_Day10_Programs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContentsHTML_Program{
    public static void main(String[] args) {
        String filePath = "C:\\Users\\91830\\Downloads\\Sample.html"; 
        StringBuilder htmlContent = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                htmlContent.append(line.trim());
            }

            
            String textOnly = htmlContent.toString().replaceAll("<[^>]*>", " ").replaceAll("\\s+", " ").trim();

            
            System.out.println(textOnly);

        } catch (IOException e) {
            System.out.println("Error reading file:   " + e.getMessage());
        }
    }
}
