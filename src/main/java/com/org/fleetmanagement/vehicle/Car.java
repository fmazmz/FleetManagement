package com.org.fleetmanagement.vehicle;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Car extends Vehicle {
    public Car(FuelType fuelType, String make, String model, String vin, int year) {
        super(VehicleType.CAR, fuelType, make, model, vin, year);
    }
}
