package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.client.*;
import com.amsidh.mvc.dto.TripPlanResponse;
import com.amsidh.mvc.service.TripPlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@RequiredArgsConstructor
@Service
@Slf4j
public class TripPlanServiceImpl implements TripPlanService {

    private final EventServiceClient eventServiceClient;
    private final LocalRecommendationServiceClient localRecommendationServiceClient;
    private final WeatherServiceClient weatherServiceClient;
    private final TransportationServiceClient transportationServiceClient;
    private final AccommodationServiceClient accommodationServiceClient;
    private final ExecutorService executorService;

    @Override
    public TripPlanResponse getTripPlan(String airportCode) {

        var events = executorService.submit(() -> eventServiceClient.getEvents(airportCode));
        var localRecommendations = executorService.submit(() -> localRecommendationServiceClient.getLocalRecommendations(airportCode));
        var weather = executorService.submit(() -> weatherServiceClient.getWeather(airportCode));
        var transportation = executorService.submit(() -> transportationServiceClient.getTransport(airportCode));
        var accommodations = executorService.submit(() -> accommodationServiceClient.getAccommodations(airportCode));
        return new TripPlanResponse(airportCode,
                getOrElse(accommodations, Collections.emptyList()),
                getOrElse(weather, null),
                getOrElse(events, Collections.emptyList()),
                getOrElse(localRecommendations, null),
                getOrElse(transportation, null));
    }

    private <T> T getOrElse(Future<T> future, T defaultValue) {
        try {
            return Optional.ofNullable(future.get()).orElse(defaultValue);
        } catch (Exception e) {
            log.error("Error {}", e.getMessage(), e);
        }
        return defaultValue;
    }
}
