package Sample_Day10_Programs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckTwoFiles_Program {
	
    public static void main(String[] args) {
        String file1 = "C:\\Users\\91830\\Downloads\\Sample3.txt";
        String file2 = "C:\\Users\\91830\\Downloads\\Sample2.txt";

        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));

            String line1 = br1.readLine();
            String line2 = br2.readLine();

            boolean same = true;

            while (line1 != null || line2 != null) {
                if (line1 == null || line2 == null || !line1.equals(line2)) {
                    same = false;
                    break;
                }

                line1 = br1.readLine();
                line2 = br2.readLine();
            }

            br1.close();
            br2.close();

            if (same) {
                System.out.println("Files are same.  ");
            } else {
                System.out.println("Files are different.");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


