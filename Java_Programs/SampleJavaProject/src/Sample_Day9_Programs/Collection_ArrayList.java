package Sample_Day9_Programs;
import java.util.Collection;
import java.util.ArrayList;

public class Collection_ArrayList {

    public static void main(String[] args) {
        
        Collection<Integer> data = new ArrayList<Integer>();

        
        data.add(10);
        data.add(20);
        data.add(30);
        data.add(40);
        data.add(50);
        data.add(60);
        data.add(70);
        data.add(80);

       
        for (Integer value : data) {
            System.out.println("Value: " + value);
        }
    }
}



