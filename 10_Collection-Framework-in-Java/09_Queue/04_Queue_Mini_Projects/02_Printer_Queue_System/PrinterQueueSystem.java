import java.util.ArrayDeque;
import java.util.Queue;

class PrintJob {
    String docName;
    int pages;

    public PrintJob(String docName, int pages) {
        this.docName = docName;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return docName + " (" + pages + " pages)";
    }
}

public class PrinterQueueSystem {
    public static void main(String[] args) {
        Queue<PrintJob> printQueue = new ArrayDeque<>();

        // 1. Spooling incoming print jobs
        printQueue.offer(new PrintJob("Resume.pdf", 2));
        printQueue.offer(new PrintJob("TaxReport.xlsx", 45));
        printQueue.offer(new PrintJob("FamilyPhoto.png", 1));

        System.out.println("Print spooler queue: " + printQueue);

        // 2. Printing jobs in FIFO sequence
        System.out.println("\n--- Starting Print Jobs ---");
        while (!printQueue.isEmpty()) {
            PrintJob job = printQueue.poll();
            System.out.println("Printing: " + job.docName + " | Pages: " + job.pages);
            try {
                // Simulate time delay for printing pages
                Thread.sleep(job.pages * 50); 
            } catch (InterruptedException e) {
                System.out.println("Printing interrupted!");
            }
        }
        System.out.println("All print jobs completed successfully.");
    }
}
