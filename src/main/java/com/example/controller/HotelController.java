package com.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class HotelController {
    @FXML
    private ComboBox<String> hotelComboBox;

    public void initialize() {
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

    }

    public void updateHotelList(ObservableList<String> updatedHotels) {
        hotelComboBox.setItems(updatedHotels);
    }



}
