package com.petcare;

public class InvalidPetException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidPetException(String message) {
        super(message);
    }
}