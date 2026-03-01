package com.org.fleetmanagement.vehicle;

import java.util.UUID;

public record VehicleResponse(
        UUID id,
        FuelType fuelType,
        String make,
        String model,
        String vin,
        int year,
        long createdAt,
        long updatedAt
)
{
    public static VehicleResponse from(Vehicle vehicle) {
        return new VehicleResponse(
                vehicle.getId(),
                vehicle.getFuelType(),
                vehicle.getMake(),
                vehicle.getModel(),
                vehicle.getVin(),
                vehicle.getYear(),
                vehicle.getCreatedAt().toEpochMilli(),
                vehicle.getUpdatedAt().toEpochMilli()
        );
    }
}
