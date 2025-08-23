package Sample_Day11_Programs;
import java.util.ArrayList;
import java.util.Collections;


public class CollectionsProfit_Program {

     static class Department
    {
        private String name;
        private double sales;
        private double expenses;
        
        public Department(String name, double sales, double expenses)
        {
            this.name = name;
            this.sales = sales;
            this.expenses = expenses;
        }
        
        public double getProfit()
        {
            return sales - expenses;
        }
        
        public String getName()
        {
            return name;
        }
    }

    
    public static void main(String[] args)
    {
        ArrayList<Department> depart = new ArrayList<>();
        
        depart.add(new Department("Sales    ", 20000, 15000));
        depart.add(new Department("Marketing", 3000, 2000));
        depart.add(new Department("Research", 25000, 20000));
        
        for (Department d : depart)
        {
            System.out.println(d.getName() + " Profit: " + d.getProfit());
        }
        
        depart.sort((d1, d2) -> Double.compare(d1.getProfit(), d2.getProfit()));
        
        System.out.println("Sorting Done");
        
        for (Department d : depart)
        {
            System.out.println(d.getName() + " Profit: " + d.getProfit());
        }
    }
}


