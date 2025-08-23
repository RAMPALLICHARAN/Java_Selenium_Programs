package Sample_Day3_Programs;
public class Bank_Account {
	    private String accountHolder;
	    private double balance;

	    
	    public Bank_Account(String accountHolder, double initialBalance) {
	        this.accountHolder = accountHolder;
	        this.balance = initialBalance;
	    }

	    
	    public void deposit(double amount) {
	        balance += amount;
	        System.out.println((int)amount + " deposited, New Balance: " + (int)balance);
	    }

	    
	    public void withdraw(double amount) {
	        if (amount > balance) {
	            System.out.println("Insufficient balance.");
	        } else {
	            balance -= amount;
	            System.out.println((int)amount + " withdrawn, Remaining Balance: " + (int)balance);
	        }
	    }

	   
	    public void displayDetails() {
	        System.out.println("Account Holder: " + accountHolder);
	        System.out.println("Balance: " + balance);
	    }
	}



