package com.example.controller;

import com.example.data.ConfirmationData;
import com.example.data.ConfirmationModel;
import com.example.data.HotelData;
import com.example.model.Hotel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HotelController {
    @FXML
    private ComboBox<String> hotelComboBox;
    @FXML
    private ListView<VBox> hotelListView;
    @FXML
    private DatePicker checkInDatePicker;
    @FXML
    private DatePicker checkOutDatePicker;
    @FXML
    private Button searchButton;
    private HotelData hotelData;
    private List<ConfirmationData> confirmationDataList = new ArrayList<>();
    private static ObservableList<ConfirmationData> confirmedHotels = FXCollections.observableArrayList();
    private static List<ArrayList<ConfirmationData>> confirmedHotelsList = new ArrayList<>();

    @FXML
    public void initialize() {
        hotelData = new HotelData();

        hotelComboBox.setOnAction(event -> {
            String selectedHotel = hotelComboBox.getSelectionModel().getSelectedItem();
            if (selectedHotel != null) {
                System.out.println("Anda memilih Kota: " + selectedHotel);
            }
        });

        hotelComboBox.getItems().addAll("Kota A", "Kota B", "Kota C");

    }
    // Metode untuk mengatur objek HotelData
    public void setHotelData(HotelData hotelData) {
        this.hotelData = hotelData;
    }

    // Fungsi tambahan untuk mengkapitalisasi huruf pertama dari setiap kata
    private String capitalizeFirstLetter(String input) {
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0)));
                result.append(word.substring(1).toLowerCase()).append(" ");
            }
        }

        return result.toString().trim();
    }
    @FXML
    private void searchHotels() {
        String selectedCity = hotelComboBox.getSelectionModel().getSelectedItem();
        List<Hotel> hotels = hotelData.getHotelsByCity(selectedCity);
        // Bersihkan ListView dan tambahkan daftar hotel
        hotelListView.getItems().clear();
        for (Hotel hotel : hotels) {
            String hotelInfo = "Nama Hotel = " + hotel.getNameHotel() + "\n" +
                    "Lokasi = " + hotel.getLocation() + "\n" +
                    "Tipe Kamar = " + capitalizeFirstLetter(hotel.getTipeRoom()) + "\n" +
                    "Max Capacity = " + capitalizeFirstLetter(hotel.getMaxCapacity()) + "\n" +
                    "Harga per Malam = " + capitalizeFirstLetter(hotel.getPrice()) + "\n" +
                    "Return Ticket = " + hotel.getReturnTicket().toLowerCase();

            Button pesanButton = new Button("Pesan"); // Membuat tombol "Pesan"
            pesanButton.setOnAction(event -> {
                // Membuat jendela baru
                Stage pesanStage = new Stage();
                pesanStage.setTitle("Pesan Hotel: " + hotel.getNameHotel());

                // Membuat komponen-komponen untuk jendela pesanan
                Label hotelInfoLabel = new Label(hotelInfo);
                // Mengambil tanggal check-in dan check-out dari objek Hotel
                String checkIn = hotel.getCheckIn();
                String checkOut = hotel.getCheckOut();
                Label checkInLabel = new Label("Tanggal Check-in: " + checkIn);
                Label checkOutLabel = new Label("Tanggal Check-out: " + checkOut);

                String checkInDatePicker = hotel.getCheckIn();
                String checkOutDatePicker = hotel.getCheckOut();

                ComboBox<String> metodePembayaranComboBox = new ComboBox<>();
                metodePembayaranComboBox.getItems().addAll("Kartu Kredit", "Transfer Bank", "OVO", "GoPay", "Cash");

                Button konfirmasiButton = new Button("Konfirmasi");

                konfirmasiButton.setOnAction(confirmEvent -> {
                    // Kode untuk menangani konfirmasi pesanan dan metode pembayaran
                    System.out.println(" ");
                    String selectedMetode = metodePembayaranComboBox.getValue();
                    System.out.println("Pesanan untuk hotel " + hotel.getNameHotel() + " dikonfirmasi.");
                    System.out.println("Metode Pembayaran: " + selectedMetode);
                    System.out.println("Tanggal Check-in: " + checkInDatePicker);
                    System.out.println("Tanggal Check-out: " + checkOutDatePicker);
                    System.out.println(" ");
                    ConfirmationData data = new ConfirmationData(hotel.getNameHotel(), selectedMetode, checkInDatePicker, checkOutDatePicker);

                    int hotelIndex = hotels.indexOf(hotel);
                    if (hotelIndex < confirmedHotelsList.size()) {
                        confirmedHotelsList.get(hotelIndex).add(data);
                    } else {
                        ArrayList<ConfirmationData> newHotelList = new ArrayList<>();
                        newHotelList.add(data);
                        confirmedHotelsList.add(newHotelList);
                    }
                    System.out.println(confirmedHotelsList);

// Menggunakan model untuk menambah data ke confirmedHotelsList pada model
                    ConfirmationModel.addConfirmedHotel(confirmedHotelsList.get(hotelIndex));

                    confirmationDataList.add(data);
                    confirmedHotels.add(data);

// Print the confirmed hotel data to console
//                    printConfirmedHotels();

                    // Cetak ConfirmationData ke konsol
//                    System.out.println(data.toString());
                    pesanStage.close(); // Menutup jendela setelah konfirmasi
                });

                // Mengatur tata letak komponen-komponen dalam jendela
                VBox pesanLayout = new VBox(10);
                pesanLayout.getChildren().addAll(hotelInfoLabel, checkInLabel, checkOutLabel, metodePembayaranComboBox, konfirmasiButton);
                pesanLayout.setAlignment(Pos.CENTER);
                Scene pesanScene = new Scene(pesanLayout, 300, 300);

                pesanStage.setScene(pesanScene);
                pesanStage.show();
            });

            VBox hotelInfoBox = new VBox(); // Membuat container vertikal untuk informasi hotel
            hotelInfoBox.getChildren().addAll(
                    new Label(hotelInfo),
                    pesanButton
            );
            hotelListView.getItems().add(hotelInfoBox);
        }
    }
    public static List<ArrayList<ConfirmationData>> getConfirmedHotelsList() {
        return confirmedHotelsList;
    }

    public void printConfirmedHotelsList() {
        System.out.println("Confirmed Hotel Data List:");
        for (ArrayList<ConfirmationData> hotelList : confirmedHotelsList) {
            System.out.println(hotelList.toString());
        }
    }

    public void updateHotelList(ObservableList<String> updatedHotels) {
        hotelComboBox.setItems(updatedHotels);
    }

}
