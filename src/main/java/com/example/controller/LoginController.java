package com.example.controller;
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


public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void handleLoginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        LoginService loginService = new LoginService();
        boolean isAuthenticated = loginService.authenticate(username, password);

        if (isAuthenticated) {

            System.out.println("Login berhasil!");

            User user = loginService.getUserByUsername(username);
            System.out.println("Selamat datang, " + user.getName() + "!");
            System.out.println(user.getAddress());
            System.out.println(user.getTanggalLahir());
            System.out.println(user.getPhone());

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/demo/home.fxml"));
                    Parent dashboardRoot = fxmlLoader.load();
//                    PesanTiketController dashboardController = fxmlLoader.getController();

                    Stage dashboardStage = new Stage();
                    dashboardStage.setScene(new Scene(dashboardRoot));

                    PesanTiketController dashboardController = fxmlLoader.getController();
                    dashboardController.setUser(user);

                    dashboardController.setNameText(user.getName());
                    dashboardController.setNameText1(user.getName());
                    dashboardController.setAddressText(user.getAddress());
                    dashboardController.setPhoneText(user.getPhone());
//                    dashboardController.setTanggalLahirText(user.getTanggalLahir());

                    dashboardStage.show();
                    if (loginButton.getScene() != null) {
                        loginButton.getScene().getWindow().hide();
                    }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Login gagal! Periksa kembali username dan password Anda.");
            showAlert("Login gagal!", "Periksa kembali username dan password Anda.", Alert.AlertType.ERROR);
        }
    }
    @FXML
    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }


}
