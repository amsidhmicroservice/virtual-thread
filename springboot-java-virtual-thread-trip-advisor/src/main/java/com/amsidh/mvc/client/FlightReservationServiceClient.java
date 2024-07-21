package com.amsidh.mvc.client;

import com.amsidh.mvc.client.model.FlightReservationRequest;
import com.amsidh.mvc.client.model.FlightReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public class FlightReservationServiceClient {


    private final RestClient restClient;

    public FlightReservationResponse reserveFlight(FlightReservationRequest flightReservationRequest) {
        return this.restClient
                .post()
                .body(flightReservationRequest)
                .retrieve()
                .body(FlightReservationResponse.class);
    }
}
