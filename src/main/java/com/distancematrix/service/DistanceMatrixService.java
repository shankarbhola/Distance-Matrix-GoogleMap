package com.distancematrix.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DistanceMatrixService {

    @Value("${google.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public DistanceMatrixService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getDistanceByAddress(String origins, String destinations) {
        String url = String.format(
                "https://maps.googleapis.com/maps/api/distancematrix/json?origins=%s&destinations=%s&key=%s",
                origins, destinations, apiKey);
        return restTemplate.getForObject(url, String.class);
    }

    public String getDistanceByCoordinates(double originLat, double originLng, double destLat, double destLng) {
        String origins = String.format("%f,%f", originLat, originLng);
        String destinations = String.format("%f,%f", destLat, destLng);
        String url = String.format(
                "https://maps.googleapis.com/maps/api/distancematrix/json?origins=%s&destinations=%s&key=%s",
                origins, destinations, apiKey);
        return restTemplate.getForObject(url, String.class);
    }
}
