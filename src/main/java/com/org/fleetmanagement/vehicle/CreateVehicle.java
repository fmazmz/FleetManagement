package com.org.fleetmanagement.vehicle;

public record CreateVehicle(
        String type,
        String make,
        String model,
        int year
) {}
