package Sample_Day9_Programs;

import java.util.Collection;
import java.util.LinkedList;

public class Collection_LinkedList {
    public static void main(String[] args) {
        
        Collection<Integer> data = new LinkedList<Integer>();

        data.add(40);
        data.add(80);
        data.add(100);
        data.add(200);

        for (Integer value : data) {
            System.out.println("Value: " + value);
        }
    }
}


