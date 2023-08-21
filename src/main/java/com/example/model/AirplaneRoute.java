package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class AirplaneRoute {
    private String sourceAirport;
    private String destinationAirport;
    private List<Airplane> availableAirplanes;

    public AirplaneRoute(String sourceAirport, String destinationAirport) {
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.availableAirplanes = new ArrayList<>();
    }

    public void addAirplane(Airplane airplane) {
        availableAirplanes.add(airplane);
    }

    public String getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(String sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public List<Airplane> getAvailableAirplanes() {
        return availableAirplanes;
    }

    public void setAvailableAirplanes(List<Airplane> availableAirplanes) {
        this.availableAirplanes = availableAirplanes;
    }
}
