package Sample_Day8_Programs;
class TicketBookingSystem {
 private int availableTickets;
 public TicketBookingSystem(int totalTickets) {
     this.availableTickets = totalTickets;
 }
 public synchronized void bookTicket(String user, int ticketsRequested) {
     System.out.println(user + " is trying to book " + ticketsRequested + " ticket(s).");
     if (ticketsRequested <= availableTickets) {
         System.out.println("Booking in progress for " + user + "...");
         try 
         {
             Thread.sleep(1000); 
         } 
         catch (InterruptedException e) 
         {
             e.printStackTrace();
         }
         availableTickets -= ticketsRequested;
         System.out.println("Booking successful for " + user + ". Tickets remaining: " + availableTickets);
     } else {
         System.out.println("not enough tickets available for " + user + ". Tickets remaining: " + availableTickets);
     }
 }
}
class BookingThread implements Runnable {
 private TicketBookingSystem system;
 private String userName;
 private int ticketsToBook;
 public BookingThread(TicketBookingSystem system, String userName, int ticketsToBook) {
     this.system = system;
     this.userName = userName;
     this.ticketsToBook = ticketsToBook;
 }
 @Override
 public void run() 
 {
     system.bookTicket(userName, ticketsToBook);
 }
}
public class Bank_Program {
 public static void main(String[] args) {
     TicketBookingSystem system = new TicketBookingSystem(5); 
     Thread user1 = new Thread(new BookingThread(system, "User1", 2));
     Thread user2 = new Thread(new BookingThread(system, "User2", 3));
     Thread user3 = new Thread(new BookingThread(system, "User3", 2)); 
     user1.start();
     user2.start();
     user3.start();
     try
     {
         user1.join();
         user2.join();
         user3.join();
     } 
     catch (InterruptedException e) 
     {
         System.out.println("Thread interrupted.");
     }
     System.out.println("All booking requests have been processed");
 }
}

