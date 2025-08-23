package Sample_Day8_Programs;

class FirstTask extends Thread {
 @Override
 public void run() {
     for (int i = 1; i <= 10; i++) {
         System.out.println("First task is executing...");
         try {
             Thread.sleep(10); 
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }
}


class SecondTask extends Thread {
 @Override
 public void run() {
     for (int i = 1; i <= 10; i++) {
         System.out.println("Second task is executing...");
         try {
             Thread.sleep(10); 
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }
}


public class Multithreading_One {

 public static void main(String[] args) {
     FirstTask task1 = new FirstTask();
     SecondTask task2 = new SecondTask();

     task1.start();

     try {
         Thread.sleep(5); 
     } catch (InterruptedException e) {
         e.printStackTrace();
     }

     task2.start();
 }
}


