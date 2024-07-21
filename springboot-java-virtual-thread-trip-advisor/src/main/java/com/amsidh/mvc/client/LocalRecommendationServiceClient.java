package com.amsidh.mvc.client;

import com.amsidh.mvc.client.model.LocalRecommendations;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public class LocalRecommendationServiceClient {


    private final RestClient restClient;

    public LocalRecommendations getLocalRecommendations(String airportCode) {
        return this.restClient
                .get()
                .uri("/{airportCode}", airportCode)
                .retrieve()
                .body(LocalRecommendations.class);
    }
}
