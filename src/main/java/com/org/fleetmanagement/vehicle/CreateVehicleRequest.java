package com.org.fleetmanagement.vehicle;

public record CreateVehicleRequest(
        VehicleType type,
        String make,
        String model,
        int year
) {}
