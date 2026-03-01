package com.org.fleetmanagement.service;

import com.org.fleetmanagement.repository.VehicleRepository;
import com.org.fleetmanagement.vehicle.Vehicle;
import com.org.fleetmanagement.vehicle.VehicleFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VehicleService {
    private final VehicleRepository repository;
    private final VehicleFactory factory;

    public VehicleService(VehicleRepository repository, VehicleFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    public Vehicle createVehicle(String type, String make, String model, int year) {
        Vehicle vehicle = factory.createVehicle(type, make, model, year);
        repository.save(vehicle);

        return vehicle;
    }

    public Vehicle getVehicleById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException
                        (String.format("Vehicle with id: %s not found", id)));
    }

    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }
}
