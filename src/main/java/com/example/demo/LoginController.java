package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Here you can implement the logic to validate the username and password
        // For simplicity, we'll just print them for demonstration purposes.
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}
