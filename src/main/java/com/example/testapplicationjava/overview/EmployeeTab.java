package com.example.testapplicationjava.overview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeTab extends Tab {

    private Button createEmployeeButton = null;
    private Label firstNameLabel = null;
    private Label lastNameLabel = null;
    private ObservableList<String> companiesList = null;
    private ComboBox companyComboBox = null;

    public EmployeeTab() {
        initialize();
    }

    private void initialize() {

    }

    private Button getCreateEmployee() {
        if (createEmployeeButton == null) {
            createEmployeeButton = new Button("Create employee");
            createEmployeeButton.setOnAction(event -> {
                log.info("Create employee clicked");
            });
        }
        return createEmployeeButton;
    }

    private Label getFirstName() {
        if (firstNameLabel == null) {
            firstNameLabel = new Label("First name: ");
        }
        return firstNameLabel;
    }

    private Label getLastName() {
        if (lastNameLabel == null) {
            lastNameLabel = new Label("Last name: ");
        }
        return lastNameLabel;
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

    private ComboBox getComboBox() {
        if (companyComboBox == null) {
            companyComboBox = new ComboBox(getCompaniesList());
        }
        return companyComboBox;
    }
}
