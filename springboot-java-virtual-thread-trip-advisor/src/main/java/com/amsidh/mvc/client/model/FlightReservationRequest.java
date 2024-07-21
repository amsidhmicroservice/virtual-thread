package com.amsidh.mvc.client.model;

import java.time.LocalDate;

public record FlightReservationRequest(String departure, String arrival, String flightNumber, LocalDate tripDate) {
}
