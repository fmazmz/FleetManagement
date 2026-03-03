package com.org.fleetmanagement.service;

import com.org.fleetmanagement.model.driver.Driver;
import com.org.fleetmanagement.model.driver.DriverRequest;
import com.org.fleetmanagement.model.driver.DriverResponse;
import org.springframework.stereotype.Service;

import com.org.fleetmanagement.repository.DriverRepository;

import java.util.UUID;

@Service
public class DriverService {
    private final DriverRepository repository;

    public DriverService(DriverRepository repository) {
        this.repository = repository;
    }

    public DriverResponse createDriver(DriverRequest request) {
        Driver driver = new Driver(
                request.fname(),
                request.lname(),
                request.ssn()
        );
        repository.save(driver);

        return DriverResponse.from(driver);
    }

    public DriverResponse getDriverById(UUID id) {
        Driver driver = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Vehicle with id: %s not found", id)
                ));

        return DriverResponse.from(driver);
    }
}
