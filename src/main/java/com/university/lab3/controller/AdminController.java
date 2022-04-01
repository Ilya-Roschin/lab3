package com.university.lab3.controller;

import com.university.lab3.model.User;
import com.university.lab3.repository.UserRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdminController {

    private static final UserRepository USER_REPOSITORY = new UserRepository();

    private ObservableList<User> usersData = FXCollections.observableArrayList();

    private ObservableList<String> userNames = FXCollections.observableArrayList();

    @FXML
    private Button backButton;

    @FXML
    private TextField choiseMark;

    @FXML
    private ChoiceBox<String> choiseUser;

    @FXML
    private TableColumn<User, Double> markColumn;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private Button setMark;

    @FXML
    private TableView<User> table;

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));
        markColumn.setCellValueFactory(new PropertyValueFactory<User, Double>("averageMark"));
        updateTable();
        initChoiceBox();
        backButton.setOnAction(actionEvent -> {
            changeWindow("/sign-view.fxml");
        });
        setMark.setOnAction(actionEvent -> {
            setMark();
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

    private void updateTable() {
        usersData.clear();
        for (User element: USER_REPOSITORY.findAll()) {
            if (Objects.equals(element.getRole(), "User")) {
                usersData.add(element);
            }
        }

        table.setItems(usersData);
    }

    private void initChoiceBox() {
        for (User element: USER_REPOSITORY.findAll()) {
            userNames.add(element.getUserName());
        }
        choiseUser.setItems(userNames);
    }

    private void setMark() {
        try {
            final double markToSet = Double.parseDouble(choiseMark.getText());
            String username = choiseUser.getValue();
            User user = USER_REPOSITORY.findByName(username);
            user.setAverageMark(markToSet);
            USER_REPOSITORY.updateUser(username, user);
            updateTable();
        } catch (Exception e) {
            System.out.println("Ошибка выставления оценки");
        }

    }

}
