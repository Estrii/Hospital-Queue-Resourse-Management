package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Patient implements Serializable {

    private static int counter = 1;

    public int id;
    public String name;
    public UrgencyLevel urgency;
    public PatientStatus status;
    public LocalDateTime arrivalTime;
    public LocalDateTime startTreatment;
    public List<String> history;

    public Patient(String name, UrgencyLevel urgency) {
        this.id = counter++;
        this.name = name;
        this.urgency = urgency;
        this.status = PatientStatus.WAITING;
        this.arrivalTime = LocalDateTime.now();
        this.history = new ArrayList<>();
        history.add("Arrived at " + arrivalTime);
    }
}