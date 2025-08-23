package Sample_Day5_Programs;
import java.util.Scanner;


abstract class RentCalculator {
 abstract void calculateTax(double rent);
}


class Apartment extends RentCalculator {
 @Override
 void calculateTax(double rent) {
     double tax = 0.10 * rent;
     double finalRent = rent + tax;
     System.out.println("\nApartment Rent Details:");
     System.out.println("Tax (10%): " + tax);
     System.out.println("Final Rent: " + finalRent);
 }
}


class House extends RentCalculator {
 @Override
 void calculateTax(double rent) {
     double tax = 0.20 * rent;
     double finalRent = rent + tax;
     System.out.println("\nHouse Rent Details:");
     System.out.println("Tax (20%): " + tax);
     System.out.println("Final Rent: " + finalRent);
 }
}


public class Property_Program {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     System.out.print("Enter category (Apartment/House): ");
     String category = sc.next();

     System.out.print("Enter base rent amount: ");
     double rent = sc.nextDouble();

     RentCalculator calculator;

     if (category.equalsIgnoreCase("Apartment")) {
         calculator = new Apartment();
     } else if (category.equalsIgnoreCase("House")) {
         calculator = new House();
     } else {
         System.out.println("Invalid category entered.");
         sc.close();
         return;
     }

     calculator.calculateTax(rent);
     sc.close();
 }
}



