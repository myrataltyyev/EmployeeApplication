package com.example.testapplicationjava.overview.company;

import javafx.scene.control.Tab;

public class CompanyTab extends Tab {

    private CompanyMainBorderPane companyMainBorderPane = null;

    public CompanyTab() {
        init();
    }

    private void init() {
        this.setText("Company");                        // set the tab's title
        this.setContent(getCompanyMainBorderPane());    // set the content
    }

    public CompanyMainBorderPane getCompanyMainBorderPane() {
        if (companyMainBorderPane == null) {
            companyMainBorderPane = new CompanyMainBorderPane();
        }
        return companyMainBorderPane;
    }
}
