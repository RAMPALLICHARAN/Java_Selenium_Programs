package Sample_Day6_Programs;
public class Savings_Account implements Bank_Program {
    private double balance;

    public Savings_Account(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds to withdraw $" + amount);
        }
    }

    // ✅ Overriding default method
    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}


