package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class TrainRoute {
    private String sourceStation;
    private String destinationStation;
    private List<Train> availableTrains;

    public TrainRoute(String sourceStation, String destinationStation) {
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.availableTrains = new ArrayList<>();
    }

    public void addTrain(Train train) {
        availableTrains.add(train);
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
