package com.example.testapplicationjava.overview.employee;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class EmployeeContentsVBox extends VBox {

    private EmployeeFirstNameHBox employeeFirstNameHBox = null;
    private EmployeeLastNameHBox employeeLastNameHBox = null;
    private EmployeeCompanyHBox employeeCompanyHBox = null;

    public EmployeeContentsVBox() {
        init();
    }

    private void init() {
        // Configure the layout
        this.setPadding(new Insets(10));
        this.setSpacing(10);

        // Add elements
        this.getChildren().add(getEmployeeFirstNameHBox());
        this.getChildren().add(getEmployeeLastNameHBox());
        this.getChildren().add(getEmployeeCompanyHBox());
    }

    public EmployeeFirstNameHBox getEmployeeFirstNameHBox() {
        if (employeeFirstNameHBox == null) {
            employeeFirstNameHBox = new EmployeeFirstNameHBox();
        }
        return employeeFirstNameHBox;
    }

    public EmployeeLastNameHBox getEmployeeLastNameHBox() {
        if (employeeLastNameHBox == null) {
            employeeLastNameHBox = new EmployeeLastNameHBox();
        }
        return employeeLastNameHBox;
    }

    public EmployeeCompanyHBox getEmployeeCompanyHBox() {
        if (employeeCompanyHBox == null) {
            employeeCompanyHBox = new EmployeeCompanyHBox();
        }
        return employeeCompanyHBox;
    }
}
