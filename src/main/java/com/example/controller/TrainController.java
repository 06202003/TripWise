package com.example.controller;

import com.example.model.TrainRoute;
import com.example.model.TrainRouteSearch;
import com.example.model.Train;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.time.LocalTime;
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

        Train train1 = new Train("Kereta Ekspress A", LocalTime.of(8, 30), LocalTime.of(14, 15), "512000");
        Train train2 = new Train("Kereta Cepat B", LocalTime.of(11, 45), LocalTime.of(22, 30), "375000");
        Train train3 = new Train("Kereta Harina", LocalTime.of(9, 50), LocalTime.of(20, 30), "212000");
        Train train4 = new Train("Kereta Malabar", LocalTime.of(9, 50), LocalTime.of(20, 30), "212000");
        Train train5 = new Train("Kereta Kahuripan", LocalTime.of(9, 50), LocalTime.of(20, 30), "212000");
        Train train6 = new Train("Kereta Mutiara Selatan", LocalTime.of(9, 50), LocalTime.of(20, 30), "212000");
        Train train7 = new Train("Kereta Argo Wilis", LocalTime.of(9, 50), LocalTime.of(20, 30), "212000");


        TrainRoute trainRoute1 = new TrainRoute("Surabaya", "Bandung");
        trainRoute1.addTrain(train1);
        trainRoute1.addTrain(train2);

        TrainRoute trainRoute2 = new TrainRoute("Bandung", "Surabaya");
        trainRoute2.addTrain(train1);
        trainRoute2.addTrain(train2);
        trainRoute2.addTrain(train3);

        TrainRoute trainRoute3 = new TrainRoute("Bandung", "Yogyakarta");
        trainRoute3.addTrain(train1);
        trainRoute3.addTrain(train3);
        trainRoute3.addTrain(train2);
        trainRoute3.addTrain(train4);

        TrainRoute trainRoute4 = new TrainRoute("Yogyakarta", "Bandung");
        trainRoute4.addTrain(train1);
        trainRoute4.addTrain(train3);
        trainRoute4.addTrain(train2);
        trainRoute4.addTrain(train4);

        TrainRoute trainRoute5 = new TrainRoute("Yogyakarta", "Surabaya");
        trainRoute5.addTrain(train5);
        trainRoute5.addTrain(train6);
        trainRoute5.addTrain(train7);

        TrainRoute trainRoute6 = new TrainRoute("Surabaya", "Yogyakarta");
        trainRoute6.addTrain(train5);
        trainRoute6.addTrain(train6);
        trainRoute6.addTrain(train7);

        trainRouteSearch.addRoute(trainRoute1);
        trainRouteSearch.addRoute(trainRoute2);
        trainRouteSearch.addRoute(trainRoute3);
        trainRouteSearch.addRoute(trainRoute4);
        trainRouteSearch.addRoute(trainRoute5);
        trainRouteSearch.addRoute(trainRoute6);

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
                String trainInfo = train.getTrainName() + " | " +
                        train.getOriginTime() + " - " +
                        train.getDepartureTime() + " | " +
                        train.getTicketPrice();
                resultListView.getItems().add(trainInfo);
            }
        }
    }

}
