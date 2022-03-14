package com.example.testapplicationjava.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class EmployeeDataHandler {

    private List<Employee> employees = null;
    private String firstName = null;
    private String lastName = null;
    private String companyName = null;

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Connection connection = null;
    private final String SELECT_QUERY =
            "SELECT first_name, last_name, name \n" +
                    "FROM \"Employee\" e, \"Company\" c \n" +
                    "WHERE c.cid=e.cid AND c.cid=1;";

    private List<Employee> getEmployees(int cid) {
        if (employees == null) {
            employees = new ArrayList<>();
        }

        try {
            // Connect to DB
            connection = DatabaseConnection.connect();
            log.info("Successfully connected to DB");

            //Create a prepared statement
            preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setInt(1, cid);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Get the result in loop
            while(resultSet.next()) {

                firstName = resultSet.getString("first_name");
                lastName = resultSet.getString("last_name");
                companyName = resultSet.getString("company_name");

                log.info(String.format("%s %s %s", firstName, lastName, companyName));

                employees.add(new Employee(firstName, lastName, companyName));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public ObservableList<Employee> employeesObservableList() {
        ObservableList<Employee> observableList = FXCollections.observableList(getEmployees());
        return  observableList;
    }

}
