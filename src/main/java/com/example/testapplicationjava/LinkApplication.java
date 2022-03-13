package com.example.testapplicationjava;

import com.example.testapplicationjava.overview.OverviewScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LinkApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Hello!");
        stage.setScene(new Scene(new Button("Hey there")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}