package com.petcare;

import java.io.Serializable;

public class Vaccination implements Serializable {

    private static final long serialVersionUID = 1L;

    private int vaccinationId;
    private int petId;
    private String vaccineName;
    private String vaccinationDate;
    private String nextDueDate;

    public Vaccination(int vaccinationId, int petId,
                       String vaccineName,
                       String vaccinationDate,
                       String nextDueDate) {

        this.vaccinationId = vaccinationId;
        this.petId = petId;
        this.vaccineName = vaccineName;
        this.vaccinationDate = vaccinationDate;
        this.nextDueDate = nextDueDate;
    }

    public int getVaccinationId() {
        return vaccinationId;
    }

    public int getPetId() {
        return petId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public String getVaccinationDate() {
        return vaccinationDate;
    }

    public String getNextDueDate() {
        return nextDueDate;
    }

    public void displayInfo() {

        System.out.println("--------------------------------");
        System.out.println("Vaccination ID   : " + vaccinationId);
        System.out.println("Pet ID           : " + petId);
        System.out.println("Vaccine Name     : " + vaccineName);
        System.out.println("Vaccination Date : " + vaccinationDate);
        System.out.println("Next Due Date    : " + nextDueDate);
        System.out.println("--------------------------------");
    }
}