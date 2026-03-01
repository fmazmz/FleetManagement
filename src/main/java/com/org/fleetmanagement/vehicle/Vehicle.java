package com.org.fleetmanagement.vehicle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private VehicleType vehicleType;
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private String make;
    private String model;
    private String vin;
    private int year;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

    public Vehicle(
            VehicleType vehicleType,
            FuelType fuelType,
            String make,
            String model,
            String vin,
            int year
    )
    {
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.year = year;
    }
}
