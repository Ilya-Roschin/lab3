package com.university.lab3.controller;

import com.university.lab3.sign.UserSign;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.System.exit;

public class SignController {

    @FXML
    private CheckBox adminButton;

    @FXML
    private Button exitButton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signButton;

    @FXML
    private CheckBox userButton;


    @FXML
    private void initialize() {
        signButton.setOnAction(actionEvent -> {
            if (isUserFounded()) {
                changeWindow();
            } else {
                System.out.println("User not founded");
            }
        });
        exitButton.setOnAction(actionEvent -> {
            exit(0);
        });
    }

    private void changeWindow() {
        var stage = (Stage) signButton.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/user-menu.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            System.out.println("ошибка смены сцены");
        }

        Parent root = loader.getRoot();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private boolean isRoleSelected() {
        if (userButton.isSelected() || adminButton.isSelected()) {
            return true;
        } else {
            return false;
        }
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

