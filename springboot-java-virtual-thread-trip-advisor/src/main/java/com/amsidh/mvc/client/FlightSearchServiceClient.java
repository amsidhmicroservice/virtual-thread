package com.amsidh.mvc.client;

import com.amsidh.mvc.client.model.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

@RequiredArgsConstructor
public class FlightSearchServiceClient {


    private final RestClient restClient;

    public List<Flight> getFlights(String departure, String arrival) {
        return this.restClient
                .get()
                .uri("/{departure}/{arrival}", departure, arrival)
                .retrieve()
                .body(new ParameterizedTypeReference<List<Flight>>() {
                });
    }
}
