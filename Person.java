package com.petcare;

import java.io.Serializable;

public abstract class Person implements Serializable { 
    // Abstraction used in this project

    private static final long serialVersionUID = 1L;

    protected int id;
    protected String name;
    protected String phone;

    public Person(int id, String name, String phone) {

        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public abstract void displayInfo();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}