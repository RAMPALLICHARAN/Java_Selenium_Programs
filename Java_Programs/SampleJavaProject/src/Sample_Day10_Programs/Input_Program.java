package Sample_Day10_Programs;

import java.io.IOException;

public class Input_Program {
    public static void main(String[] args) throws IOException {

        System.out.println("Please enter value :");

        int input_value = System.in.read(); 
        System.out.println("Test 1: ASCII value = " + input_value);
        System.out.println("Test 2: Value entered = " + (char)input_value);

        System.out.println("Input returned");
    }
}


