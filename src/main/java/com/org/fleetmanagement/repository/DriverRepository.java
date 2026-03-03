package com.org.fleetmanagement.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.fleetmanagement.model.driver.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, UUID> {

}
