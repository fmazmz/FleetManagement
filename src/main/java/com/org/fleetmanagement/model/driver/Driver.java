package com.org.fleetmanagement.model.driver;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.org.fleetmanagement.model.vehicle.Vehicle;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fname;
    private String lname;
    private String ssn;

    @OneToMany(mappedBy = "driver")
    private List<Vehicle> vehicles = new ArrayList<>();

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

    public Driver(String fname, String lname, String ssn) {
        this.fname = fname;
        this.lname = lname;
        this.ssn = ssn;
    }
}
