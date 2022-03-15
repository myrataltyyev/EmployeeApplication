package com.example.testapplicationjava.overview.company;

import com.example.testapplicationjava.model.CompanyDataHandler;
import com.example.testapplicationjava.model.EmployeeDataHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class CompanyListHBox extends HBox {

    private Label selectCompanyLabel = null;
    private ComboBox companiesComboBox = null;
    private CompanyContentsVBox companyContentsVBox;
    private CompanyEmployeesTableView companyEmployeesTableView;

    public CompanyListHBox(CompanyContentsVBox companyContentsVBox) {
        this.companyContentsVBox = companyContentsVBox;
        init();
    }

    private void init(){
        // Configure the layout
        this.setPadding(new Insets(10));
        this.setSpacing(10);

        // Add elements
        this.getChildren().add(getSelectCompanyLabel());
        this.getChildren().add(getCompaniesComboBox());
    }

    private Label getSelectCompanyLabel() {
        if (selectCompanyLabel == null) {
            selectCompanyLabel = new Label("Select a company: ");
        }
        return selectCompanyLabel;
    }

    private ComboBox getCompaniesComboBox() {
        if (companiesComboBox == null) {
            companiesComboBox = new ComboBox(CompanyDataHandler.INSTANCE.companiesObservableList());

            // Show employee data
            companiesComboBox.setOnAction(event -> {
                companyEmployeesTableView = companyContentsVBox.getCompanyEmployeesTableView();
                String selectedCompany = (String) companiesComboBox.getValue();

                companyEmployeesTableView.setItems(
                        EmployeeDataHandler.INSTANCE.employeesObservableList(selectedCompany));
            });
        }
        return companiesComboBox;
    }

    public void setCompaniesComboBox() {
        companiesComboBox.getItems().clear();
        companiesComboBox.getItems().addAll(CompanyDataHandler.INSTANCE.companiesObservableList());
    }
}
