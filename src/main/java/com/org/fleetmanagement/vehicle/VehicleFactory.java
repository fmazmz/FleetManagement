package com.org.fleetmanagement.vehicle;

import org.springframework.stereotype.Component;

@Component
public class VehicleFactory {

    public Vehicle createVehicle(String type, String make, String model, int year) {
        Vehicle vehicle = null;

        switch (type.toUpperCase()) {
            default:
                throw new IllegalArgumentException("Unknown vehicle type");

            case "CAR":
                Car car = new Car(make, model, year);
                vehicle = car;
                break;
        }

        return vehicle;
    }
}
