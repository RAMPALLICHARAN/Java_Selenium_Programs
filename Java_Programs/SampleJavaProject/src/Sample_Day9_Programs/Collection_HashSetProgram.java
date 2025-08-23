package Sample_Day9_Programs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Collection_HashSetProgram {

    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();

        numbers.add(25);
        numbers.add(10);
        numbers.add(40);
        numbers.add(25); 
        numbers.add(15);

        System.out.println("HashSet " + numbers);

        System.out.println("Iterating using Iterator:");
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.println("Value: " + iterator.next());
        }
    }
}


