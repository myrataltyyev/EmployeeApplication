package com.example.testapplicationjava.overview.employee;

import javafx.scene.control.Tab;

public class EmployeeTab extends Tab {

    private EmployeeMainBorderPane employeeMainBorderPane = null;

    public EmployeeTab() {
        init();
    }

    private void init() {
        this.setText("Employee");   // set the tab's title
        this.setContent(getEmployeeMainBorderPane());   // set the content
    }

    public EmployeeMainBorderPane getEmployeeMainBorderPane() {
        if (employeeMainBorderPane == null) {
            employeeMainBorderPane = new EmployeeMainBorderPane();
        }
        return employeeMainBorderPane;
    }
}
