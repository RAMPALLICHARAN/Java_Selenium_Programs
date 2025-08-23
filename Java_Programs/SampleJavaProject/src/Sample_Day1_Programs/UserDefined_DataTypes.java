package Sample_Day1_Programs;

import java.util.Scanner;

public class UserDefined_DataTypes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();           // Reference data type

        System.out.print("Enter your score (int): ");
        int score = sc.nextInt();              // Primitive data type

        System.out.print("Enter your height (double): ");
        double height = sc.nextDouble();       // Primitive data type

        System.out.println("\nHello, " + name);
        System.out.println("Score: " + score);
        System.out.println("Height: " + height);
    }
}


