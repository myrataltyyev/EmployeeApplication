package com.example.testapplicationjava.overview.employee;

import com.example.testapplicationjava.model.CompanyDataHandler;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class EmployeeCompanyListHBox extends HBox {

    private Label companyLabel = null;
    private ComboBox companiesComboBox = null;

    public EmployeeCompanyListHBox() {
        init();
    }

    private void init() {
        // Configure the layout
        this.setPadding(new Insets(10));
        this.setSpacing(10);

        // Add elements
        this.getChildren().add(getCompanyLabel());
        this.getChildren().add(getCompaniesComboBox());
    }

    protected ComboBox getCompaniesComboBox() {
        if (companiesComboBox == null) {
            companiesComboBox = new ComboBox(CompanyDataHandler.INSTANCE.companiesObservableList());
        }
        return companiesComboBox;
    }

    public void setCompaniesComboBox() {
        companiesComboBox.getItems().clear();
        companiesComboBox.getItems().addAll(CompanyDataHandler.INSTANCE.companiesObservableList());
    }

    private Label getCompanyLabel() {
        if (companyLabel == null) {
            companyLabel = new Label("Company: ");
        }
        return companyLabel;
    }
}
