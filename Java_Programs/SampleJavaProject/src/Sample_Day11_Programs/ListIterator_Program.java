package Sample_Day11_Programs;
import java.util.ArrayList;
import java.util.ListIterator;

public class ListIterator_Program {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(200);
        numbers.add(300);
        numbers.add(400);
        numbers.add(500);
        numbers.add(600);
        numbers.add(700);
        numbers.add(800);
        
        ListIterator<Integer> iterator = numbers.listIterator();
        
        System.out.println(" FORWARD TRAVERSAL:  ");
        while (iterator.hasNext()) {
            int val = iterator.next();
            System.out.println("next() → " + val);
        }

        
        System.out.println(" BACKWARD TRAVERSAL:");
        while (iterator.hasPrevious()) {
            int val = iterator.previous();
            System.out.println("previous() → " + val);
        }
    }
}


