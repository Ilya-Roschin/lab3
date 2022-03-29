module com.university.lab3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.university.lab3 to javafx.fxml;
    exports com.university.lab3;
    exports com.university.lab3.controller;
    exports com.university.lab3.model;

    opens com.university.lab3.controller to javafx.fxml;
    opens com.university.lab3.model to javafx.fxml;
}