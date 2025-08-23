package Sample_Day2_Programs;
import java.util.Scanner;

public class Operators {
	    public static void main(String[] args) {
	    	
	    	Scanner a = new Scanner(System.in);
	    	System.out.println("Enter the number");
	    	int num1 = a.nextInt();
	    	Scanner b = new Scanner(System.in);
	    	System.out.println("Enter the second number");
	    	int num2 = b.nextInt();
	    	
	        

	        // Arithmetic Operators
	        System.out.println("Sum: " + (num1 + num2));            // Addition
	        System.out.println("Product: " + (num1 * num2));        // Multiplication

	        // Relational Operators
	        System.out.println("Is a greater than b ? " + (num1 > num2));  // Greater than

	        // Logical Operators
	        boolean condition = (num1 > num2) && (num1 != num2);          // Logical AND
	        System.out.println("Logical AND result: " + condition);
	        a.close();
	        b.close();
	    }
	

}
