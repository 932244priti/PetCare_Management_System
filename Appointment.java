package com.petcare;

import java.io.Serializable;

public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;

    private int appointmentId;
    private int petId;
    private int vetId;
    private String date;
    private String time;
    private String reason;
    private String status;

    public Appointment(int appointmentId, int petId, int vetId,
                       String date, String time, String reason) {

        this.appointmentId = appointmentId;
        this.petId = petId;
        this.vetId = vetId;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.status = "Booked";
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getPetId() {
        return petId;
    }

    public int getVetId() {
        return vetId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    public void displayInfo() {

        System.out.println("--------------------------------");
        System.out.println("Appointment ID : " + appointmentId);
        
        System.out.println("Vet ID         : " + vetId);
        System.out.println("Date           : " + date);
        System.out.println("Time           : " + time);
        System.out.println("Reason         : " + reason);
        System.out.println("Status         : " + status);
        System.out.println("--------------------------------");
    }
}