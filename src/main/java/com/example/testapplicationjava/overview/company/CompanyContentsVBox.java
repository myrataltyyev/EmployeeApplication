package com.example.testapplicationjava.overview.company;

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

    public CompanyNameHBox getCompanyNameHBox() {
        if (companyNameHBox == null) {
            companyNameHBox = new CompanyNameHBox();
        }
        return companyNameHBox;
    }

    public CompanyListHBox getCompanyListHBox() {
        if (companyListHBox == null) {
            companyListHBox = new CompanyListHBox();
        }
        return companyListHBox;
    }

    public CompanyEmployeesTableView getCompanyEmployeesTableView() {
        if (companyEmployeesTableView == null) {
            companyEmployeesTableView = new CompanyEmployeesTableView();
        }
        return companyEmployeesTableView;
    }

    public Button getCreateCompanyButton() {
        if (createCompanyButton == null) {
            createCompanyButton = new Button("Create");
            createCompanyButton.setOnAction(event -> {
                log.info("Create employee clicked");
            });
        }
        return createCompanyButton;
    }
}
