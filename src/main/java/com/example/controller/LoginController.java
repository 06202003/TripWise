package com.example.controller;
import com.example.DBUtil.DatabaseUtil;
import com.example.model.User;
import com.example.auth.LoginService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    private Stage stage;

//    public void setStage(Stage stage) {
//        this.stage = stage;
//    }

    @FXML
    public void handleLoginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?")) {

            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    User loggedInUser = new User();
                    String userFullName = resultSet.getString("name");
                    System.out.println("Login successful! Welcome, " + userFullName);

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/home.fxml"));
                    Parent root = loader.load();

//                    PesanTiketController pesanTiketController = loader.getController();
//                    homeController.setLoggedInUser(user); /

                    PesanTiketController otherController = loader.getController();
                    otherController.setLoggedInUser(userFullName); // Pass the user name

                    Stage homeStage = new Stage();
                    homeStage.setScene(new Scene(root));
                    homeStage.show();

                    // Close the Login stage
                    Stage loginStage = (Stage) loginButton.getScene().getWindow();
                    loginStage.close();
                } else {
                    System.out.println("Invalid credentials.");
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        Stage loginStage = (Stage) loginButton.getScene().getWindow();
        loginStage.close();
    }

//    @FXML
//    public void handleLoginButtonAction() {
//        String username = usernameField.getText();
//        String password = passwordField.getText();
//
//        LoginService loginService = new LoginService();
//        boolean isAuthenticated = loginService.authenticate(username, password);
//
//        if (isAuthenticated) {
//
//            System.out.println("Login berhasil!");
//
//            User user = loginService.getUserByUsername(username);
//            System.out.println("Selamat datang, " + user.getName() + "!");
//            System.out.println(user.getAddress());
//            System.out.println(user.getBirthDate());
//            System.out.println(user.getPhoneNumber());
//
//                try {
//                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/demo/home.fxml"));
//                    Parent dashboardRoot = fxmlLoader.load();
////                    PesanTiketController dashboardController = fxmlLoader.getController();
//
//                    Stage dashboardStage = new Stage();
//                    dashboardStage.setScene(new Scene(dashboardRoot));
//
//                    PesanTiketController dashboardController = fxmlLoader.getController();
////                    dashboardController.setUser(user);
//
//                    dashboardController.setNameText(user.getName());
//                    dashboardController.setNameText1(user.getName());
//                    dashboardController.setAddressText(user.getAddress());
//                    dashboardController.setPhoneText(user.getPhoneNumber());
////                    dashboardController.setBirthText(user.getBirthDate());
////                    dashboardController.setImageView(user.getProfilePicture());
////                    dashboardController.setTanggalLahirText(user.getTanggalLahir());
//
//                    dashboardStage.show();
//                    if (loginButton.getScene() != null) {
//                        loginButton.getScene().getWindow().hide();
//                    }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("Login gagal! Periksa kembali username dan password Anda.");
//            showAlert("Login gagal!", "Periksa kembali username dan password Anda.", Alert.AlertType.ERROR);
//        }
//    }

    @FXML
    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
