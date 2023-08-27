package com.example.controller;
import com.example.DBUtil.DatabaseUtil;
import com.example.auth.UserSession;
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
import java.sql.*;
import java.time.LocalDate;


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
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?")) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Integer userId = resultSet.getInt("id");
                    String userFullName = resultSet.getString("name");
                    Date userBirthDate = resultSet.getDate("birthDate");
                    if (userBirthDate != null && userBirthDate.toString().equals("0000-00-00")) {
                        userBirthDate = null;
                    }
                    String userAddress = resultSet.getString("address");
                    String userPhoneNumber = resultSet.getString("phoneNumber");
                    String userUsername = resultSet.getString("username");
                    String userPassword = resultSet.getString("password");
                    String userNik = resultSet.getString("nik");
                    String userEmail = resultSet.getString("email");
                    String userProfilePicture = resultSet.getString("profilePicture");

                    User user = new User(userId, userFullName, userBirthDate, userAddress, userPhoneNumber, userUsername, userPassword, userNik, userEmail, userProfilePicture);
                    UserSession.getInstance().setLoggedInUser(user);

                    System.out.println("Login successful! Welcome, " + userFullName);

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/home.fxml"));
                    Parent root = loader.load();

                    Stage homeStage = new Stage();
                    homeStage.setScene(new Scene(root));
                    homeStage.show();
                    Stage loginStage = (Stage) loginButton.getScene().getWindow();
                    loginStage.close();
                } else {
                    System.out.println("Login gagal! Periksa kembali username dan password Anda.");
                    showAlert("Login gagal!", "Periksa kembali username dan password Anda.", Alert.AlertType.ERROR);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
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
