package Sample_Day5_Programs;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int n = scanner.nextInt();
        scanner.nextLine();  

        String[] names = new String[n];

      
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }

        
        Arrays.sort(names);

     
        System.out.println("\nSorted Names (A to Z):");
        for (String name : names) {
            System.out.println(name);
        }
    }
}

