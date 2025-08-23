package Sample_Day2_Programs;
import java.util.Scanner;

public class NormalEvenOddProgram {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int input = sc.nextInt();
		if (input % 2 == 0) {
			System.out.println("It is an Even number ");
		}
		else {
			System.out.println("It is an Odd number ");
		}
		
	}

}
