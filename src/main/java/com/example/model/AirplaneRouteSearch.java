package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class AirplaneRouteSearch {
    private List<AirplaneRoute> allAirplaneRoutes;

    public AirplaneRouteSearch() {
        allAirplaneRoutes = new ArrayList<>();
    }

    public void addRoute(AirplaneRoute airplaneRoute) {
        allAirplaneRoutes.add(airplaneRoute);
    }

    public List<AirplaneRoute> searchRoutes(String source, String destination) {
        List<AirplaneRoute> matchingAirplaneRoutes = new ArrayList<>();

        for (AirplaneRoute airplaneRoute : allAirplaneRoutes) {
            if (airplaneRoute.getSourceAirport().equals(source) && airplaneRoute.getDestinationAirport().equals(destination)) {
                matchingAirplaneRoutes.add(airplaneRoute);
            }
        }

        return matchingAirplaneRoutes;
    }
}
