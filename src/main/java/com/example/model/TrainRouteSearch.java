package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class TrainRouteSearch {
    private List<TrainRoute> allTrainRoutes;

    public TrainRouteSearch() {
        allTrainRoutes = new ArrayList<>();
    }

    public void addRoute(TrainRoute trainRoute) {
        allTrainRoutes.add(trainRoute);
    }

    public List<TrainRoute> searchRoutes(String source, String destination) {
        List<TrainRoute> matchingTrainRoutes = new ArrayList<>();

        for (TrainRoute trainRoute : allTrainRoutes) {
            if (trainRoute.getSourceStation().equals(source) && trainRoute.getDestinationStation().equals(destination)) {
                matchingTrainRoutes.add(trainRoute);
            }
        }

        return matchingTrainRoutes;
    }
}

