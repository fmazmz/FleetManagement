package com.org.fleetmanagement.vehicle;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public abstract class Vehicle {
    private final UUID id;
    private final String make;
    private final String model;
    private final int year;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Vehicle(UUID id, String make, String model, int year) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
    }
}
