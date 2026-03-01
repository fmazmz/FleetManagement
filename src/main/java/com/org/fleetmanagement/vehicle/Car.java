package com.org.fleetmanagement.vehicle;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Car extends Vehicle {
    public Car(String make, String model, int year) {
        super(make, model, year);
    }
}
