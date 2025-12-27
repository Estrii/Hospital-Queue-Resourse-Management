package main;

import core.Hospital;
import model.*;
import resources.ResourcePool;

public class HospitalSimulation {

    public static void main(String[] args) {

        Hospital hospital = new Hospital(
                new ResourcePool(2, 3, 2)
        );

        hospital.admitPatient(new Patient("Anna", UrgencyLevel.HIGH));
        hospital.admitPatient(new Patient("Mark", UrgencyLevel.CRITICAL));
        hospital.admitPatient(new Patient("Elira", UrgencyLevel.MEDIUM));

        for (int i = 0; i < 3; i++) {
            hospital.processPatient();
        }

        hospital.printStatistics();
    }
}