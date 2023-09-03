package com.example.controller;

import com.example.DAO.FlightDAO;
import com.example.DAO.FlightDAOImpl;
import com.example.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FlightController {


    @FXML
    private ComboBox<String> originComboBox1;

    @FXML
    private ComboBox<String> destinationComboBox1;

    @FXML
    private ListView<AirplaneRoute> resultListViewAirplane;

    @FXML
    private Button searchTicketButtonAirplane; // Added this line

    private FlightDAO flightDAO;

    public void initialize() {
        flightDAO = new FlightDAOImpl();

        List<String> origins = flightDAO.getAllOrigins();
        ObservableList<String> originsObservableList = FXCollections.observableArrayList(origins);
        originComboBox1.setItems(originsObservableList);

        List<String> destinations = flightDAO.getAllDestinations();
        ObservableList<String> destinationsObservableList = FXCollections.observableArrayList(destinations);
        destinationComboBox1.setItems(destinationsObservableList);

        resultListViewAirplane.setCellFactory(param -> new AirplaneRouteCell());
    }

    @FXML
    private void searchTicketButtonAirplane() { // Renamed this method
        String source = originComboBox1.getValue();
        String destination = destinationComboBox1.getValue();

        List<AirplaneRoute> matchingAirplaneRoutes = flightDAO.searchRoutes(source, destination);

        resultListViewAirplane.getItems().clear();
        for (AirplaneRoute airplaneRoute : matchingAirplaneRoutes) {
            resultListViewAirplane.getItems().add(airplaneRoute);
        }
    }

    private class AirplaneRouteCell extends ListCell<AirplaneRoute> {
        private HBox contentBox = new HBox();
        private Label airplaneNameLabel = new Label();
        private Button bookTicketButton = new Button("Beli Tiket");

        public AirplaneRouteCell() {
            HBox buttonBox = new HBox(bookTicketButton);
            buttonBox.setAlignment(Pos.CENTER_LEFT);

            VBox textInfoBox = new VBox(airplaneNameLabel, buttonBox);
            textInfoBox.setAlignment(Pos.CENTER_LEFT);
            textInfoBox.setSpacing(5);

            contentBox.getChildren().addAll(textInfoBox);
            contentBox.setAlignment(Pos.CENTER_LEFT);
            HBox.setHgrow(textInfoBox, Priority.ALWAYS);
            setGraphic(contentBox);
        }

        @Override
        protected void updateItem(AirplaneRoute airplaneRoute, boolean empty) {
            super.updateItem(airplaneRoute, empty);
            if (empty || airplaneRoute == null) {
                setGraphic(null);
            } else {
                // Assuming that the first available airplane is chosen to represent the route
                if (!airplaneRoute.getAvailableAirplanes().isEmpty()) {
                    Airplane airplane = airplaneRoute.getAvailableAirplanes().get(0);
                    String airplaneInfo = "Pesawat: " + airplane.getAirplaneName() +
                            "\nHarga Tiket: " + airplane.getTicketPrice() +
                            "\nJam Keberangkatan: " + airplane.getDepartureTime() +
                            "\nKelas: " + airplane.getAirplaneClass();
                    airplaneNameLabel.setText(airplaneInfo);
                } else {
                    airplaneNameLabel.setText("Tidak Ada Pesawat Tersedia");
                }

                bookTicketButton.setOnAction(e -> bookAirplaneTicket(airplaneRoute));
                setGraphic(contentBox);
            }
        }


        private void bookAirplaneTicket(AirplaneRoute airplaneRoute) {
            List<String> paymentMethods = Arrays.asList("Credit Card", "Gopay", "OVO", "Dana");

            ChoiceDialog<String> dialog = new ChoiceDialog<>(paymentMethods.get(0), paymentMethods);
            dialog.setTitle("Pemesanan Tiket");
            dialog.setHeaderText("Pesan Tiket untuk Rute: " + airplaneRoute.getSourceAirport() + " - " + airplaneRoute.getDestinationAirport());
            dialog.setContentText("Pilih metode pembayaran:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(selectedMetode -> {
                showInvoice(airplaneRoute, selectedMetode);
            });
        }

        private void showInvoice(AirplaneRoute airplaneRoute, String selectedMetode) {
            // Assuming that the first available airplane is chosen to represent the route
            if (!airplaneRoute.getAvailableAirplanes().isEmpty()) {
                Airplane airplane = airplaneRoute.getAvailableAirplanes().get(0);

                Alert invoiceAlert = new Alert(Alert.AlertType.INFORMATION);
                invoiceAlert.setTitle("Invoice Pembelian Tiket");
                invoiceAlert.setHeaderText("Pemesanan Tiket Berhasil");
                invoiceAlert.setContentText(
                        "Pesawat: " + airplane.getAirplaneName() + "\n" +
                                "Kelas Pesawat: " + airplane.getAirplaneClass() + "\n" +
                                "Rute: " + airplaneRoute.getSourceAirport() + " - " + airplaneRoute.getDestinationAirport() + "\n" +
                                "Metode Pembayaran: " + selectedMetode
                );
                invoiceAlert.showAndWait();
            } else {
                // No airplanes available
                Alert noAirplanesAlert = new Alert(Alert.AlertType.WARNING);
                noAirplanesAlert.setTitle("Tidak Ada Pesawat Tersedia");
                noAirplanesAlert.setHeaderText("Maaf, tidak ada pesawat yang tersedia untuk rute ini.");
                noAirplanesAlert.showAndWait();
            }
        }

    }

}
