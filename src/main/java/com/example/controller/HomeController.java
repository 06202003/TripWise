package com.example.controller;

import com.example.DAO.OrdersDAO;
import com.example.DAO.UserDAO;
import com.example.auth.UserSession;
import com.example.data.ConfirmationData;
import com.example.data.ConfirmationModel;
import com.example.model.Orders;
import com.example.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HomeController {
    @FXML
    public ListView<VBox> confirmedHotelsListView;
    @FXML
    public Button buttonUpdate;
    @FXML
    public TextField IdText;
    @FXML
    private TextField FullNameText;
    @FXML
    private Text userUsername;
    @FXML
    private TextField addressText;
    @FXML
    private TextField phoneText;
    @FXML
    private DatePicker birthDateText;
    @FXML
    private TextField userUsername1Text;
    @FXML
    private PasswordField passwordText;
    @FXML
    private TextField nikText;
    @FXML
    private TextField emailText;
    @FXML
    private Text profilePicText;
    @FXML
    private ImageView imageView;
    @FXML
    private Button choosePhoto;
    private File selectedPhotoFile = null;
    private User updatedUser;
    private UserDAO userDAO = new UserDAO();
    public void initialize() {
        List<ArrayList<ConfirmationData>> receivedData = ConfirmationModel.getConfirmedHotelsList();
        receiveConfirmedHotelsList(receivedData);
        confirmedHotelsListView.refresh();

        User loggedInUser = UserSession.getInstance().getLoggedInUser();
        extractUserData(loggedInUser);

        buttonUpdate.setOnAction(this::handleUpdateProfile);
        updateProfilePicture(loggedInUser.getUsername());

        displayConfirmedHotels();

        choosePhoto.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
            );
            File selectedFile = fileChooser.showOpenDialog(new Stage());

            if (selectedFile != null) {
                saveAndDisplaySelectedPhoto(selectedFile);
                System.out.println("Selected File Path: " + selectedFile.getAbsolutePath());
            } else {
                System.out.println("No file selected.");
            }
        });

    }

    private void displayConfirmedHotels() {
        int userId = UserSession.getInstance().getLoggedInUser().getId();
        List<Orders> confirmedOrders = new OrdersDAO().getOrdersByUserId(userId);

        confirmedHotelsListView.getItems().clear();

        for (Orders orders : confirmedOrders) {
            String hotelInfo =
                    "Hotel ID: " + orders.getHotel_id() + "\n" +
                            "Check-in Date: " + orders.getCheck_in_date() + "\n" +
                            "Check-out Date: " + orders.getCheck_out_date();

            VBox hotelInfoBox = new VBox();
            hotelInfoBox.getChildren().addAll(new Label(hotelInfo));
            confirmedHotelsListView.getItems().add(hotelInfoBox);
        }
    }

    private void extractUserData(User loggedInUser) {
        IdText.setText(String.valueOf(loggedInUser.getId()));
        FullNameText.setText(loggedInUser.getName());
        userUsername.setText(loggedInUser.getUsername());
        birthDateText.setValue(loggedInUser.getBirthDate().toLocalDate());
        addressText.setText(loggedInUser.getAddress());
        phoneText.setText(loggedInUser.getPhoneNumber());
        userUsername1Text.setText(loggedInUser.getUsername());
        passwordText.setText(loggedInUser.getPassword());
        nikText.setText(loggedInUser.getNik());
        emailText.setText(loggedInUser.getEmail());
        profilePicText.setText(loggedInUser.getProfilePicture());
    }

    private void updateProfilePicture(String username) {
        Image image = loadImageFromResource(username + ".jpg");
        if (image != null) {
            imageView.setImage(image);
        } else {
            System.out.println("Image Not Found");
        }
    }

    private Image loadImageFromResource(String imageName) {
        InputStream imageStream = getClass().getResourceAsStream("/com/example/demo/photos/" + imageName);
        if (imageStream != null) {
            return new Image(imageStream);
        }
        return null;
    }

    @FXML
    private void saveAndDisplaySelectedPhoto(File selectedFile) {
        selectedPhotoFile = selectedFile;
        Image image = new Image(selectedFile.toURI().toString());
        imageView.setImage(image);
    }

    @FXML
    private void handleUpdateProfile(ActionEvent event) {
        extractUpdatedUserData();
        if (userDAO.updateUser(updatedUser)) {
            savePhotoToDirectory();
            System.out.println("Profile updated successfully.");
            refreshWindow();
        } else {
            System.out.println("Failed to update profile.");
        }
    }

    private void extractUpdatedUserData() {
        int id = Integer.parseInt(IdText.getText());
        String fullName = FullNameText.getText();
        LocalDate birthDate = birthDateText.getValue();
        String address = addressText.getText();
        String phone = phoneText.getText();
        String password = passwordText.getText();
        String usernameOld = userUsername.getText();
        String username = userUsername1Text.getText();
        String nik = nikText.getText();
        String email = emailText.getText();
        String profilePic = profilePicText.getText();

        renamePhotoFile(usernameOld, username);
        updatedUser = new User(id, fullName, java.sql.Date.valueOf(birthDate), address, phone, username, password, nik, email, profilePic);
    }

    private void renamePhotoFile(String oldUsername, String newUsername) {
        String oldFileName = oldUsername + ".jpg";
        String newFileName = newUsername + ".jpg";
        String targetFolderPath = System.getProperty("user.dir") + "/src/main/resources/com/example/demo/photos/";

        File oldFile = new File(targetFolderPath, oldFileName);
        File newFile = new File(targetFolderPath, newFileName);

        oldFile.renameTo(newFile);
        oldFile.delete();
    }

    private void savePhotoToDirectory() {
        if (selectedPhotoFile != null) {
            String photoFileName = userUsername1Text.getText() + ".jpg";
            String targetFolderPath = System.getProperty("user.dir") + "/src/main/resources/com/example/demo/photos/";
            File targetFile = new File(targetFolderPath, photoFileName);

            try {
                Files.copy(selectedPhotoFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.err.println("Failed to save the selected photo.");
                e.printStackTrace();
            }
        }
    }

    private void refreshWindow() {
        try {
            Stage currentStage = (Stage) userUsername.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/home.fxml"));
            Parent root = loader.load();

            HomeController newController = loader.getController();
            newController.setUserData(updatedUser);

            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUserData(User user) {
        extractUserData(user);
    }

    public void receiveConfirmedHotelsList(List<ArrayList<ConfirmationData>> data) {
        confirmedHotelsListView.getItems().clear();

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

    @FXML
    private void openFlightSearch() {
        openWindow("/com/example/demo/flight.fxml");
    }

    @FXML
    private void openTrainSearch() {
        openWindow("/com/example/demo/train.fxml");
    }

    @FXML
    private void openHotelSearch() {
        openWindow("/com/example/demo/hotel.fxml");
    }

    @FXML
    private void eventSearch() {
        openWindow("/com/example/demo/event.fxml");
    }

    private void openWindow(String resourcePath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resourcePath));
            Parent root = loader.load();
            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(root));
            dashboardStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}