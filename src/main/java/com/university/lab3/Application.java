package com.university.lab3;

import com.university.lab3.init.Initialization;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        Initialization initialization = new Initialization();
 //       initialization.initUsers();
//        initialization.initFaculties();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/sign-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}