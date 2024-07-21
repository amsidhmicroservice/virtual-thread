package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.client.FlightReservationServiceClient;
import com.amsidh.mvc.client.FlightSearchServiceClient;
import com.amsidh.mvc.client.model.Flight;
import com.amsidh.mvc.client.model.FlightReservationRequest;
import com.amsidh.mvc.client.model.FlightReservationResponse;
import com.amsidh.mvc.dto.TripReservationRequest;
import com.amsidh.mvc.service.TripReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class TripReservationServiceImpl implements TripReservationService {
    private final FlightSearchServiceClient flightSearchServiceClient;
    private final FlightReservationServiceClient flightReservationServiceClient;

    @Override
    public FlightReservationResponse reservation(TripReservationRequest tripReservationRequest) {
        final List<Flight> flights = flightSearchServiceClient
                .getFlights(tripReservationRequest.departure(), tripReservationRequest.arrival());
        final Flight bestFlightDeal = flights.stream()
                .min(Comparator.comparing(Flight::price))
                .orElseThrow(() -> new RuntimeException("No flight found"));
        var flightReservationRequest = new FlightReservationRequest(tripReservationRequest.departure(), tripReservationRequest.arrival(), bestFlightDeal.flightNumber(), tripReservationRequest.date());
        return flightReservationServiceClient.reserveFlight(flightReservationRequest);
    }
}
