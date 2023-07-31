package com.example.model;

import java.util.List;

public class Train {
    private int id;
    private List<String> routeStations;
    private int noTrain;

    public Train(int id, List<String> routeStations, int noTrain) {
        this.id = id;
        this.routeStations = routeStations;
        this.noTrain = noTrain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getRouteStations() {
        return routeStations;
    }

    public void setRouteStations(List<String> routeStations) {
        this.routeStations = routeStations;
    }

    public int getNoTrain() {
        return noTrain;
    }

    public void setNoTrain(int noTrain) {
        this.noTrain = noTrain;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Train ID: ").append(id).append("\n");
        sb.append("Route Stations: ").append(routeStations).append("\n");
        sb.append("Train Number: ").append(noTrain).append("\n");
        return sb.toString();
    }
}
