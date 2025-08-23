package Sample_Day3_Programs;

public class BankAccount {
	public static void main(String[] args) {
		Bank_Account Account1 = new Bank_Account("Jhona  ", 10000);
		Account1.deposit(1000);
		Account1.withdraw(600);
		Account1.displayDetails();
	}
}
