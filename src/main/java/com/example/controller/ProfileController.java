package com.example.controller;

import com.example.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

public class ProfileController {
    @FXML
    private ImageView profileImageView;

    @FXML
    private TextField nameField;

    private User user = new User();

    public void initialize() {
        // Load the initial profile image (if available)
        updateProfileImage();
    }

    @FXML
    private void changeProfilePicture(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Picture");
        File selectedFile = fileChooser.showOpenDialog(profileImageView.getScene().getWindow());

        if (selectedFile != null) {
            String imagePath = selectedFile.toURI().toString();
            user.setProfilePicture(imagePath);
            updateProfileImage();
        }
    }

    private void updateProfileImage() {
        String imagePath = user.getProfilePicture();
        if (imagePath != null && !imagePath.isEmpty()) {
            Image image = new Image(imagePath);
            profileImageView.setImage(image);
        }
    }
}
