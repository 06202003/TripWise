package com.example.controller;

import com.example.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PesanTiketController {


    @FXML
    private Text nameText;

    @FXML
    private Text nameText1;

    @FXML
    private Text addressText;

    @FXML
    private Text phoneText;

//    @FXML
//    private Text tanggalLahirText;

    public void setAddressText(String address) {
        addressText.setText(address);
    }

    public void setPhoneText(String phone) {
        phoneText.setText(phone);
    }

//    public void setTanggalLahirText(Date tanggalLahir) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        String formattedDate = dateFormat.format(tanggalLahir);
//        tanggalLahirText.setText(formattedDate);
//    }

    private User user; // Tambahkan atribut User untuk menyimpan objek user yang diterima dari LoginController

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