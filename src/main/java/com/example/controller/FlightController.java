package com.example.controller;

import com.example.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.util.List;

public class FlightController {

    @FXML
    private ComboBox<String> originComboBox1;

    @FXML
    private ComboBox<String> destinationComboBox1;

    @FXML
    private ListView<String> resultListViewAirplane;

    private AirplaneRouteSearch airplaneRouteSearch;

    public void initialize() {
        airplaneRouteSearch = new AirplaneRouteSearch();

        Airplane airplane1 = new Airplane("Garuda Indonesia");
        Airplane airplane2 = new Airplane("Citilink");
        Airplane airplane3 = new Airplane("Air Asia");


        AirplaneRoute airplaneRoute1 = new AirplaneRoute("Jakarta", "Bali");
        airplaneRoute1.addAirplane(airplane1);
        airplaneRoute1.addAirplane(airplane2);

        AirplaneRoute airplaneRoute2 = new AirplaneRoute("Bali", "Jakarta");
        airplaneRoute2.addAirplane(airplane2);
        airplaneRoute2.addAirplane(airplane3);

        airplaneRouteSearch.addRouteA(airplaneRoute1); // Change this to addRouteA
        airplaneRouteSearch.addRouteA(airplaneRoute2); // Change this to addRouteA


        ObservableList<String> origins2 = FXCollections.observableArrayList(
                "Jakarta",
                "Bandung",
                "Bali"
        );
        originComboBox1.setItems(origins2);

        ObservableList<String> destinations2 = FXCollections.observableArrayList(
                "Jakarta",
                "Bandung",
                "Bali"
        );
        destinationComboBox1.setItems(destinations2);
    }



    @FXML
    private void searchTicketButtonAirplane() {
        String source1 = originComboBox1.getValue();
        String destination1 = destinationComboBox1.getValue();

        System.out.println(source1);
        System.out.println(destination1);

        List<AirplaneRoute> matchingTrainRoutes = airplaneRouteSearch.searchRoutes(source1, destination1);

        resultListViewAirplane.getItems().clear();
        for (AirplaneRoute airplaneRoute : matchingTrainRoutes) {
            List<Airplane> availableAirplane = airplaneRoute.getAvailableAirplane();
            for (Airplane airplane : availableAirplane) {
                resultListViewAirplane.getItems().add(airplane.getAirplaneName());
            }
        }
    }

}
