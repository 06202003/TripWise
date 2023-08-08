package com.example.controller;

import com.example.model.TrainRoute;
import com.example.model.TrainRouteSearch;
import com.example.model.Train;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.util.List;

public class TrainController {

    @FXML
    private ComboBox<String> originComboBox2;

    @FXML
    private ComboBox<String> destinationComboBox2;

    @FXML
    private ListView<String> resultListView;

    private TrainRouteSearch trainRouteSearch;

    public void initialize() {
        trainRouteSearch = new TrainRouteSearch();

        Train train1 = new Train("Kereta Ekspress A");
        Train train2 = new Train("Kereta Cepat B");
        Train train3 = new Train("Kereta Lokal C");

        TrainRoute trainRoute1 = new TrainRoute("Surabaya", "Bandung");
        trainRoute1.addTrain(train1);
        trainRoute1.addTrain(train2);

        TrainRoute trainRoute2 = new TrainRoute("Bandung", "Surabaya");
        trainRoute2.addTrain(train2);
        trainRoute2.addTrain(train3);

        trainRouteSearch.addRoute(trainRoute1);
        trainRouteSearch.addRoute(trainRoute2);

        ObservableList<String> origins2 = FXCollections.observableArrayList(
                "Yogyakarta",
                "Bandung",
                "Surabaya"
        );
        originComboBox2.setItems(origins2);

        ObservableList<String> destinations2 = FXCollections.observableArrayList(
                "Yogyakarta",
                "Bandung",
                "Surabaya"
        );
        destinationComboBox2.setItems(destinations2);
    }

    @FXML
    private void searchTicketButton() {
        String source = originComboBox2.getValue();
        String destination = destinationComboBox2.getValue();

        System.out.println(source);
        System.out.println(destination);

        List<TrainRoute> matchingTrainRoutes = trainRouteSearch.searchRoutes(source, destination);

        resultListView.getItems().clear();
        for (TrainRoute trainRoute : matchingTrainRoutes) {
            List<Train> availableTrains = trainRoute.getAvailableTrains();
            for (Train train : availableTrains) {
                resultListView.getItems().add(train.getTrainName());
            }
        }
    }

}
