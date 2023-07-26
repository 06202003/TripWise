package com.example.controller;
import com.example.entity.User;
import com.example.auth.LoginService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private void handleLoginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        LoginService loginService = new LoginService();
        boolean isAuthenticated = loginService.authenticate(username, password);

        if (isAuthenticated) {

            System.out.println("Login berhasil!");

            User user = loginService.getUserByUsername(username);
            System.out.println("Selamat datang, " + user.getNama() + "!");

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/demo/home.fxml"));
                    Parent dashboardRoot = fxmlLoader.load();
                    PesanTiketController dashboardController = fxmlLoader.getController();

                    Stage dashboardStage = new Stage();
                    dashboardStage.setScene(new Scene(dashboardRoot));

                    dashboardStage.show();
                    if (loginButton.getScene() != null) {
                        loginButton.getScene().getWindow().hide();
                    }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Login gagal! Periksa kembali username dan password Anda.");
        }
    }




}
