package com.org.fleetmanagement.vehicle;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fname;
    private String lname;
    private String ssn;
    private List<Vehicle> vehicles;
}
