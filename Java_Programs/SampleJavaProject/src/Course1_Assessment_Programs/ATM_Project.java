package Course1_Assessment_Programs;
import java.util.Scanner;

public class ATM_Project{
	private double balance;
	private Scanner scanner;
	
	public ATM_Project() {
		this.balance = 1000.00;
		scanner = new Scanner(System.in);
	}

    public void DisplayMenu() 
    {
	  System.out.println("1.Check Balance \n2.With Draw\n3.Deposit\n4.Exit\n  ");
    }
    public void CheckBalance()
    {
    	System.out.println("The balance present in the account is " + balance);
    }
    public void Withdraw()
    {
    	System.out.println("Enter the amount need to withdraw");
    	double amount = scanner.nextDouble();
    	if(amount>0 && amount<balance) {
    		balance = balance - amount;
    		System.out.println("Amount withdrawn is "+ amount + " and the new balance in the account is" + balance );
    	}
    	else if (amount>balance){
    		System.out.println("Please enter the amount below " +balance);
    	}
    	else 
    	{
    		System.out.println("Enter the positive value");
    	}
    }
    public void Deposit() 
    {
    	System.out.println("Enter the amount need to deposit");
    	double amount = scanner.nextDouble();
    	if(amount>0) {
    		balance = balance + amount;
    		System.out.println("Amount added is "+ amount + " and the new balance in the account is" + balance );
    	}
    	else {
    		System.out.println("Please enter the valid amount");
    	}
    }
	public static void main(String[] args) {
		ATM_Project atm = new ATM_Project();
		while (true){
			atm.DisplayMenu();
		System.out.println("Enter your choice");
		int choice = atm.scanner.nextInt();
		switch(choice){
		case 1:
			atm.CheckBalance();
			break;
		case 2:
			atm.Withdraw();
			break;
		case 3:
			atm.Deposit();
			break;
		case 4:
			System.out.println("Enter the correct number");
			break;
		default:
			System.out.println("Visit again");
			
		}
		
		}
		
	}
}


