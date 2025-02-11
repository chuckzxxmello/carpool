package com.app.carpool.controller;

import com.app.carpool.model.Ride;
import com.app.carpool.service.RideService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
public class RideController {

    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @PostMapping("/rides")
    public ResponseEntity<Ride> createRide(@Valid @RequestBody Ride ride) {
        Ride createdRide = rideService.createRide(ride);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRide);
    }

    @GetMapping("/rides")
    public ResponseEntity<List<Ride>> getRides() {
        List<Ride> rides = rideService.getAllRides();

        if (rides.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(rides);
    }
}
