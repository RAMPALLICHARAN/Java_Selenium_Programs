package Sample_Day10_Programs;

import java.util.Scanner;

public class Scanner_Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number: ");

        int number = scanner.nextInt();

        System.out.println("Test : You entered = " + number);
        System.out.println("Input Returned");
    }
}



