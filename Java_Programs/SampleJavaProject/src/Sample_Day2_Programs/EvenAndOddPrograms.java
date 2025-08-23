package Sample_Day2_Programs;
import java.util.Scanner;

public class EvenAndOddPrograms {
	public void CheckEvenOdd(int number) {
		if (number% 2 == 0) {
			System.out.println("It is Even Number");
		}
		else {
			System.out.println("It is Odd Number");
		}
		
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int num = input.nextInt();
		EvenAndOddPrograms obj = new EvenAndOddPrograms();
		obj.CheckEvenOdd(num);
		input.close();
	}
	

}
