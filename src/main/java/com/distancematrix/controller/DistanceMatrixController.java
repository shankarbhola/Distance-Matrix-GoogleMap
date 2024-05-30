package com.distancematrix.controller;

import com.distancematrix.service.DistanceMatrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceMatrixController {

    private final DistanceMatrixService distanceMatrixService;

    public DistanceMatrixController(DistanceMatrixService distanceMatrixService) {
        this.distanceMatrixService = distanceMatrixService;
    }

    //http://localhost:8080/distanceByAddress?origins=New+York,NY&destinations=Los+Angeles,CA
    @GetMapping("/distanceByAddress")
    public String getDistanceByAddress(@RequestParam String origins, @RequestParam String destinations) {
        return distanceMatrixService.getDistanceByAddress(origins, destinations);
    }

    //http://localhost:8080/distanceByCoordinates?originLat=40.712776&originLng=-74.005974&destLat=34.052235&destLng=-118.243683
    @GetMapping("/distanceByCoordinates")
    public String getDistanceByCoordinates(@RequestParam double originLat, @RequestParam double originLng,
                                           @RequestParam double destLat, @RequestParam double destLng) {
        return distanceMatrixService.getDistanceByCoordinates(originLat, originLng, destLat, destLng);
    }
}
