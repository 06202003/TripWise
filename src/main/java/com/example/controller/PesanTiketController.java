package com.example.controller;

import com.example.DAO.UserDAO;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
    private Text birthText;
    @FXML
    private ImageView imageText;
    private User loggedInUser;
    public void initialize() {
//        if (loggedInUser != null) {
//            nameText1.setText("Welwercome, " + loggedInUser.getAddress());
//            addressText.setText(loggedInUser.getAddress());
//            phoneText.setText(loggedInUser.getPhoneNumber());
//            // ... (set other user properties if needed)
//        }

        List<ArrayList<ConfirmationData>> receivedData = ConfirmationModel.getConfirmedHotelsList();
        receiveConfirmedHotelsList(receivedData);
        confirmedHotelsListView.refresh();


        UserDAO userDAO = new UserDAO();
        userDAO.displayAllUsersToConsole();
    }

    // Method to set the logged-in user
//    public void setLoggedInUser(User user) {
//        this.loggedInUser = user;
//
//        // You can use the user's data here to populate UI elements if needed
//        nameText.setText(user.getName());
//        // ... other UI elements ...
//    }

    public void setLoggedInUser(String username) {
        if (nameText1 != null) {
            nameText1.setText(username);
        } else {
            System.out.println("nameText1 is null"); // Debugging purposes
        }
    }


    public void receiveConfirmedHotelsList(List<ArrayList<ConfirmationData>> data) {
        // Clear existing items in the ListView
        confirmedHotelsListView.getItems().clear();

        // Iterate through the received data and create VBox items for each hotel
        for (ArrayList<ConfirmationData> hotelDataList : data) {
            VBox hotelInfoBox = new VBox();
            for (ConfirmationData hotelData : hotelDataList) {
                Label nameLabel = new Label("Hotel Name: " + hotelData.getHotelName());
                Button detailsButton = new Button("Details");

                hotelInfoBox.getChildren().addAll(nameLabel, detailsButton);
            }
            confirmedHotelsListView.getItems().add(hotelInfoBox);
            confirmedHotelsListView.refresh();

        }
    }



    // Metode ini akan dipanggil setelah pengguna berhasil login
//    public static void setUserAndDisplayData(String userName) {
//        nameText1.setText("Nama: " + userName);
//    }

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


    public void setBirthText(LocalDate tanggalLahir) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Choose your desired date format
        String formattedDate = tanggalLahir.format(dateFormatter);
        birthText.setText(formattedDate);
    }


    public void setImageView(String imagePath) {
        File file = new File(imagePath);
        if (file.exists()) {
            Image image = new Image(file.toURI().toString());
            imageText.setImage(image);
        } else {
            System.out.println("Image file not found: " + imagePath);
        }
    }

//    private void updateImageView() {
//        String profilePicturePath = user.getProfilePicture();
//        if (profilePicturePath != null) {
//            Image image = new Image(profilePicturePath);
//            imageText.setImage(image);
//        }
//    }


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

    @FXML
    private void eventSearch() {
        try {
            FXMLLoader eventloader = new FXMLLoader(getClass().getResource("/com/example/demo/event.fxml"));

            Parent eventroot = eventloader.load();

            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(eventroot));

//            FlightController dashboardController = flightroot.getController();
            dashboardStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    @FXML
//    private void gantiProfileAAA() {
//        try {
//            FXMLLoader profileloader = new FXMLLoader(getClass().getResource("/com/example/demo/profile.fxml"));
//
//            Parent profileroot = profileloader.load();
//            ProfileController profileController = profileloader.getController(); // Dapatkan instance dari ProfileController
//            profileController.setUser(user); // Set data pengguna
//            Stage dashboardStage = new Stage();
//            dashboardStage.setScene(new Scene(profileroot));
//
//            dashboardStage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}