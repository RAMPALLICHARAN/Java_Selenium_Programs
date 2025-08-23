package Sample_Day4_Programs;

interface EcommercePayment {
    void makePayment();
}

abstract class PaymentSystem implements EcommercePayment {
    double amount;

    PaymentSystem(double amount) {
        this.amount = amount;
    }

    void showSuccessMessage() {
        System.out.println("Payment is Successful: ₹" + amount);
    }
}

class DebitCardPayment extends PaymentSystem {
    DebitCardPayment(double amount) {
        super(amount);
    }

    public void makePayment() {
        System.out.println("Debit Card Payment is Done...");
        showSuccessMessage();
    }
}

class NetBankingPayment extends PaymentSystem {
    NetBankingPayment(double amount) {
        super(amount);
    }

    public void makePayment() {
        System.out.println("Net Banking Payment is Done...");
        showSuccessMessage();
    }
}

public class Interface {
    public static void main(String[] args) {
        PaymentSystem payment1 = new DebitCardPayment(34000);
        payment1.makePayment();
        
        

        System.out.println();

        PaymentSystem payment2 = new NetBankingPayment(55000);
        payment2.makePayment();
    }
}


