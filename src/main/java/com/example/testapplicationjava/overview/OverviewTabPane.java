package com.example.testapplicationjava.overview;

import com.example.testapplicationjava.overview.company.CompanyTab;
import com.example.testapplicationjava.overview.employee.EmployeeTab;
import javafx.scene.control.TabPane;

public class OverviewTabPane extends TabPane {

    private EmployeeTab employeeTab = null;
    private CompanyTab companyTab = null;

    public OverviewTabPane() {
        initialize();
    }

    private void initialize() {
        // Configure the layout
        this.setPrefWidth(800);
        this.setPrefHeight(600);

        // Add tabs
        this.getTabs().add(getEmployeeTab());
        this.getTabs().add(getCompanyTab());
    }

    public EmployeeTab getEmployeeTab() {
        if (employeeTab == null) {
            employeeTab = new EmployeeTab();
        }
        return employeeTab;
    }

    public CompanyTab getCompanyTab() {
        if (companyTab == null) {
            companyTab = new CompanyTab();
        }
        return companyTab;
    }
}
