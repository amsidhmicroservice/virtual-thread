package com.amsidh.mvc.dto;

import com.amsidh.mvc.client.model.*;

import java.util.List;

public record TripPlanResponse(String airportCode, List<Accommodation> accommodations, Weather weather, List<Event> events,
                               LocalRecommendations localRecommendations, Transportation transportation) {
}
