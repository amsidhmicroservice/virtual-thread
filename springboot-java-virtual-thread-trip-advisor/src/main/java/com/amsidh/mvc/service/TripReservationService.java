package com.amsidh.mvc.service;

import com.amsidh.mvc.client.model.FlightReservationRequest;
import com.amsidh.mvc.client.model.FlightReservationResponse;
import com.amsidh.mvc.dto.TripReservationRequest;

public interface TripReservationService {

    FlightReservationResponse reservation(TripReservationRequest tripReservationRequest);
}
