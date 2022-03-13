package com.example.testapplicationjava.overview.company;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class CompanyMainBorderPane extends BorderPane {

    private CompanyContentsVBox companyContentsVBox = null;

    public CompanyMainBorderPane() {
        init();
    }

    private void init() {
        // Configure the layout
        this.setPadding(new Insets(10));

        // Add elements
        this.setCenter(getCompanyContentsVBox());
    }

    public CompanyContentsVBox getCompanyContentsVBox() {
        if (companyContentsVBox == null) {
            companyContentsVBox = new CompanyContentsVBox();
        }
        return companyContentsVBox;
    }
}
