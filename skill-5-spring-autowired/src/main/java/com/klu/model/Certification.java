package com.klu.model;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id;
    private String name;
    private String dateOfCompletion;

    public Certification() {
        this.id = 201;
        this.name = "Spring Framework Certification";
        this.dateOfCompletion = "2026";
    }

    public void displayCertification() {
        System.out.println("Certification ID: " + id);
        System.out.println("Certification Name: " + name);
        System.out.println("Date Of Completion: " + dateOfCompletion);
    }
}