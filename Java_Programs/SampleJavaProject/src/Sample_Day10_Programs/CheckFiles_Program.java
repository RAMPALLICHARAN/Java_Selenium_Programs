package Sample_Day10_Programs;
import java.io.File;

public class CheckFiles_Program {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\91830\\Downloads\\Sample2.txt";  

        File file = new File(filePath);

        if (file.exists()) {
            System.out.println("✅ File exists.    ");
        } else {
            System.out.println("File does not exist.");
        }
    }
}


