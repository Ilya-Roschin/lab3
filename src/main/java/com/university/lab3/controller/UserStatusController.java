package com.university.lab3.controller;

import com.university.lab3.model.User;
import com.university.lab3.repository.UserRepository;
import com.university.lab3.sign.UserSign;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class UserStatusController {

    private static final UserSign USER_SIGN = new UserSign();
    private static final UserRepository USER_REPOSITORY = new UserRepository();

    @FXML
    private Button backButton;

    @FXML
    private Label infoText;

    @FXML
    private Label usernameLable;

    @FXML
    private void initialize() {
        updateLabelText();
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

    private void updateLabelText() {
        final User signUser = USER_REPOSITORY.findByName(USER_SIGN.getSignUser().getUserName());

        String facultyToEnroll = "не выбрано";
        String faculty = "ещё нет";

        try {
            facultyToEnroll = signUser.getFacultyToEnroll().getName();
        } catch (NullPointerException e) {
            System.out.println("поле facultyToEnroll отсутствует");
        }

        try {
            faculty = signUser.getFacultyToEnroll().getName();
        } catch (NullPointerException e) {
            System.out.println("поле faculty отсутствует");
        }

        infoText.setText("Имя: " + signUser.getUserName() + "\n" + "Средний балл" + signUser.getAverageMark() + "\n" +
                "Поступил: " + faculty + "\n" + "Выбранный факультет: " + facultyToEnroll + "\n");
    }
}
