package com.org.fleetmanagement.api;

import com.org.fleetmanagement.service.DriverService;
import com.org.fleetmanagement.model.driver.DriverRequest;
import com.org.fleetmanagement.model.driver.DriverResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/drivers")
public class DriverApi {

    private final DriverService driverService;

    public DriverApi(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<DriverResponse>> create(
            @RequestBody DriverRequest driverRequest
    ) {
        return ResponseEntity.ok(new ApiResponse<>(driverService.createDriver(
                driverRequest
        )));
    }
}
