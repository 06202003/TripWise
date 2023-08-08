package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class AirplaneRouteSearch {
    private List<AirplaneRoute> allAirplaneRoute;

    public AirplaneRouteSearch() {
        allAirplaneRoute = new ArrayList<>();
    }

    public void addRouteA(AirplaneRoute airplaneRoute) {
        allAirplaneRoute.add(airplaneRoute);
    }

    public List<AirplaneRoute> searchRoutes(String source, String destination) {
        List<AirplaneRoute> matchingAirplaneRoutes = new ArrayList<>();

        for (AirplaneRoute airplaneRoute : allAirplaneRoute) {
            if (airplaneRoute.getSourceAirport().equals(source) && airplaneRoute.getDestinationAirport().equals(destination)) {
                matchingAirplaneRoutes.add(airplaneRoute);
            }
        }

        return matchingAirplaneRoutes;
    }
}

