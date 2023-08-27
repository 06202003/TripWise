package com.example.controller;

import com.example.DAO.CityDAO;
import com.example.DAO.HotelDAO;
import com.example.DAO.OrdersDAO;
import com.example.DBUtil.DatabaseUtil;
import com.example.auth.UserSession;
import com.example.data.ConfirmationData;
import com.example.model.Hotel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelController {
    @FXML
    public DatePicker checkInDatePicker;
    @FXML
    public DatePicker checkOutDatePicker;
    @FXML
    private ComboBox<String> hotelComboBox;
    @FXML
    private ListView<VBox> hotelListView;

    @FXML
    public void initialize() {
        ObservableList<String> cityNames = FXCollections.observableArrayList(new CityDAO().getAllCityNames());
        hotelComboBox.setItems(cityNames);
    }

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
    public static String formatRupiah(BigDecimal value) {
        DecimalFormat rupiahFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        rupiahFormat.setDecimalFormatSymbols(formatRp);

        return rupiahFormat.format(value);
    }
    @FXML
    private void searchHotels() {
        String selectedCity = hotelComboBox.getSelectionModel().getSelectedItem();
        if (selectedCity != null) {
            int cityId = new CityDAO().getCityIdByName(selectedCity);
            List<Hotel> hotels = new HotelDAO().getHotelsByCity(cityId);

            hotelListView.getItems().clear();
            for (Hotel hotel : hotels) {
                String hotelInfo =
                        "Nama Hotel: " + hotel.getHotelName() + "\n" +
                        "Tipe Kamar: " + hotel.getTipeRoom() + "\n" +
                        "Return Ticket " + hotel.getReturnTicket() + "\n" +
                        "Kapasitas Maksimal: " + hotel.getMaxCapacity() + "\n" +
                        "Harga per Malam: " + formatRupiah(hotel.getPrice()) + "\n" +
                        "Status: " + hotel.getStatus() + "\n" +
                        "Kamar Yang Tersedia: " + hotel.getRemainingRoom();
                VBox hotelInfoBox = new VBox();
                hotelInfoBox.getChildren().addAll(
                        new Label(hotelInfo),
                        createConfirmationButton(hotel)
                );
                hotelListView.getItems().add(hotelInfoBox);
            }
        }
    }

    private Button createConfirmationButton(Hotel hotel) {
        Button confirmationButton = new Button("Pesan");
        confirmationButton.setOnAction(event -> {
            String confirmationMessage = "Hotel: " + hotel.getHotelName() + "\n" +
                    "Tipe Room: " + hotel.getTipeRoom() + "\n" +
                    "getLocation: " + hotel.getLocation() + "\n" +
                    "getRemainingRoom: " + hotel.getRemainingRoom() + "\n" +
                    "getStatus: " + hotel.getStatus() + "\n" +
                    "getReturnTicket: " + hotel.getReturnTicket() + "\n" +
                    "getCityId: " + hotel.getCityId() + "\n" +
                    "getCity: " + hotel.getCity() + "\n" +
                    "getMaxCapacity: " + hotel.getMaxCapacity() + "\n" +
                    "getId: " + hotel.getId() + "\n" +
                    "Harga per Malam: " + formatRupiah(hotel.getPrice());

            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirmation");
            confirmationAlert.setHeaderText(null);
            confirmationAlert.setContentText(confirmationMessage);

            ButtonType buttonTypeConfirm = new ButtonType("Confirm");
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            confirmationAlert.getButtonTypes().setAll(buttonTypeConfirm, buttonTypeCancel);

            confirmationAlert.showAndWait().ifPresent(response -> {
                if (response == buttonTypeConfirm) {
                    LocalDate checkInDate = checkInDatePicker.getValue();
                    LocalDate checkOutDate = checkOutDatePicker.getValue();
                    int userId = UserSession.getInstance().getLoggedInUser().getId(); // Get the logged-in user ID
                    int hotelId = hotel.getId();
                    int cityId = hotel.getCityId();

                    insertOrder(userId, hotelId, cityId, checkInDate, checkOutDate);
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Success");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("Booking confirmed!");
                    successAlert.showAndWait();
                }
            });
        });

        return confirmationButton;
    }


    private void insertOrder(int userId, int hotelId, int cityId, LocalDate checkInDate, LocalDate checkOutDate) {
        String sql = "INSERT INTO `orders` (user_id, hotel_id, city_id, check_in_date, check_out_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, hotelId);
            stmt.setInt(3, cityId);
            stmt.setObject(4, checkInDate);
            stmt.setObject(5, checkOutDate);

            conn.setAutoCommit(false); // Start transaction
            stmt.executeUpdate();
            conn.commit(); // Commit transaction

            // After inserting, renumber the order IDs
            OrdersDAO ordersDAO = new OrdersDAO();
            ordersDAO.renumberOrderIDs();

        } catch (SQLException e) {
            System.err.println("Failed to insert order into the database.");
            e.printStackTrace();
        }
    }



}
