package com.example.testapplicationjava.overview.employee;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeMainBorderPane extends BorderPane {

    private EmployeeContentsVBox employeeContentsVBox = null;
    private Button createEmployeeButton = null;

    public EmployeeMainBorderPane() {
        init();
    }

    private void init() {
        // Configure the layour
        this.setPadding(new Insets(10));

        // Add elements
        this.setCenter(getEmployeeContentsVBox());
        this.setBottom(getCreateEmployeeButton());
    }

    public EmployeeContentsVBox getEmployeeContentsVBox() {
        if (employeeContentsVBox == null) {
            employeeContentsVBox = new EmployeeContentsVBox();
        }
        return employeeContentsVBox;
    }

    private Button getCreateEmployeeButton() {
        if (createEmployeeButton == null) {
            createEmployeeButton = new Button("Create employee");
            createEmployeeButton.setOnAction(event -> {
                log.info("Create employee clicked");
            });
        }
        return createEmployeeButton;
    }

}
