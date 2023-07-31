package com.example.controller;

import com.example.model.Train;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class PesanTiketController {
    @FXML
    private Label welcomeText;

    @FXML
    private ComboBox<String> originComboBox1;

    @FXML
    private ComboBox<String> destinationComboBox1;

    @FXML
    private ComboBox<String> originComboBox2;

    @FXML
    private ComboBox<String> destinationComboBox2;

    @FXML
    private ComboBox<String> hotelComboBox;

    public void initialize() {
        ObservableList<String> origins = FXCollections.observableArrayList(
                "Jakarta",
                "Bandung",
                "Bali"
        );
        originComboBox1.setItems(origins);

        ObservableList<String> destinations = FXCollections.observableArrayList(
                "Jakarta",
                "Bandung",
                "Bali"
        );
        destinationComboBox1.setItems(destinations);

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

        ObservableList<String> hotels = FXCollections.observableArrayList(
                "The Trans Luxury Hotel",
                "Sheraton Bandung Hotel & Towers",
                "Grand Mercure Bandung Setiabudi",
                "Padma Hotel Bandung",
                "Aston Pasteur Hotel"
        );
        hotelComboBox.setItems(hotels);

        hotelComboBox.setOnAction(event -> {
            String selectedHotel = hotelComboBox.getSelectionModel().getSelectedItem();
            if (selectedHotel != null) {
                System.out.println("Anda memilih hotel: " + selectedHotel);
            }
        });

        originComboBox1.setOnAction(event -> {
            String selectedHotel = originComboBox1.getSelectionModel().getSelectedItem();
            if (selectedHotel != null) {
                System.out.println("Anda memilih keberangkatan pesawat dari: " + selectedHotel);
            }
        });

        destinationComboBox1.setOnAction(event -> {
            String selectedHotel = destinationComboBox1.getSelectionModel().getSelectedItem();
            if (selectedHotel != null) {
                System.out.println("Anda memilih keberangkatan pesawat ke: " + selectedHotel);
            }
        });

        originComboBox2.setOnAction(event -> {
            String selectedHotel = originComboBox2.getSelectionModel().getSelectedItem();
            if (selectedHotel != null) {
                System.out.println("Anda memilih keberangkatan kereta dari: " + selectedHotel);
            }
        });

        destinationComboBox2.setOnAction(event -> {
            String selectedHotel = destinationComboBox2.getSelectionModel().getSelectedItem();
            if (selectedHotel != null) {
                System.out.println("Anda memilih keberangkatan kereta ke: " + selectedHotel);
            }
        });

    }

    public void updateHotelList(ObservableList<String> updatedHotels) {
        hotelComboBox.setItems(updatedHotels);
    }

    private List<Train> trains;

    public PesanTiketController() {
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