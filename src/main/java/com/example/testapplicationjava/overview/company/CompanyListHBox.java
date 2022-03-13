package com.example.testapplicationjava.overview.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class CompanyListHBox extends HBox {

    private Label selectCompanyLabel = null;
    private ObservableList<String> companiesList = null;
    private ComboBox companiesComboBox = null;

    public CompanyListHBox() {
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

    public Label getSelectCompanyLabel() {
        if (selectCompanyLabel == null) {
            selectCompanyLabel = new Label("Select a company: ");
        }
        return selectCompanyLabel;
    }

    public ObservableList<String> getCompaniesList() {
        if (companiesList == null) {
            companiesList = FXCollections.observableArrayList(
                    "Company 1",
                    "Company 2",
                    "Company 3"
            );
        }
        return companiesList;
    }

    public ComboBox getCompaniesComboBox() {
        if (companiesComboBox == null) {
            companiesComboBox = new ComboBox(getCompaniesList());
        }
        return companiesComboBox;
    }
}
