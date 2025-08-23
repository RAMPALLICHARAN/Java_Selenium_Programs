package Sample_Day9_Programs;
import java.util.Map;
import java.util.TreeMap;

public class Collections_TreeMapProgram {

    public static void main(String[] args) {
        Map<Integer, String> data = new TreeMap<>();

        data.put(10, "Ten");
        data.put(20, "Twenty");
        data.put(30, "Thirty");
        data.put(40, "Forty");

        for (Map.Entry<Integer, String> entry : data.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}



