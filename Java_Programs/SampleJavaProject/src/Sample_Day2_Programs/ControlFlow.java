package Sample_Day2_Programs;

public class ControlFlow {
	
	    public static void main(String[] args) {

	        
	        int age = 18;
	        if (age >= 18) {
	            System.out.println("Eligible to vote.");
	        }

	        
	        int number = 10;
	        if (number % 2 == 0) {
	            System.out.println("Even");
	        } else {
	            System.out.println("Odd");
	        }

	       
	        int marks = 80;
	        if (marks >= 90) {
	            System.out.println("Grade A");
	        } else if (marks >= 75) {
	            System.out.println("Grade B");
	        } else if (marks >= 60) {
	            System.out.println("Grade C");
	        } else {
	            System.out.println("Fail");
	        }

	        int day = 6;
	        switch (day) {
	            case 1:
	                System.out.println("Sunday");
	                break;
	            case 2:
	                System.out.println("Monday");
	                break;
	            case 3:
	                System.out.println("Tuesday");
	                break;
	            case 4:
	                System.out.println("Wednesday");
	                break;
	            case 5:
	                System.out.println("Thursday");
	                break;
	            case 6:
	                System.out.println("Friday");
	                break;
	            case 7:
	                System.out.println("Saturday");
	                break;
	            default:
	                System.out.println("Invalid day");
	        }
	    }
}


