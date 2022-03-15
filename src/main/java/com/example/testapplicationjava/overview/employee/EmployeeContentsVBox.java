package com.example.testapplicationjava.overview.employee;

import com.example.testapplicationjava.model.Employee;
import com.example.testapplicationjava.model.EmployeeDataHandler;
import com.example.testapplicationjava.overview.OverviewTabPane;
import com.example.testapplicationjava.overview.company.CompanyContentsVBox;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class EmployeeContentsVBox extends VBox {

    private EmployeeFirstNameHBox employeeFirstNameHBox = null;
    private EmployeeLastNameHBox employeeLastNameHBox = null;
    private EmployeeCompanyListHBox employeeCompanyHBox = null;
    private Button createEmployeeButton = null;
    private Alert alert = null;

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
        this.getChildren().add(getEmployeeCompanyListHBox());
        this.getChildren().add(getCreateEmployeeButton());
    }

    protected EmployeeFirstNameHBox getEmployeeFirstNameHBox() {
        if (employeeFirstNameHBox == null) {
            employeeFirstNameHBox = new EmployeeFirstNameHBox();
        }
        return employeeFirstNameHBox;
    }

    protected EmployeeLastNameHBox getEmployeeLastNameHBox() {
        if (employeeLastNameHBox == null) {
            employeeLastNameHBox = new EmployeeLastNameHBox();
        }
        return employeeLastNameHBox;
    }

    public EmployeeCompanyListHBox getEmployeeCompanyListHBox() {
        if (employeeCompanyHBox == null) {
            employeeCompanyHBox = new EmployeeCompanyListHBox();
        }
        return employeeCompanyHBox;
    }

    private Button getCreateEmployeeButton() {
        if (createEmployeeButton == null) {
            createEmployeeButton = new Button("Create");

            // Create an employee
            createEmployeeButton.setOnAction(event -> {
                // Get field values
                String firstName = getEmployeeFirstNameHBox().getfNameTextField().getText();
                String lastName = getEmployeeLastNameHBox().getlNameTextField().getText();
                String companyName = (String) getEmployeeCompanyListHBox()
                        .getCompaniesComboBox().getValue();

                // Check the fields
                if (firstName.equals("") || lastName.equals("") || companyName == null
                        || firstName.length() > 50 || lastName.length() > 50) {

                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error in creation");
                    alert.setContentText("Couldn't create an employee. Please, don't leave the fields empty " +
                            "and look at the length of your names.");
                    alert.getDialogPane().setStyle("-fx-font-size: 16px;"); // doesn't work with CSS, might be a bug
                    alert.showAndWait();

                } else {
                    // Create new employee
                    boolean successState = EmployeeDataHandler.INSTANCE.createEmployee(
                            new Employee(firstName, lastName, companyName));

                    if (successState) {
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information");
                        alert.setHeaderText("Successfully created");
                    } else {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Error in creation");
                        alert.setContentText("Couldn't create the employee. The employee already exists.");
                    }
                    alert.getDialogPane().setStyle("-fx-font-size: 16px;");
                    alert.showAndWait();

                    // Get the current selection from the company tab
                    // in order to update the table
                    String selectedCompany = (String) getCompanyContentsVBox().getCompanyListHBox()
                            .getCompaniesComboBox().getValue();

                    // Update the current selection of the table
                    // if the added employee works for the selected company
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
