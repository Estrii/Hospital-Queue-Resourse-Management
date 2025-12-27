package core;

import model.*;
import queue.TriageQueue;
import resources.ResourcePool;

import java.util.ArrayList;
import java.util.List;

public class Hospital {

    private TriageQueue triageQueue;
    private ResourcePool resources;
    private List<Patient> completedPatients;

    public Hospital(ResourcePool resources) {
        this.resources = resources;
        this.triageQueue = new TriageQueue();
        this.completedPatients = new ArrayList<>();
    }

    public void admitPatient(Patient patient) {
        triageQueue.addPatient(patient);
        System.out.println("Admitted: " + patient.name + " | Urgency: " + patient.urgency);
    }

    public void processPatient() {
        if (!triageQueue.isEmpty() && resources.allocate()) {

            Patient p = triageQueue.getNextPatient();
            p.startTreatment = java.time.LocalDateTime.now();

            p.status = PatientStatus.DIAGNOSIS;
            p.history.add("Diagnosis started");

            p.status = PatientStatus.TREATMENT;
            p.history.add("Treatment started");

            p.status = PatientStatus.RECOVERY;
            p.history.add("Recovery");

            p.status = PatientStatus.DISCHARGED;
            p.history.add("Discharged");

            completedPatients.add(p);
            resources.release();
        }
    }

    public void printStatistics() {
        System.out.println("---- STATISTICS ----");
        System.out.println("Patients treated: " + completedPatients.size());
    }
}