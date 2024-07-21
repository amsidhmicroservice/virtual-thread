package com.amsidh.mvc.client;

import com.amsidh.mvc.client.model.Transportation;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public class TransportationServiceClient {


    private final RestClient restClient;

    public Transportation getTransport(String airportCode) {
        return this.restClient
                .get()
                .uri("/{airportCode}", airportCode)
                .retrieve()
                .body(Transportation.class);
    }
}
