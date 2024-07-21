package com.amsidh.mvc.config;

import com.amsidh.mvc.client.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.net.http.HttpClient;
import java.util.concurrent.Executors;

@Configuration
public class AppConfig {

    @Value("${accommodation.service.url}")
    private String accommodationServiceBaseUrl;

    @Value("${event.service.url}")
    private String eventServiceBaseUrl;

    @Value("${local-recommendation.service.url}")
    private String localRecommendationServiceBaseUrl;

    @Value("${transportation.service.url}")
    private String transportServiceBaseUrl;

    @Value("${weather.service.url}")
    private String weatherServiceBaseUrl;

    @Value("${flight-search.service.url}")
    private String flightSearchServiceBaseUrl;

    @Value("${flight-reservation.service.url}")
    private String flightReservationServiceBaseUrl;

    @Value("${spring.threads.virtual.enabled}")
    private boolean isVirtualThreadEnabled;

    public RestClient restClient(String baseUrl) {
        var builder = RestClient.builder().baseUrl(baseUrl);
        if (isVirtualThreadEnabled) {
            builder.requestFactory(new JdkClientHttpRequestFactory(HttpClient.newBuilder().executor(Executors.newVirtualThreadPerTaskExecutor()).build()));
        }
        return builder.build();
    }

    @Bean
    public AccommodationServiceClient getAccommodationServiceClient() {
        return new AccommodationServiceClient(restClient(accommodationServiceBaseUrl));
    }

    @Bean
    public EventServiceClient getEventServiceClient() {
        return new EventServiceClient(restClient(eventServiceBaseUrl));
    }

    @Bean
    public LocalRecommendationServiceClient getLocalRecommendationServiceClient() {
        return new LocalRecommendationServiceClient(restClient(localRecommendationServiceBaseUrl));
    }

    @Bean
    public TransportationServiceClient getTransportationServiceClient() {
        return new TransportationServiceClient(restClient(transportServiceBaseUrl));
    }

    @Bean
    public WeatherServiceClient getWeatherServiceClient() {
        return new WeatherServiceClient(restClient(weatherServiceBaseUrl));
    }

    @Bean
    public FlightSearchServiceClient getFlightSearchServiceClient() {
        return new FlightSearchServiceClient(restClient(flightSearchServiceBaseUrl));
    }

    @Bean
    public FlightReservationServiceClient getFlightReservationServiceClient() {
        return new FlightReservationServiceClient(restClient(flightReservationServiceBaseUrl));
    }

}
