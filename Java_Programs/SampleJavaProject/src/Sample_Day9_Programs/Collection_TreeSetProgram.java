package Sample_Day9_Programs;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class Collection_TreeSetProgram {

    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();

        numbers.add(25);
        numbers.add(10);
        numbers.add(40);
        numbers.add(25);
        numbers.add(15);

        System.out.println("TreeSet  " + numbers);

        System.out.println("Iterating using Iterator:");
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.println("Value: " + iterator.next());
        }
    }
}


