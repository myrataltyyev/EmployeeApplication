package com.example.testapplicationjava.overview.employee;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class EmployeeFirstNameHBox extends HBox {
    private Label fNameLabel = null;
    private TextField fNameTextField = null;

    public EmployeeFirstNameHBox() {
        init();
    }

    private void init() {
        // Configure the layout
        this.setPadding(new Insets(10));
        this.setSpacing(10);

        // Add elements
        this.getChildren().add(getfNameLabel());
        this.getChildren().add(getfNameTextField());
    }

    private Label getfNameLabel() {
        if (fNameLabel == null) {
            fNameLabel = new Label("First name: ");
        }
        return fNameLabel;
    }

    protected TextField getfNameTextField() {
        if (fNameTextField == null) {
            fNameTextField = new TextField();
        }
        return fNameTextField;
    }
}
