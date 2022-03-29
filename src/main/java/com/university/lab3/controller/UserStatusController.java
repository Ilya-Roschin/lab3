package com.university.lab3.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class UserStatusController {

    @FXML
    private Button backButton;

    @FXML
    private Label infoText;

    @FXML
    private Label usernameLable;

    @FXML
    private void initialize() {

        backButton.setOnAction(actionEvent -> {
            changeWindow("/user-menu.fxml");
            System.out.println("backButton");
        });

    }

    private void changeWindow(String string) {
        var stage = (Stage) backButton.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(string));
        try {
            loader.load();
        } catch (IOException e) {
            System.out.println("ошибка смены сцены");
        }

        Parent root = loader.getRoot();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
