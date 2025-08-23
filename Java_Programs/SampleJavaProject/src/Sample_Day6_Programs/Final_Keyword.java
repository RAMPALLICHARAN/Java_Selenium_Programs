package Sample_Day6_Programs;


interface AddOperation {
    double sum(final double a, final double b);
}


interface SubOperation {
    double sub(final double a, final double b);
}


class SumCalculator implements AddOperation {
    public double sum(final double a, final double b) { 
        return a + b;
    }
}


class SubCalculator implements SubOperation {
    public double sub(final double a, final double b) {
        return a - b;
    }
}


public class Final_Keyword {
    public static void main(String[] args) {
        SumCalculator calc = new SumCalculator();
        SubCalculator calc1 = new SubCalculator();

        System.out.println("Addition: " + calc.sum(8.0, 20.0));
        System.out.println("Subtraction: " + calc1.sub(12.0, 10.0));
    }
}
