package com.university.lab3.controller;

import com.university.lab3.sign.UserSign;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class UserMenuController {

        private static final UserSign USER_SIGN = new UserSign();

        @FXML
        private Button backButton;

        @FXML
        private Button enrollButton;

        @FXML
        private Button statusButton;

        @FXML
        private Label usernameLabel;

        @FXML
        private void initialize() {
                updateUserField();
                backButton.setOnAction(actionEvent -> {
                        changeWindow("/sign-view.fxml");
                });
                enrollButton.setOnAction(actionEvent -> {
                        changeWindow("/user-enroll.fxml");
                });
                statusButton.setOnAction(actionEvent -> {
                        changeWindow("/user-status.fxml");
                });
        }

        private void changeWindow(String string) {
                backButton.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(string));
                try {
                        loader.load();
                } catch (IOException e) {
                        System.out.println("ошибка смены сцены");
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
        }

        private void updateUserField() {
                UserSign userSign = new UserSign();
                usernameLabel.setText("User: " + USER_SIGN.getSignUser().getUserName());
        }


}
