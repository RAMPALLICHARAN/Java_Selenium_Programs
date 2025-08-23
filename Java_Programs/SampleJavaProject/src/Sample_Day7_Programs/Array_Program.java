package Sample_Day7_Programs;
public class Array_Program {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};  

        try {
            System.out.println("Accessed element: " + numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input error: " + e.getMessage());
        } finally {
            System.out.println("Execution completed (try-catch-finally block finished).");
        }
        System.out.println("We have entered into the main program).");
    }
    
}


