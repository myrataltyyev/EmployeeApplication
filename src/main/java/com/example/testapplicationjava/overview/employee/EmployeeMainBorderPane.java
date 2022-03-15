package com.example.testapplicationjava.overview.employee;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeMainBorderPane extends BorderPane {

    private EmployeeContentsVBox employeeContentsVBox = null;

    public EmployeeMainBorderPane() {
        init();
    }

    private void init() {
        // Configure the layour
        this.setPadding(new Insets(10));

        // Add elements
        this.setCenter(getEmployeeContentsVBox());
    }

    public EmployeeContentsVBox getEmployeeContentsVBox() {
        if (employeeContentsVBox == null) {
            employeeContentsVBox = new EmployeeContentsVBox();
        }
        return employeeContentsVBox;
    }

}
