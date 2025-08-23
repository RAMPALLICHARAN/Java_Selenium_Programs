package Sample_Day6_Programs;

interface CreditCard {
    void pay(double amount); 

    default void getTransactionFee() {
        double fee = amountWithFee(1.5); // 1.5% fee
        System.out.println("CreditCard Transaction Fee (1.5% of ₹1000): ₹" + fee);
    }

    static void showPlatform() {
        System.out.println("CreditCard Platform - Visa, MasterCard");
    }

    private static double amountWithFee(double rate) {
        return 1000 + (1000 * rate / 100); 
    }
}

interface UPI {
    void pay(double amount);

    default void getTransactionFee() {
        System.out.println("UPI Transaction Fee: ₹0.0");
    }

    static void showPlatform() {
        System.out.println("UPI Platform - PhonePe, GPay");
    }
}

interface Wallet {
    void pay(double amount);

    default void getTransactionFee() {
        System.out.println("Wallet Transaction Fee: ₹5.0");
    }

    static void showPlatform() {
        System.out.println("Wallet Platform - Paytm, Mobikwik");
    }
}

class OnlinePayment implements CreditCard, UPI, Wallet {

    @Override
    public void pay(double amount) {
        System.out.println("Paying ₹" + amount + " using all payment options...");
    }

    @Override
    public void getTransactionFee() {
      
        CreditCard.super.getTransactionFee(); 
    }

    public void showPlatforms() {
        CreditCard.showPlatform();
        UPI.showPlatform();
        Wallet.showPlatform();
    }
}

public class Multiple_Interfaces {
    public static void main(String[] args) {
        OnlinePayment payment = new OnlinePayment();

        payment.pay(1000);
        payment.getTransactionFee();
        payment.showPlatforms();
    }
}
