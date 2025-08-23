package Sample_Day12_Programs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_Program {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(
            new FileWriter("C:\\Users\\91830\\Downloads\\Sample2.txt", true)
        );
        writer.write("This is written using BufferedWriter.");
        writer.newLine(); 
        writer.close();
        System.out.println("Written successfully using BufferedWriter.");
    }
}
