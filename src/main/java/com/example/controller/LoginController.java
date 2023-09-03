package com.example.controller;
import com.example.DAO.UserDAO;
import com.example.DBUtil.DatabaseUtil;
import com.example.auth.UserSession;
import com.example.model.User;
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


public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    public void handleLoginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        UserDAO userDAO = new UserDAO();
        User user = userDAO.authenticateUser(username, password);

        if (user != null) {
            UserSession.getInstance().setLoggedInUser(user);
            System.out.println("Login successful! Welcome, " + user.getName());

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/home.fxml"));
                Parent root = loader.load();
                Stage homeStage = new Stage();
                homeStage.setScene(new Scene(root));
                homeStage.show();

                Stage loginStage = (Stage) loginButton.getScene().getWindow();
                loginStage.close();
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
