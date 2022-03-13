package com.example.testapplicationjava.overview.employee;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class EmployeeLastNameHBox extends HBox {
    private Label lNameLabel = null;
    private TextField lNameTextField = null;

    public EmployeeLastNameHBox() {
        init();
    }

    private void init() {
        // Configure the layout
        this.setPadding(new Insets(10));
        this.setSpacing(10);

        // Add elements
        this.getChildren().add(getlNameLabel());
        this.getChildren().add(getlNameTextField());
    }

    private Label getlNameLabel() {
        if (lNameLabel == null) {
            lNameLabel = new Label("Last name: ");
        }
        return lNameLabel;
    }

    private TextField getlNameTextField() {
        if (lNameTextField == null) {
            lNameTextField = new TextField();
        }
        return lNameTextField;
    }
}
