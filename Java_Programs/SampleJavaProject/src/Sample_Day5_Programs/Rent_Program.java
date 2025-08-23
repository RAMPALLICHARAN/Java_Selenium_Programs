package Sample_Day5_Programs;


class RentDetails {
 double rentAmount;
 int additionalExpenses;
 double electricityBill;

 
 public void calculateRent(int rentAmount, int additionalExpenses) {
     this.rentAmount = rentAmount;
     this.additionalExpenses = additionalExpenses;

     System.out.println("Monthly Rent: " + rentAmount);
     System.out.println("Additional Expenses: " + additionalExpenses);
     System.out.println("Total Payment: " + (rentAmount + additionalExpenses));
     System.out.println("The payment is done ");
 }


 public void calculateRent(double rentAmount, double electricityBill) {
     this.rentAmount = rentAmount;
     this.electricityBill = electricityBill;

     System.out.println("Monthly Rent: " + rentAmount);
     System.out.println("Electricity Bill: " + electricityBill);
     System.out.println("Total Payment: " + (rentAmount + electricityBill));
     System.out.println("The payment is done");
 }
}

public class Rent_Program {
 public static void main(String[] args) {
     
     RentDetails rent = new RentDetails();

     
     rent.calculateRent(5000, 7000);

    
     rent.calculateRent(5000.0, 6000.0);
 }
}



