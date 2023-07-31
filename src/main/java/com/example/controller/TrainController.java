package com.example.controller;

import com.example.model.Route;
import com.example.model.Train;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainController {
    @FXML
    private List<Train> trains;

    public TrainController() {
        trains = new ArrayList<>();

        List<String> routeStations1 = List.of("Station A", "Station B", "Station C");
        Train train1 = new Train(1, routeStations1, 123);

        List<String> routeStations2 = List.of("Station X", "Station Y", "Station Z");
        Train train2 = new Train(2, routeStations2, 456);

        trains.add(train1);
        trains.add(train2);
    }

    @FXML
    private void showTrains() {
        // Simulate search results, you can implement your actual search logic here
        List<Train> searchResults = trains;

        // Print the search results to the console
        for (Train train : searchResults) {
            System.out.println(train);
            System.out.println("----------------------------");
        }
    }
}
