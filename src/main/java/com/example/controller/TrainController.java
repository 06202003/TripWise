package com.example.controller;

import com.example.model.Route;
import com.example.model.Station;
import com.example.model.Train;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TrainController {

    @FXML
    private void searchTicketButton() {
        System.out.println("----------------------------");
    }

    @FXML
    private ComboBox<String> originComboBox2;

    @FXML
    private ComboBox<String> destinationComboBox2;
    public void initialize() {
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


}
