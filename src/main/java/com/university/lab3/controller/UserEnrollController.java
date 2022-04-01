package com.university.lab3.controller;

import com.university.lab3.model.Faculty;
import com.university.lab3.model.User;
import com.university.lab3.repository.FacultyRepository;
import com.university.lab3.repository.UserRepository;
import com.university.lab3.sign.UserSign;
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

public class UserEnrollController {

    private static final UserSign USER_SIGN = new UserSign();
    private static final FacultyRepository FACULTY_REPOSITORY = new FacultyRepository();
    private static final UserRepository USER_REPOSITORY = new UserRepository();

    private ObservableList<Faculty> facultiesData = FXCollections.observableArrayList();
    private ObservableList<String> facultyNames = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Faculty, Double> markColumn;

    @FXML
    private Button backButton;

    @FXML
    private Button chooseButton;

    @FXML
    private ChoiceBox<String> chooseFacultyBox;

    @FXML
    private Label choosenFacultyLabel;

    @FXML
    private TableColumn<Faculty, String> facultyColumn;

    @FXML
    private TableView<Faculty> table;

    @FXML
    private Label usernameLabel;

    @FXML
    private void initialize() {

        facultyColumn.setCellValueFactory(new PropertyValueFactory<Faculty, String>("name"));
        markColumn.setCellValueFactory(new PropertyValueFactory<Faculty, Double>("averageMark"));
        initTable();
        table.setItems(facultiesData);

        initChoiceBox();
        chooseFacultyBox.setItems(facultyNames);

        usernameLabel.setText(USER_SIGN.getSignUser().getUserName());

        chooseButton.setOnAction(actionEvent -> {
            updateLabelFaculty();
            updateUserChoosenFaculty();
        });

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

    private void initTable() {
        for (Faculty element: FACULTY_REPOSITORY.findAll()) {
            facultiesData.add(element);
        }

    }

    private void initChoiceBox() {
        for (Faculty element: FACULTY_REPOSITORY.findAll()) {
            facultyNames.add(element.getName());
        }
    }

    private String findChoosenFacultyName() {
       return chooseFacultyBox.getValue();
    }

    private void updateLabelFaculty() {
        choosenFacultyLabel.setText("выбран " + findChoosenFacultyName());
    }

    private void updateUserChoosenFaculty() {

        if (!Objects.equals(findChoosenFacultyName(),null)) {
            String username = USER_SIGN.getSignUser().getUserName();
            User user = USER_REPOSITORY.findByName(username);
            user.setFacultyToEnroll(FACULTY_REPOSITORY.findByName(findChoosenFacultyName()));
            USER_REPOSITORY.updateUser(username, user);
        }
    }

}
