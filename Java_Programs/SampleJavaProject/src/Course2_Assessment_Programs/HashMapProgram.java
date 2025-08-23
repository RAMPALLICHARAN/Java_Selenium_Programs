package Course2_Assessment_Programs;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapProgram {
    public static void main(String[] args) {
        Map<String, Integer> studentScores = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Get Student Score");
            System.out.println("3. Exit");

            int choice;

           
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); 
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the student's name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter the student's score: ");
                    if (scanner.hasNextInt()) {
                        int score = scanner.nextInt();
                        scanner.nextLine(); 
                        studentScores.put(name, score);
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Invalid score. Please enter a number.");
                        scanner.nextLine(); 
                    }
                    break;

                case 2:
                    System.out.print("Enter the student's name to get the score: ");
                    String studentName = scanner.nextLine();
                    Integer studentScore = studentScores.get(studentName);

                    if (studentScore != null) {
                        System.out.println("Score for " + studentName + " is: " + studentScore);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}



