package com.org.fleetmanagement.vehicle;

import org.springframework.stereotype.Component;

@Component
public class VehicleFactory {

    public Vehicle createVehicle(VehicleType type, String make, String model, int year) {
        Vehicle vehicle;

        switch (type) {
            default:
                throw new IllegalArgumentException("Unknown vehicle type");

            case VehicleType.CAR:
                Car car = new Car(make, model, year);
                vehicle = car;
                break;
        }

        return vehicle;
    }
}
