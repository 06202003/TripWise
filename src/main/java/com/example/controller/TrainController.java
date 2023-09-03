package com.example.controller;

import com.example.DAO.TrainDAO;
import com.example.DAO.TrainDAOImpl;
import com.example.model.Train;
import com.example.model.TrainRoute;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TrainController {

    @FXML
    private ComboBox<String> originComboBox2;

    @FXML
    private ComboBox<String> destinationComboBox2;

    @FXML
    private ListView<TrainRoute> resultListView;

    private TrainDAO trainDAO;

    public void initialize() {
        trainDAO = new TrainDAOImpl();

        ObservableList<String> origins = FXCollections.observableArrayList(
                trainDAO.getAllOrigins()
        );
        originComboBox2.setItems(origins);

        ObservableList<String> destinations = FXCollections.observableArrayList(
                trainDAO.getAllDestinations()
        );
        destinationComboBox2.setItems(destinations);

        resultListView.setCellFactory(this::trainCellFactory);
    }

    @FXML
    private void searchTicketButton() {
        String source = originComboBox2.getValue();
        String destination = destinationComboBox2.getValue();

        List<TrainRoute> matchingTrainRoutes = trainDAO.searchRoutes(source, destination);

        resultListView.getItems().clear();
        resultListView.getItems().addAll(matchingTrainRoutes);
    }

    private ListCell<TrainRoute> trainCellFactory(ListView<TrainRoute> listView) {
        return new ListCell<TrainRoute>() {
            @Override
            protected void updateItem(TrainRoute trainRoute, boolean empty) {
                super.updateItem(trainRoute, empty);

                if (empty || trainRoute == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    Train train = trainRoute.getAvailableTrains().get(0);

                    String trainInfo = "Kereta: " + train.getTrainName() +
                            "\nJam Keberangkatan: " + train.getDepartureTime() +
                            "\nHarga Tiket: " + train.getTicketPrice() +
                            "\nKelas: " + train.getTrainClass();
                    Label trainInfoLabel = new Label(trainInfo);

                    Button buyButton = new Button("Beli Tiket");
                    buyButton.setOnAction(event -> {
                        String selectedMethod = showPaymentMethodDialog(trainRoute);
                        if (selectedMethod != null) {
                            bookTrainTicket(trainRoute, selectedMethod);
                        }
                    });

                    VBox contentBox = new VBox(trainInfoLabel, buyButton);
                    contentBox.setSpacing(10);

                    setGraphic(contentBox);
                }
            }
        };
    }

    private String showPaymentMethodDialog(TrainRoute trainRoute) {
        List<String> paymentMethods = Arrays.asList("Credit Card", "Gopay", "OVO", "Dana");

        ChoiceDialog<String> dialog = new ChoiceDialog<>(paymentMethods.get(0), paymentMethods);
        dialog.setTitle("Pemesanan Tiket Kereta");
        dialog.setHeaderText("Pesan Tiket untuk Rute: " + trainRoute.getSourceStation() + " - " + trainRoute.getDestinationStation());
        dialog.setContentText("Pilih metode pembayaran:");

        Optional<String> result = dialog.showAndWait();
        return result.orElse(null);
    }

    private void bookTrainTicket(TrainRoute trainRoute, String selectedMetode) {
        showInvoice(trainRoute, selectedMetode);
    }

    private void showInvoice(TrainRoute trainRoute, String selectedMetode) {
        List<Train> availableTrains = trainRoute.getAvailableTrains();
        if (!availableTrains.isEmpty()) {
            Train train = availableTrains.get(0);
            Alert invoiceAlert = new Alert(Alert.AlertType.INFORMATION);
            invoiceAlert.setTitle("Invoice Pembelian Tiket");
            invoiceAlert.setHeaderText("Pemesanan Tiket Berhasil");
            invoiceAlert.setContentText(
                    "Rute: " + trainRoute.getSourceStation() + " - " + trainRoute.getDestinationStation() + "\n" +
                            "Kereta: " + train.getTrainName() + "\n" +
                            "Jam Keberangkatan: " + train.getDepartureTime() + "\n" +
                            "Harga Tiket: " + train.getTicketPrice() + "\n" +
                            "Metode Pembayaran: " + selectedMetode
            );
            invoiceAlert.showAndWait();
        }
    }
}
