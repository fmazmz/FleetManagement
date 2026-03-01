package com.org.fleetmanagement.service;

import com.org.fleetmanagement.repository.VehicleRepository;
import com.org.fleetmanagement.vehicle.CreateVehicleRequest;
import com.org.fleetmanagement.vehicle.Vehicle;
import com.org.fleetmanagement.vehicle.VehicleFactory;
import com.org.fleetmanagement.vehicle.VehicleResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    private final VehicleRepository repository;
    private final VehicleFactory factory;

    public VehicleService(VehicleRepository repository, VehicleFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    public VehicleResponse createVehicle(CreateVehicleRequest request) {
        Vehicle vehicle = factory.createVehicle(
                request.vehicleType(),
                request.fuelType(),
                request.make(),
                request.model(),
                request.vin(),
                request.year()
        );
        repository.save(vehicle);

        return VehicleResponse.from(vehicle);
    }

    public VehicleResponse getVehicleById(UUID id) {
        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException
                        (String.format("Vehicle with id: %s not found", id)));

        return VehicleResponse.from(vehicle);
    }

    public Map<String, List<VehicleResponse>> getAllVehicles() {
        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        vehicle -> vehicle.getVehicleType().name(),
                        Collectors.mapping(VehicleResponse::from, Collectors.toList())
                ));
    }
}
