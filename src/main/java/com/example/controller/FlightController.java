package com.example.controller;

import com.example.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.time.LocalTime;
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

        Airplane airplane1 = new Airplane("Garuda Indonesia", LocalTime.of(6, 30), LocalTime.of(7, 55),"1200000","Economy");
        Airplane airplane2 = new Airplane("Citilink", LocalTime.of(12, 30), LocalTime.of(13, 55),"1500000","Businnes");
        Airplane airplane3 = new Airplane("Air Asia", LocalTime.of(18, 10), LocalTime.of(19, 25),"1300000","First Class");
        Airplane airplane4 = new Airplane("Lion Air", LocalTime.of(20, 10), LocalTime.of(21, 35),"1200000","Economy");
        Airplane airplane5 = new Airplane("Etihad Airways", LocalTime.of(10, 10), LocalTime.of(12, 35),"1000000","Economy");
        Airplane airplane6 = new Airplane("Ana Air", LocalTime.of(00, 10), LocalTime.of(2, 00),"900000","Economy");

        AirplaneRoute airplaneRoute1 = new AirplaneRoute("Jakarta", "Bali");
        airplaneRoute1.addAirplane(airplane1);
        airplaneRoute1.addAirplane(airplane2);

        AirplaneRoute airplaneRoute2 = new AirplaneRoute("Bali", "Jakarta");
        airplaneRoute2.addAirplane(airplane1);
        airplaneRoute2.addAirplane(airplane2);

        AirplaneRoute airplaneRoute3 = new AirplaneRoute("Jakarta", "Bandung");
        airplaneRoute3.addAirplane(airplane2);
        airplaneRoute3.addAirplane(airplane3);
        airplaneRoute3.addAirplane(airplane4);

        AirplaneRoute airplaneRoute4 = new AirplaneRoute("Bandung", "Jakarta");
        airplaneRoute4.addAirplane(airplane2);
        airplaneRoute4.addAirplane(airplane3);
        airplaneRoute4.addAirplane(airplane4);

        AirplaneRoute airplaneRoute5 = new AirplaneRoute("Bandung", "Bali");
        airplaneRoute5.addAirplane(airplane5);
        airplaneRoute5.addAirplane(airplane6);

        AirplaneRoute airplaneRoute6 = new AirplaneRoute("Bali", "Bandung");
        airplaneRoute6.addAirplane(airplane5);
        airplaneRoute6.addAirplane(airplane6);

        airplaneRouteSearch.addRouteA(airplaneRoute1); // Change this to addRouteA
        airplaneRouteSearch.addRouteA(airplaneRoute2); // Change this to addRouteA
        airplaneRouteSearch.addRouteA(airplaneRoute3); // Change this to addRouteA
        airplaneRouteSearch.addRouteA(airplaneRoute4); // Change this to addRouteA
        airplaneRouteSearch.addRouteA(airplaneRoute5); // Change this to addRouteA
        airplaneRouteSearch.addRouteA(airplaneRoute6); // Change this to addRouteA


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
                String airplaneInfo = airplane.getAirplaneName() + " | " +
                        airplane.getOriginTime() + " - " +
                        airplane.getDepartureTime() + " | " +
                        airplane.getTicketPrice();
                resultListViewAirplane.getItems().add(airplaneInfo);
            }
        }
    }

}
