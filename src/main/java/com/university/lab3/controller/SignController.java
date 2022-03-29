package com.university.lab3.controller;

import com.university.lab3.sign.UserSign;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static java.lang.System.exit;

public class SignController {

    @FXML
    private Button exitButton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signButton;


    @FXML
    private void initialize() {
        signButton.setOnAction(actionEvent -> {
            if (isUserFounded()) {
                UserSign userSign = new UserSign();
                if (Objects.equals(userSign.getSignUser().getRole(), "Admin")) {
                    changeWindow("/admin-view.fxml");
                } else {
                    changeWindow("/user-menu.fxml");
                }
            } else {
                System.out.println("User not founded");
            }
        });
        exitButton.setOnAction(actionEvent -> {
            exit(0);
        });
    }

    private void changeWindow(String string) {
        var stage = (Stage) signButton.getScene().getWindow();
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


    private boolean isUserFounded() {
        UserSign userSign = new UserSign();
        if (loginField.getText().length() >= 3 && passwordField.getText().length() >= 3) {
            return userSign.sign(loginField.getText().replaceAll("\\s+", ""),
                    passwordField.getText().replaceAll("\\s+", ""));
        } else {
            return false;
        }
    }


}

