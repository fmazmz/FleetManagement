package com.org.fleetmanagement.vehicle;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum VehicleType {
    CAR,
    TRUCK,
    BUS;

    @JsonCreator
    public static VehicleType fromString(String value) {
        if (value == null) throw new IllegalArgumentException("VehicleType cannot be null");
        return VehicleType.valueOf(value.toUpperCase());
    }
}
