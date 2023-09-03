package com.example.controller;

import com.example.model.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class EventController {
    @FXML
    private ListView<Event> eventListView;

    private ObservableList<Event> eventList = FXCollections.observableArrayList();

    public void initialize() {
        // Populate eventList with sample events
        eventList.add(new Event("Konser Blueband","Bandung", "2023-08-15", "Live music performance", 50.0, new Image("D:\\newTripWise\\TripWise\\src\\main\\resources\\com\\example\\demo\\img\\event.png")));
        eventList.add(new Event("Maranatha Land","Bandung", "2023-09-10", "Tech conference", 100.0, new Image("D:\\newTripWise\\TripWise\\src\\main\\resources\\com\\example\\demo\\img\\event.jpg")));
        eventListView.setItems(eventList);
        eventListView.setCellFactory(new EventCellFactory());
    }

    private class EventCellFactory implements Callback<ListView<Event>, ListCell<Event>> {
        @Override
        public ListCell<Event> call(ListView<Event> listView) {
            return new EventCell();
        }
    }

    private class EventCell extends ListCell<Event> {
        private HBox contentBox = new HBox();
        private ImageView imageView = new ImageView();
        private VBox textInfoBox = new VBox();
        private Label eventNameLabel = new Label();
        private Button buyTicketButton = new Button("Beli Tiket");

        public EventCell() {
            eventNameLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

            HBox buttonBox = new HBox(buyTicketButton);
            buttonBox.setAlignment(Pos.CENTER_LEFT);

            textInfoBox.getChildren().addAll(eventNameLabel, buttonBox);
            textInfoBox.setAlignment(Pos.CENTER_LEFT);
            textInfoBox.setSpacing(5);

            contentBox.getChildren().addAll(imageView, textInfoBox);
            contentBox.setAlignment(Pos.CENTER_LEFT);
            contentBox.setSpacing(10);
            HBox.setHgrow(imageView, Priority.ALWAYS);
            setGraphic(contentBox);
        }

        @Override
        protected void updateItem(Event event, boolean empty) {
            super.updateItem(event, empty);
            if (empty || event == null) {
                setGraphic(null);
            } else {
                imageView.setImage(event.getImage());
                imageView.setFitWidth(200);
                imageView.setPreserveRatio(true);

                eventNameLabel.setText(event.getName()); // Set nama event
                eventNameLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

                buyTicketButton.setOnAction(e -> buyEventTicket(event));
                buyTicketButton.setStyle("-fx-font-size: 14px;");
                setGraphic(contentBox);
            }
        }

        private void buyEventTicket(Event event) {
            Stage pesanStage = new Stage();
            pesanStage.setTitle("Pesan Tiket: " + event.getName());

            Label eventInfoLabel = new Label(event.getName());
            Label eventDescriptionLabel = new Label(event.getDescription());
            Label eventPriceLabel = new Label("Harga: " + event.getPrice());

            ComboBox<String> metodePembayaranComboBox = new ComboBox<>();
            metodePembayaranComboBox.getItems().addAll("Kartu Kredit", "Transfer Bank", "OVO", "GoPay", "Cash");
            metodePembayaranComboBox.getSelectionModel().selectFirst();

            Button konfirmasiButton = new Button("Konfirmasi");
            konfirmasiButton.setOnAction(confirmEvent -> showInvoice(event, metodePembayaranComboBox.getValue()));

            VBox pesanLayout = new VBox(10);
            pesanLayout.getChildren().addAll(eventInfoLabel, eventDescriptionLabel, eventPriceLabel, metodePembayaranComboBox, konfirmasiButton);
            pesanLayout.setAlignment(Pos.CENTER);

            Scene pesanScene = new Scene(pesanLayout, 300, 250);
            pesanStage.setScene(pesanScene);
            pesanStage.show();
        }

        private void showInvoice(Event event, String selectedMetode) {
            Alert invoiceAlert = new Alert(Alert.AlertType.INFORMATION);
            invoiceAlert.setTitle("Invoice Pembelian Tiket");
            invoiceAlert.setHeaderText("Pembelian Tiket Berhasil");
            invoiceAlert.setContentText(
                    "Event: " + event.getName() + "\n" +
                            "Harga Tiket: " + event.getPrice() + "\n" +
                            "Tanggal Acara: " + event.getDate() + "\n" +
                            "Lokasi: " + event.getLocation() + "\n" +
                            "Metode Pembayaran: " + selectedMetode
            );
            invoiceAlert.showAndWait();
        }


    }
}
