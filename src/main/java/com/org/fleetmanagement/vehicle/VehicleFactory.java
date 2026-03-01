package com.org.fleetmanagement.vehicle;

import org.springframework.stereotype.Component;

@Component
public class VehicleFactory {

    public Vehicle createVehicle(
            VehicleType type,
            FuelType fuelType,
            String make,
            String model,
            String vin,
            int year
    )
    {
        Vehicle vehicle;

        switch (type) {
            default:
                throw new IllegalArgumentException("Unknown vehicle type");

            case VehicleType.CAR:
                Car car = new Car(fuelType, make, model, vin, year);
                vehicle = car;
                break;
        }

        return vehicle;
    }
}
