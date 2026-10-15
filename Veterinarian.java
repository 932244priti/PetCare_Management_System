package com.petcare;

public class Veterinarian extends Person {

    private static final long serialVersionUID = 1L;

    private String specialization;

    public Veterinarian(int id, String name, String phone,
                        String specialization) {

        super(id, name, phone);

        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public void displayInfo() {

        System.out.println("--------------------------------");
        System.out.println("Vet ID         : " + id);
        System.out.println("Name           : " + name);
        System.out.println("Phone          : " + phone);
        System.out.println("Specialization : " + specialization);
        System.out.println("--------------------------------");
    }
}