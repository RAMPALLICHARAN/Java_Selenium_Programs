package Sample_Day1_Programs;

import java.util.Scanner;

public class Factorial {

    static int fact(int n) {
        return (n <= 1) ? 1 : n * fact(n - 1);  // Recursive function
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        System.out.println("Factorial: " + fact(num));
    }
}


