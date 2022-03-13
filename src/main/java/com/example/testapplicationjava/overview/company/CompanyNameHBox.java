package com.example.testapplicationjava.overview.company;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class CompanyNameHBox extends HBox {

    private Label nameLabel = null;
    private TextField nameTextField = null;

    public CompanyNameHBox() {
        init();
    }

    private void init() {
        // Configure the layout
        this.setPadding(new Insets(10));
        this.setSpacing(10);

        // Add elements
        this.getChildren().add(getNameLabel());
        this.getChildren().add(getNameTextField());
    }

    public Label getNameLabel() {
        if (nameLabel == null) {
            nameLabel = new Label("Company name: ");
        }
        return nameLabel;
    }

    public TextField getNameTextField() {
        if (nameTextField == null) {
            nameTextField = new TextField();
        }
        return nameTextField;
    }
}
