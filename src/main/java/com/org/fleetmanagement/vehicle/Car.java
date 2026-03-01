package com.org.fleetmanagement.vehicle;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
public class Car extends Vehicle {
    public Car(UUID id, String make, String model, int year) {
        super(id, make, model, year);
    }
}
