package com.example.testapplicationjava.overview.employee;

import com.example.testapplicationjava.model.Employee;
import com.example.testapplicationjava.model.EmployeeDataHandler;
import com.example.testapplicationjava.overview.OverviewTabPane;
import com.example.testapplicationjava.overview.company.CompanyContentsVBox;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeMainBorderPane extends BorderPane {

    private EmployeeContentsVBox employeeContentsVBox = null;
    private Button createEmployeeButton = null;
    private Alert alert = null;

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
            createEmployeeButton = new Button("Create");

            // Create an employee
            createEmployeeButton.setOnAction(event -> {
                // Get field values
                String firstName = getEmployeeContentsVBox().getEmployeeFirstNameHBox().getfNameTextField().getText();
                String lastName = getEmployeeContentsVBox().getEmployeeLastNameHBox().getlNameTextField().getText();
                String companyName = (String) getEmployeeContentsVBox().getEmployeeCompanyListHBox()
                        .getCompaniesComboBox().getValue();

                // Check the fields
                if (firstName.equals("") || lastName.equals("") || companyName == null
                        || firstName.length() > 50 || lastName.length() > 50) {

                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error in creation");
                    alert.setContentText("Couldn't create an employee. Please, don't leave the fields empty " +
                            "and look at the length of your names.");
                    alert.showAndWait();

                } else {
                    // Create new employee
                    EmployeeDataHandler.INSTANCE.createEmployee(new Employee(firstName, lastName, companyName));

                    // Get the current selection from the company tab
                    String selectedCompany = (String) getCompanyContentsVBox().getCompanyListHBox()
                            .getCompaniesComboBox().getValue();

                    // Update the current selection of the table
                    if (companyName.equals(selectedCompany)) {
                        getCompanyContentsVBox().getCompanyEmployeesTableView().setItems(
                                EmployeeDataHandler.INSTANCE.employeesObservableList(selectedCompany));
                    }
                }
            });
        }
        return createEmployeeButton;
    }

    // Access to the Company tab
    private CompanyContentsVBox getCompanyContentsVBox() {
        return OverviewTabPane.getCompanyTab().getCompanyMainBorderPane()
                .getCompanyContentsVBox();
    }

}
