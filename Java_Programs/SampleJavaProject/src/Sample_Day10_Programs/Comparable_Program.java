package Sample_Day10_Programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparable_Program {

    public static void main(String[] args) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                if (i > j)
                    return 1;
                else
                    return -1;
            }
        };

        List<Integer> numberList = new ArrayList<>();
        numberList.add(80);
        numberList.add(60);
        numberList.add(56);
        numberList.add(46);
        numberList.add(100);

        Collections.sort(numberList, comparator);
        System.out.println(numberList);
    }
}



