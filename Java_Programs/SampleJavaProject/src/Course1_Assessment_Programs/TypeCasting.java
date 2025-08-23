package Course1_Assessment_Programs;

public class TypeCasting {
	public static void main(String[] args) {
		int intValue = 10;
		double doubleValue = intValue;
		System.out.println("The actual value is "+ intValue);
		System.out.println("The typecasted value of the actual value is " + doubleValue);
		double anotherdoubleValue = 20.98;
		int anotherintValue = (int)anotherdoubleValue;
		System.out.println("The actual value is "+ anotherdoubleValue);
		System.out.println("The typecasted value of the actual value is    " + anotherintValue);
		
	}

}



