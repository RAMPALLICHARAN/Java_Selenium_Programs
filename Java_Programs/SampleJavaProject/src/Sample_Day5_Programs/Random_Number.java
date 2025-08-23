package Sample_Day5_Programs;
import java.util.Random;
public class Random_Number {
	
	
	    public static void main(String[] args) {
	        Random random = new Random();
	        int randomNumber = random.nextInt(1000);  
	        System.out.println("Random number: " + randomNumber);
	    }
	}


