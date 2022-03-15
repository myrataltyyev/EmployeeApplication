package com.example.testapplicationjava.overview.company;

import com.example.testapplicationjava.model.Company;
import com.example.testapplicationjava.model.CompanyDataHandler;
import com.example.testapplicationjava.model.EmployeeDataHandler;
import com.example.testapplicationjava.overview.OverviewTabPane;
import com.example.testapplicationjava.overview.employee.EmployeeCompanyListHBox;
import com.example.testapplicationjava.overview.employee.EmployeeTab;
import javafx.geometry.Insets;
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

    private CompanyListHBox getCompanyListHBox() {
        if (companyListHBox == null) {
            companyListHBox = new CompanyListHBox(this);
        }
        return companyListHBox;
    }

    private Button getCreateCompanyButton() {
        if (createCompanyButton == null) {
            createCompanyButton = new Button("Create");

            // Create new company
            createCompanyButton.setOnAction(event -> {
                CompanyDataHandler.INSTANCE.createCompany(
                        new Company(getCompanyNameHBox().getNameTextField().getText())
                );

                // Update the combo boxes
                getCompanyListHBox().setCompaniesComboBox();            // in the company tab
                getEmployeeCompanyListHBox().setCompaniesComboBox();    // in the employee tab
            });
        }
        return createCompanyButton;
    }

    protected CompanyEmployeesTableView getCompanyEmployeesTableView() {
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
