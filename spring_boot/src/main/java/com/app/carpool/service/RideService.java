package com.app.carpool.service;

import com.app.carpool.model.Ride;
import com.app.carpool.repository.RideRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {

    private final RideRepository rideRepository;

    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    public Ride createRide(Ride ride) {
        return rideRepository.save(ride);
    }
}
