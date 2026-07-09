import java.util.PriorityQueue;
import java.util.Queue;

class Patient implements Comparable<Patient> {
    String name;
    String condition;
    int severity; // 1 = Critical (Emergency), 2 = Serious, 3 = Minor

    public Patient(String name, String condition, int severity) {
        this.name = name;
        this.condition = condition;
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient other) {
        // Lower severity value gets treated first
        return Integer.compare(this.severity, other.severity);
    }

    @Override
    public String toString() {
        return name + " [" + condition + " | Severity: " + severity + "]";
    }
}

public class HospitalPatientQueue {
    public static void main(String[] args) {
        Queue<Patient> erQueue = new PriorityQueue<>();

        // 1. Patients arrive at the Emergency Room
        erQueue.offer(new Patient("Amit", "Flu Symptoms", 3));
        erQueue.offer(new Patient("Priya", "Chest Pain", 1)); // Highest priority
        erQueue.offer(new Patient("Rahul", "Sprained Ankle", 2));

        System.out.println("Arriving Patients added to ER Queue.");

        // 2. Doctor treats patients by severity order
        System.out.println("\n--- ER Triage Tending Sequence ---");
        while (!erQueue.isEmpty()) {
            Patient patient = erQueue.poll();
            System.out.println("Tending to: " + patient.name + " (" + patient.condition + ")");
        }
        System.out.println("\nAll arrived patients have been tended to.");
    }
}
