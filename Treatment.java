package com.petcare;

import java.io.Serializable;

public class Treatment implements Serializable {

    private static final long serialVersionUID = 1L;

    private int treatmentId;
    private int petId;
    private int vetId;
    private String diagnosis;
    private String medicine;
    private String treatmentDate;

    public Treatment(int treatmentId, int petId, int vetId,
                     String diagnosis, String medicine,
                     String treatmentDate) {

        this.treatmentId = treatmentId;
        this.petId = petId;
        this.vetId = vetId;
        this.diagnosis = diagnosis;
        this.medicine = medicine;
        this.treatmentDate = treatmentDate;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public int getPetId() {
        return petId;
    }

    public int getVetId() {
        return vetId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getMedicine() {
        return medicine;
    }

    public String getTreatmentDate() {
        return treatmentDate;
    }

    public void displayInfo() {

        System.out.println("--------------------------------");
        System.out.println("Treatment ID   : " + treatmentId);
        System.out.println("Pet ID         : " + petId);
        System.out.println("Vet ID         : " + vetId);
        System.out.println("Diagnosis      : " + diagnosis);
        System.out.println("Medicine       : " + medicine);
        System.out.println("Treatment Date : " + treatmentDate);
        System.out.println("--------------------------------");
    }
}