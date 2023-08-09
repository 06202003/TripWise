package com.example.controller;

import com.example.data.ConfirmationData;
import com.example.data.ConfirmationModel;
import com.example.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class PesanTiketController {
    @FXML
    public ListView<VBox> confirmedHotelsListView;
    @FXML
    private Text nameText;
    @FXML
    private Text nameText1;
    @FXML
    private Text addressText;
    @FXML
    private Text phoneText;
    @FXML
    private ListView<VBox> dataListView;
//    ObservableList<ConfirmationData> confirmedHotels = HotelController.getConfirmedHotels();

    public void receiveConfirmedHotelsList(List<ArrayList<ConfirmationData>> data) {
        // Clear existing items in the ListView
        confirmedHotelsListView.getItems().clear();

        // Iterate through the received data and create VBox items for each hotel
        for (ArrayList<ConfirmationData> hotelDataList : data) {
            VBox hotelInfoBox = new VBox();
            for (ConfirmationData hotelData : hotelDataList) {
                // Create labels/buttons for each ConfirmationData and add to hotelInfoBox
                // ...

                // For example:
                Label nameLabel = new Label("Hotel Name: " + hotelData.getHotelName());
                Button detailsButton = new Button("Details");

                hotelInfoBox.getChildren().addAll(nameLabel, detailsButton);
            }
            confirmedHotelsListView.getItems().add(hotelInfoBox);
            confirmedHotelsListView.refresh();

        }
    }

    public void initialize() {
        List<ArrayList<ConfirmationData>> receivedData = ConfirmationModel.getConfirmedHotelsList();
        receiveConfirmedHotelsList(receivedData);
        confirmedHotelsListView.refresh();

        // Iisialisasi data yang sudah ada
        ObservableList<ConfirmationData> dataList = FXCollections.observableArrayList(
                new ConfirmationData("Item 1", "Cash", "10/5/23", "10/5/23")// Masukkan data lainnya di sini
        );

//        confirmedHotelsListView.setItems(dataList);
//        dataListView.setItems(dataList);

    }
//    public void accessConfirmedHotelsList() {
//        List<ArrayList<ConfirmationData>> confirmedHotelsList = HotelController.getConfirmedHotelsList();
//
//        // Misalnya, kita akan mencetak semua data terkonfirmasi dari setiap hotel
//        for (ArrayList<ConfirmationData> hotelList : confirmedHotelsList) {
//            for (ConfirmationData data : hotelList) {
//                System.out.println(data.toString());
//            }
//        }
//    }

    public void setAddressText(String address) {
        addressText.setText(address);
    }

    public void setPhoneText(String phone) {
        phoneText.setText(phone);
    }

    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public void setNameText(String name) {
        nameText.setText(name);
    }

    public void setNameText1(String name) {
        nameText1.setText(name);
    }

    // Metode lain di controller lain
    public String getUserName() {
        if (user != null) {
            return user.getName();
        } else {
            return "User belum diatur";
        }
    }

    @FXML
    private void openFlightSearch() {
        try {
            FXMLLoader flightloader = new FXMLLoader(getClass().getResource("/com/example/demo/flight.fxml"));

            Parent flightroot = flightloader.load();

            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(flightroot));

//            FlightController dashboardController = flightroot.getController();
            dashboardStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void openTrainSearch() {
        try {
            FXMLLoader trainloader = new FXMLLoader(getClass().getResource("/com/example/demo/train.fxml"));

            Parent trainroot = trainloader.load();

            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(trainroot));

//            FlightController dashboardController = flightroot.getController();
            dashboardStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openHotelSearch() {
        try {
            FXMLLoader hotelloader = new FXMLLoader(getClass().getResource("/com/example/demo/hotel.fxml"));

            Parent hotelroot = hotelloader.load();

            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(hotelroot));

//            FlightController dashboardController = flightroot.getController();
            dashboardStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}