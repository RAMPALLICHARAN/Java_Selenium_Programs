package Sample_Day1_Programs;


public class Addition_Runtime {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Addition_Runtime obj = new Addition_Runtime();
        int result = obj.add(10, 20);
        System.out.println("Addition Result: " + result);
    }
}



