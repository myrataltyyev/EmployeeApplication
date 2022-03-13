package com.example.testapplicationjava.overview.employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class EmployeeCompanyHBox extends HBox {

    private Label companyLabel = null;
    private ObservableList<String> companiesList = null;
    private ComboBox companyComboBox = null;

    public EmployeeCompanyHBox() {
        init();
    }

    private void init() {
        // Configure the layout
        this.setPadding(new Insets(10));
        this.setSpacing(10);

        // Add elements
        this.getChildren().add(getCompanyComboBox());
    }

    private ObservableList<String> getCompaniesList() {
        if (companiesList == null) {
            companiesList = FXCollections.observableArrayList(
                    "Company 1",
                    "Company 2",
                    "Company 3"
            );
        }
        return companiesList;
    }

    private ComboBox getCompanyComboBox() {
        if (companyComboBox == null) {
            companyComboBox = new ComboBox(getCompaniesList());
        }
        return companyComboBox;
    }

    private Label getCompanyLabel() {
        if (companyLabel == null) {
            companyLabel = new Label("Company: ");
        }
        return companyLabel;
    }
}
