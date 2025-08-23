package Sample_Day6_Programs;
public class Bank {
    public static void main(String[] args) {
        Bank_Program account = new Savings_Account(1000);

        account.displayAccountType();            
        account.executeTransaction("deposit", 500);   
        account.executeTransaction("withdraw", 200);  
        account.executeTransaction("withdraw", -50);  
        System.out.println("Final Balance: $" + account.getBalance());
    }
}





