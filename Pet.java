package com.petcare;

import java.io.Serializable;

public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;

    private int petId;
    private String name;
    private String type;
    private String breed;
    private int age;
    private String gender;
    private double weight;
    private int ownerId;

    public Pet(int petId, String name, String type,
               String breed, int age, String gender,
               double weight, int ownerId) {

        this.petId = petId;
        this.name = name;
        this.type = type;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.ownerId = ownerId;
    }

    public int getPetId() {
        return petId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getWeight() {
        return weight;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void displayInfo() {

        System.out.println("--------------------------------");
        System.out.println("Pet ID      : " + petId);
        System.out.println("Name        : " + name);
        System.out.println("Type        : " + type);
        System.out.println("Breed       : " + breed);
        System.out.println("Age         : " + age);
        System.out.println("Gender      : " + gender);
        System.out.println("Weight      : " + weight + " kg");
        System.out.println("Owner ID    : " + ownerId);
        System.out.println("--------------------------------");
    }
}