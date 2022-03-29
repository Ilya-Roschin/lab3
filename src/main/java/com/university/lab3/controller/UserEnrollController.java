package com.university.lab3.controller;

import com.university.lab3.sign.UserSign;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class UserEnrollController {

    private static final UserSign USER_SIGN = new UserSign();

    @FXML
    private TableColumn<?, ?> averageMark;

    @FXML
    private Button backButton;

    @FXML
    private Button chooseButton;

    @FXML
    private ChoiceBox<?> chooseFacultyBox;

    @FXML
    private Label choosenFacultyLabel;

    @FXML
    private TableColumn<?, ?> facultyFileld;

    @FXML
    private TableView<?> table;

    @FXML
    private Label usernameLabel;

    @FXML
    private void initialize() {
        backButton.setOnAction(actionEvent -> {
            changeWindow("/user-menu.fxml");
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
