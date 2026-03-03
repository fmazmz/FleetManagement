package com.org.fleetmanagement.model.driver;

import com.org.fleetmanagement.model.vehicle.VehicleResponse;

import java.util.List;
import java.util.UUID;

public record DriverResponse(
        UUID id,
        String fname,
        String lname,
        String ssn,
        List<VehicleResponse> vehicles,
        Long createdAt,
        Long updatedAt

) {
    public static DriverResponse from(Driver driver) {
        return new DriverResponse(
                driver.getId(),
                driver.getFname(),
                driver.getLname(),
                driver.getSsn(),
                driver.getVehicles()
                        .stream()
                        .map(VehicleResponse::from)
                        .toList(),
                driver.getCreatedAt().toEpochMilli(),
                driver.getUpdatedAt().toEpochMilli());
    }
}
