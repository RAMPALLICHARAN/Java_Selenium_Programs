package Sample_Day3_Programs;
	class Vehicle {
	   void start() {
	       System.out.println("Vehicle started");
	   }
	}

	class Car extends Vehicle {
	   void drive() {
	       System.out.println("Car is driving");
	   }
	}

	public class Vehicle_Inheritance {
	   public static void main(String[] args) {
	       Car c = new Car();
	       c.start();  
	       c.drive(); 
	   }
	}



