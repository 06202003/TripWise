package com.example.model;

import java.util.List;

public class TrainRoute {
    private int trainRouteId;
    private String sourceStation;
    private String destinationStation;
    private List<Train> availableTrains;

    public TrainRoute(int trainRouteId, String sourceStation, String destinationStation, List<Train> availableTrains) {
        this.trainRouteId = trainRouteId;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.availableTrains = availableTrains;
    }

    public int getTrainRouteId() {
        return trainRouteId;
    }

    public String getSourceStation() {
        return sourceStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public List<Train> getAvailableTrains() {
        return availableTrains;
    }
}
