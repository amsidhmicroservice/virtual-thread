package com.amsidh.mvc.controller;

import com.amsidh.mvc.client.model.FlightReservationResponse;
import com.amsidh.mvc.dto.TripPlanResponse;
import com.amsidh.mvc.dto.TripReservationRequest;
import com.amsidh.mvc.service.TripPlanService;
import com.amsidh.mvc.service.TripReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/trip")
@Slf4j
public class TripController {

    private final TripPlanService tripPlanService;
    private final TripReservationService tripReservationService;

    @GetMapping("/{airportCode}")
    public TripPlanResponse planTrip(@PathVariable("airportCode") String airportCode) {
        log.info("airport code {} and is Virtual {}", airportCode, Thread.currentThread().isVirtual());
        return tripPlanService.getTripPlan(airportCode);
    }

    @PostMapping("/reserve")
    public FlightReservationResponse reserveFlight(@RequestBody TripReservationRequest reservationRequest) {
        return tripReservationService.reservation(reservationRequest);
    }
}
