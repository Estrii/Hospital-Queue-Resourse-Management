package queue;

import model.Patient;
import java.util.PriorityQueue;

public class TriageQueue {

    private PriorityQueue<Patient> queue;

    public TriageQueue() {
        queue = new PriorityQueue<>((p1, p2) -> {
            int cmp = Integer.compare(p2.urgency.priority, p1.urgency.priority);
            if (cmp == 0) {
                return p1.arrivalTime.compareTo(p2.arrivalTime);
            }
            return cmp;
        });
    }

    public void addPatient(Patient patient) {
        queue.offer(patient);
    }

    public Patient getNextPatient() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}