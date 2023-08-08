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
                "Bandung",
                "Jakarta",
                "Bali"
        );
        hotelComboBox.setItems(hotels);

        hotelComboBox.setOnAction(event -> {
            String selectedHotel = hotelComboBox.getSelectionModel().getSelectedItem();
            if (selectedHotel != null) {
                System.out.println("Anda memilih Kota: " + selectedHotel);
            }
        });

    }

    public void updateHotelList(ObservableList<String> updatedHotels) {
        hotelComboBox.setItems(updatedHotels);
    }



}
