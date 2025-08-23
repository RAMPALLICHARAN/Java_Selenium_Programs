package Sample_Day4_Programs;

abstract class Payments {
    double amount;

    Payments(double amount) {
        this.amount = amount;
    }

    abstract void makePayment();

    void showSuccessMessage() {
        System.out.println("Payment successful: ₹" + amount);
    }
}

class CreditCardPayment extends Payments {
    CreditCardPayment(double amount) {
        super(amount);
    }

   
    void makePayment() {
        System.out.println("Credit Card payment is done...");
        showSuccessMessage();
    }
}

class UpiPayment extends Payments {
    UpiPayment(double amount) {
        super(amount);
    }

    
    void makePayment() {
        System.out.println("UPI payment is done...");
        showSuccessMessage();
    }
}

public class Abstract_Class {
    public static void main(String[] args) {
        Payments py = new CreditCardPayment(45000);
        py.makePayment();
        System.out.println("Credit Card Payment Process is Completed\n");

        Payments py2 = new UpiPayment(30000);
        py2.makePayment();
        System.out.println("UPI Payment Process is Completed");
    }
}


