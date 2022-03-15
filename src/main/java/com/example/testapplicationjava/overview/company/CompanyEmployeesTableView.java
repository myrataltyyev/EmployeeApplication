package com.example.testapplicationjava.overview.company;

import com.example.testapplicationjava.model.Employee;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CompanyEmployeesTableView extends TableView {
    public CompanyEmployeesTableView(ObservableList<Employee> employees) {
        super(employees);
        init();
    }

    private void init() {
        // Create columns for the table
        TableColumn<String, Employee> tableColumnFirstName = new TableColumn<>("First Name");
        tableColumnFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<String, Employee> tableColumnLastName = new TableColumn<>("Last Name");
        tableColumnLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<String, Employee> tableColumnCompanyName = new TableColumn<>("Company Name");
        tableColumnCompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));

        // Add columns
        getColumns().addAll(tableColumnFirstName, tableColumnLastName, tableColumnCompanyName);
    }
}
