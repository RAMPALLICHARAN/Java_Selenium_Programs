package Sample_Day1_Programs;

class Utils {
    public static int add(int x, int y) {
        return x + y;
    }
}

public class Static_Method {
    public static void main(String[] args) {
        int sum = Utils.add(5, 7);  // calling static method directly via class name
        System.out.println(sum);    // prints 12
    }
}



