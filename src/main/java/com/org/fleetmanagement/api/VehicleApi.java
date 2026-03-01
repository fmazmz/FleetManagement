package com.org.fleetmanagement.api;

import com.org.fleetmanagement.service.VehicleService;
import com.org.fleetmanagement.vehicle.CreateVehicle;
import com.org.fleetmanagement.vehicle.Vehicle;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/vehicles")
public class VehicleApi {
    private final VehicleService vehicleService;

    public VehicleApi(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<Vehicle>>> getAll() {
        return ResponseEntity.ok(new ApiResponse<>(vehicleService.getAllVehicles()));
    }

    @GetMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<Vehicle>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(new ApiResponse<>(vehicleService.getVehicleById(id)));
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<Vehicle>> create(
            @RequestBody CreateVehicle createVehicleRequest
    )
    {
        return ResponseEntity.ok(new ApiResponse<>(vehicleService.createVehicle(
                createVehicleRequest.type(),
                createVehicleRequest.make(),
                createVehicleRequest.model(),
                createVehicleRequest.year()
        )));
    }
}
