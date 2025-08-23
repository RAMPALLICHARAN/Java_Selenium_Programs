package Sample_Day8_Programs;


class FirstRunnableTask implements Runnable {
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


class SecondRunnableTask implements Runnable {
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


public class Multithreading_Two {
 public static void main(String[] args) {
     
     Runnable task1 = new FirstRunnableTask();
     Runnable task2 = new SecondRunnableTask();

    
     Thread thread1 = new Thread(task1);
     Thread thread2 = new Thread(task2);

    
     thread1.start();
     thread2.start();
 }
}


