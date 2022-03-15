package com.example.testapplicationjava.overview;

import com.example.testapplicationjava.overview.company.CompanyTab;
import com.example.testapplicationjava.overview.employee.EmployeeTab;
import javafx.scene.control.TabPane;

public class OverviewTabPane extends TabPane {

    private static EmployeeTab employeeTab = null;
    private static CompanyTab companyTab = null;

    public OverviewTabPane() {
        initialize();
    }

    private void initialize() {
        // Configure the layout
        this.setPrefWidth(800);
        this.setPrefHeight(700);

        // Add tabs
        this.getTabs().add(getEmployeeTab());
        this.getTabs().add(getCompanyTab());
    }

    public static EmployeeTab getEmployeeTab() {
        if (employeeTab == null) {
            employeeTab = new EmployeeTab();
        }
        return employeeTab;
    }

    public static CompanyTab getCompanyTab() {
        if (companyTab == null) {
            companyTab = new CompanyTab();
        }
        return companyTab;
    }
}
