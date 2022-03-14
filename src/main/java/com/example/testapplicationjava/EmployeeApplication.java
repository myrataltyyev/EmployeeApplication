package com.example.testapplicationjava;

import com.example.testapplicationjava.overview.OverviewScene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeApplication extends Application {

    private OverviewScene overviewScene = null;
    private Stage primaryStage = null;

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        stage.setTitle("Link application");
        stage.setScene(getOverviewScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public OverviewScene getOverviewScene() {
        if (overviewScene == null) {
            overviewScene = new OverviewScene();
        }
        return overviewScene;
    }
}