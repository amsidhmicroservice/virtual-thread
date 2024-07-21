package com.amsidh.mvc.service;

import com.amsidh.mvc.dto.TripPlanResponse;

public interface TripPlanService {

    TripPlanResponse getTripPlan(String airportCode);
}
