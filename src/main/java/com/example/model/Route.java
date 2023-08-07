package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private List<Station> stations;

    public Route() {
        stations = new ArrayList<>();
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public List<Station> getStations() {
        return stations;
    }
}
