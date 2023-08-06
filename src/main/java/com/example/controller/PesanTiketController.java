package com.example.controller;

import com.example.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

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

    }

    public void updateHotelList(ObservableList<String> updatedHotels) {
        hotelComboBox.setItems(updatedHotels);
    }
}