package com.amsidh.mvc.client.model;

import java.time.LocalDate;
import java.util.UUID;

public record FlightReservationResponse(UUID reservationId, String departure, String arrival, String flightNumber,
                                        LocalDate tripDate, int price) {
}
