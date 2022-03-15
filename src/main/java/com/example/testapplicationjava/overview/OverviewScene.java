package com.example.testapplicationjava.overview;

import javafx.scene.Scene;

public class OverviewScene extends Scene {
    public OverviewScene() {
        super(new OverviewTabPane());

        // Apply styles
        this.getStylesheets().add("styles.css");
    }
}
