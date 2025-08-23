package Sample_Day2_Programs;
import java.util.Scanner;

public class ArraySum {
	public static void main(String[] args) {
		int[] array= {10,20,30,40,50};
		int i,sum = 0;
		for(i=0; i<array.length;i++) {
			sum = sum + array[i];
		}
		System.out.println("The sum of the elements of the array is" + sum);
		
		
		
		System.out.println("Enter the size of array");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] array2 = new int[n];
		
		int j;
		for(j=0;j<array2.length;j++) {
			System.out.println("Enter the elements of a array");
			Scanner input1 = new Scanner(System.in);
			array2[j] = input1.nextInt();
		}
		
		int sum2 = 0;
		for(int k=0;k<array2.length;k++) {
			
			sum2 = sum2 + array2[k];	

		}
		System.out.println("The Sum of array2 elements : " + sum2);
		
	}
	

}
