package Sample_Day4_Programs;
class Add{
	public int sum(int a, int b) {
		return a+b;
	}
}

public class Sample_ADD {
	public static void main(String[] args) {
		Add adding = new Add();
		System.out.println("Sum of the two numbers is " +adding.sum(10,20));
		}

}
