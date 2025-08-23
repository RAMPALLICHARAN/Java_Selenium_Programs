package Sample_Day12_Programs;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_Program {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("C:\\Users\\91830\\Downloads\\Sample2.txt");
        int ch;
        while ((ch = reader.read()) != -1) {
            System.out.print((char) ch);
        }
        reader.close();
    }
}



