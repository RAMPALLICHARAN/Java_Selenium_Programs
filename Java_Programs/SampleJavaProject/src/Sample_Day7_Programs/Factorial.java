package Sample_Day7_Programs;
public class Factorial {
    public static void main(String[] args) {
        int num = -2 ,fact = 1;

        try {
            if (num < 0) {
                throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
            }

            for (int i = 1; i <= num; i++) {
                fact *= i;
            }
            
            System.out.println("Factorial of " + num + " is: " + fact);
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        } finally {
            System.out.println("Execution completed (try-catch-finally block finished).");
        }
        System.out.println("We have entered into the main program).");
    }
    
}



