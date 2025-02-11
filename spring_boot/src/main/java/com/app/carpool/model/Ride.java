package com.app.carpool.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "rides")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    @JsonProperty("driver")
    private User driver;

    @NotNull(message = "Start location is required")
    @Column(name = "start_location")
    private String startLocation;

    @NotNull(message = "Destination is required")
    private String destination;

    @NotNull(message = "Departure time is required")
    @Future(message = "Departure time must be in the future")
    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Min(value = 1, message = "Available seats must be at least 1")
    @Column(name = "available_seats")
    private int availableSeats;

    @Min(value = 0, message = "Price cannot be negative")
    private double price;

    @Enumerated(EnumType.STRING)
    private RideStatus status = RideStatus.AVAILABLE;
}
