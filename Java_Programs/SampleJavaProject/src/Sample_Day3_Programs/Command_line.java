package Sample_Day3_Programs;


public class Command_line {
    public static void main(String[] args) {
        // Check if two arguments are provided
        if (args.length < 2) {
            System.out.println("Please provide two numbers.");
            return;
        }

        try {
            // Convert the first and second arguments to integers
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);

            // Print the sum
            System.out.println("Sum = " + (a + b));
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer input: " + e.getMessage());
        }
    }
}




