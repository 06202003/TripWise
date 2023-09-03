package com.example.controller;

import com.example.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ProfileController {

    @FXML
    private ImageView imageView;
    private User user;

//    public void setUser(User user) {
//        this.user = user;
//        updateImageView();
//    }

    @FXML
    private void gantiFotoButtonClicked(ActionEvent event) {
        System.out.println("Button clicked");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.jpeg", "*.png"));

        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            try {
                String resourcesPath = new File("").getAbsolutePath(); // Mendapatkan path absolut proyek
                String imgPath = resourcesPath + "/src/main/resources/com/example/demo/img/";
                String fileName = "profile_picture_" + user.getUsername() + "." + getExtension(selectedFile.getName());
                String destinationPath = imgPath + fileName;

                File destinationFile = new File(destinationPath);
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                String newProfilePicturePath = "com/example/demo/img/" + fileName; // Path relatif di dalam resource

                // Mengganti path gambar profil pada objek User
//                user.setProfilePicture(newProfilePicturePath);

//                updateImageView();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



//    private void updateImageView() {
//        String profilePicturePath = user.getProfilePicture();
//        if (profilePicturePath != null) {
//            try {
//                // Mendapatkan URL yang valid untuk objek Image
//                URL imageUrl = getClass().getResource(profilePicturePath);
//                if (imageUrl != null) {
//                    Image image = new Image(imageUrl.toExternalForm());
//                    imageView.setCache(false);
//                    imageView.setImage(image);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }


    private String getExtension(String path) {
        int dotIndex = path.lastIndexOf(".");
        if (dotIndex > 0 && dotIndex < path.length() - 1) {
            return path.substring(dotIndex + 1);
        }
        return "";
    }
}
