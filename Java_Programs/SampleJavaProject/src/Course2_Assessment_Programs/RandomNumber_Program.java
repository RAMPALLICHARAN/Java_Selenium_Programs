package Course2_Assessment_Programs;

import java.util.Random;

public class RandomNumber_Program {
    public static void main(String[] args) {
        long random10DigitNumber = generateTenDigitRandomNumber();
        System.out.println("Random 10-Digit Number Generated is : " + random10DigitNumber);
    }

    public static long generateTenDigitRandomNumber() {
        Random random = new Random();

        long min = 1000000000L;     
        long max = 9999999999L;     

        
        long random10DigitNumber = min + (long)(random.nextDouble() * (max - min + 1));

        return random10DigitNumber;
    }
}


