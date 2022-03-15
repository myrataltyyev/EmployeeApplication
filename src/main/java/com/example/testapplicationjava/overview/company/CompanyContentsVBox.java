package com.example.testapplicationjava.overview.company;

import com.example.testapplicationjava.model.Company;
import com.example.testapplicationjava.model.CompanyDataHandler;
import com.example.testapplicationjava.model.EmployeeDataHandler;
import com.example.testapplicationjava.overview.OverviewTabPane;
import com.example.testapplicationjava.overview.employee.EmployeeCompanyListHBox;
import com.example.testapplicationjava.overview.employee.EmployeeTab;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompanyContentsVBox extends VBox {

    private CompanyNameHBox companyNameHBox = null;
    private CompanyListHBox companyListHBox = null;
    private CompanyEmployeesTableView companyEmployeesTableView = null;
    private Button createCompanyButton = null;
    private EmployeeTab employeeTab = null;
    private Alert alert = null;

    public CompanyContentsVBox() {
        init();
    }

    private void init() {
        // Configure the layout
        this.setPadding(new Insets(10));
        this.setSpacing(10);

        // Add elements
        this.getChildren().add(getCompanyNameHBox());
        this.getChildren().add(getCreateCompanyButton());
        this.getChildren().add(getCompanyListHBox());
        this.getChildren().add(getCompanyEmployeesTableView());
    }

    private CompanyNameHBox getCompanyNameHBox() {
        if (companyNameHBox == null) {
            companyNameHBox = new CompanyNameHBox();
        }
        return companyNameHBox;
    }

    public CompanyListHBox getCompanyListHBox() {
        if (companyListHBox == null) {
            companyListHBox = new CompanyListHBox(this);
        }
        return companyListHBox;
    }

    private Button getCreateCompanyButton() {
        if (createCompanyButton == null) {
            createCompanyButton = new Button("Create");

            // Create a company
            createCompanyButton.setOnAction(event -> {
                // Get the value and check
                String companyName = getCompanyNameHBox().getNameTextField().getText();
                if (companyName.equals("") || companyName.length() > 50) {

                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error in creation");
                    alert.setContentText("Couldn't create a company. Please, don't leave the fields empty " +
                            "and look at the length of the name.");
                    alert.getDialogPane().setStyle("-fx-font-size: 16px;"); // doesn't work with CSS, might be a bug
                    alert.showAndWait();

                } else {
                    // Create new company
                    boolean successState = CompanyDataHandler.INSTANCE.createCompany(
                            new Company(companyName));

                    if (successState) {
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information");
                        alert.setHeaderText("Successfully created");
                    } else {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Error in creation");
                        alert.setContentText("Couldn't create the company. The company already exists.");
                    }
                    alert.getDialogPane().setStyle("-fx-font-size: 16px;");
                    alert.showAndWait();

                    // Update the combo boxes
                    getCompanyListHBox().setCompaniesComboBox();            // company tab
                    getCompanyListHBox().getCompaniesComboBox().setValue(companyName);
                    getEmployeeCompanyListHBox().setCompaniesComboBox();    // employee tab
                }
            });
        }
        return createCompanyButton;
    }

    public CompanyEmployeesTableView getCompanyEmployeesTableView() {
        if (companyEmployeesTableView == null) {
            companyEmployeesTableView = new CompanyEmployeesTableView(
                    EmployeeDataHandler.INSTANCE.employeesObservableList(null));
        }
        return companyEmployeesTableView;
    }

    // Access to the Employee tab
    private EmployeeCompanyListHBox getEmployeeCompanyListHBox() {
        return OverviewTabPane.getEmployeeTab().getEmployeeMainBorderPane()
                .getEmployeeContentsVBox().getEmployeeCompanyListHBox();
    }
}
