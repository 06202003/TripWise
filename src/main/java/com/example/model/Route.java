package com.example.model;

import java.util.List;

public class Route {
    private List<String> routeStations;

    public Route(List<String> routeStations) {
        this.routeStations = routeStations;
    }

    public List<String> getRouteStations() {
        return routeStations;
    }

    public void setRouteStations(List<String> routeStations) {
        this.routeStations = routeStations;
    }

    @Override
    public String toString() {
        return "Route Stations: " + routeStations;
    }
}
