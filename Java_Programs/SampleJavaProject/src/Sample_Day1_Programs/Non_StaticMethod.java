package Sample_Day1_Programs;
class Counter {
    int count = 0;                // instance variable

    public void increment() {
        count++;                 // increases instance-specific count
    }

    public int getCount() {
        return count;
    }
}

public class Non_StaticMethod {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();

        c1.increment();          // count = 1 for c1
        c2.increment();          // count = 1 for c2
        c2.increment();          // count = 2 for c2

        System.out.println(c1.getCount());  // prints 1
        System.out.println(c2.getCount());  // prints 2
    }
}

