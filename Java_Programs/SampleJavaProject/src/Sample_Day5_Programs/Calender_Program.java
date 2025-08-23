package Sample_Day5_Programs;

import java.util.Calendar;

public class Calender_Program {

    public static void main(String[] args) {
        
        Calendar calendar = Calendar.getInstance();

        
        System.out.println("Current Date and Time: " + calendar.getTime());

        
        calendar.set(Calendar.YEAR, 2025);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);  // Note: Months are 0-based
        calendar.set(Calendar.DAY_OF_MONTH, 20);
        System.out.println("Specific Date (January 20, 2025): " + calendar.getTime());

       
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        System.out.println("Date after adding 30 days: " + calendar.getTime());

        
        calendar.add(Calendar.MONTH, -1);
        System.out.println("Date after subtracting 1 month: " + calendar.getTime());
    }
}


