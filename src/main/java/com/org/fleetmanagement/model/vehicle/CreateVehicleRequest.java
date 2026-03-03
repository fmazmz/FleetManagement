package com.org.fleetmanagement.model.vehicle;

public record CreateVehicleRequest(
        VehicleType vehicleType,
        FuelType fuelType,
        String make,
        String model,
        String vin,
        int year
) {}
