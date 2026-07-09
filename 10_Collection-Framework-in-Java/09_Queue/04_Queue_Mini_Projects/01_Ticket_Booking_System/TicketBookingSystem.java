import java.util.ArrayDeque;
import java.util.Queue;

public class TicketBookingSystem {
    public static void main(String[] args) {
        Queue<String> ticketQueue = new ArrayDeque<>();
        int availableTickets = 3;

        // 1. Customers join the queue
        ticketQueue.offer("Alice");
        ticketQueue.offer("Bob");
        ticketQueue.offer("Charlie");
        ticketQueue.offer("Dave"); // Dave might miss out!

        System.out.println("Initial queue of ticket buyers: " + ticketQueue);

        // 2. Process booking requests sequentially
        System.out.println("\n--- Ticket Booking Process ---");
        while (!ticketQueue.isEmpty()) {
            String customer = ticketQueue.poll();
            if (availableTickets > 0) {
                System.out.println(customer + " successfully booked a ticket!");
                availableTickets--;
            } else {
                System.out.println("Sorry " + customer + ", tickets are sold out!");
            }
        }

        System.out.println("\nTickets remaining: " + availableTickets);
    }
}
