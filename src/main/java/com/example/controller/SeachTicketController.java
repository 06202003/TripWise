package com.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SeachTicketController {
    @FXML
    private Button searchButton;

    @FXML
    private void handleSearchButtonAction() {
        try {
            // Load the new FXML file (searchticket.fxml) and create a new stage
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/searchticket.fxml"));
            AnchorPane searchTicketPane = loader.load();

            // Create a new stage for the search ticket window
            Stage searchTicketStage = new Stage();
            searchTicketStage.setTitle("Search Ticket");

            // Set the content of the new stage to the loaded FXML content
            Scene scene = new Scene(searchTicketPane);
            searchTicketStage.setScene(scene);

            // Show the new stage
            searchTicketStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
