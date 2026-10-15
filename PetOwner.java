package com.petcare;

import java.io.Serializable;

public class PetOwner extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String email;
    private String address;

    public PetOwner(int id, String name, String phone,
                    String email, String address) {

        super(id, name, phone);

        this.email = email;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public void displayInfo() {

        System.out.println("--------------------------------");
        System.out.println("Owner ID : " + id);
        System.out.println("Name     : " + name);
        System.out.println("Phone    : " + phone);
        System.out.println("Email    : " + email);
        System.out.println("Address  : " + address);
        System.out.println("--------------------------------");
    }
}