package com.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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

    @FXML
    private CheckBox returnCheckbox;
    @FXML
    private HBox returnDateHBox;

    @FXML
    private Button searchTicketButton;

//    @FXML
    public void initialize() {
        returnCheckbox.setOnAction(e -> {
            returnDateHBox.setVisible(returnCheckbox.isSelected());
        });
        searchTicketButton.setOnAction(event -> openSearchTicketWindow());

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

    }

    public void updateHotelList(ObservableList<String> updatedHotels) {
        hotelComboBox.setItems(updatedHotels);
    }
    private void openSearchTicketWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/searchticket.fxml"));
            Parent root = loader.load();

            // Create a new stage for the search ticket window
            Stage searchTicketStage = new Stage();
            searchTicketStage.setTitle("Search Ticket Window");
            searchTicketStage.setScene(new Scene(root));

            // Show the search ticket window
            searchTicketStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}