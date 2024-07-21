package com.amsidh.mvc.client;

import com.amsidh.mvc.client.model.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public class WeatherServiceClient {


    private final RestClient restClient;

    public Weather getWeather(String airportCode) {
        return this.restClient
                .get()
                .uri("/{airportCode}", airportCode)
                .retrieve()
                .body(Weather.class);
    }
}
