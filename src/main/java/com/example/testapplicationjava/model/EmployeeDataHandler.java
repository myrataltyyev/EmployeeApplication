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
public enum EmployeeDataHandler {
    INSTANCE;

    // Employee related variables
    private List<Employee> employees = null;
    private String firstName = null;
    private String lastName = null;
    private String companyName = null;

    // DB related variables
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Connection connection = null;

    // Query statements
    private final String SELECT_QUERY =
            "SELECT first_name, last_name, company_name \n" +
                    "FROM \"Employee\" e, \"Company\" c \n" +
                    "WHERE c.cid=e.cid AND c.company_name = ?;";
    private final String INSERT_QUERY =
            "INSERT INTO \"Employee\"(first_name, last_name, cid) " +
                    "SELECT ?, ?, cid " +
                    "FROM \"Company\" " +
                    "WHERE company_name = ?;";

    public List<Employee> getEmployees(String companyName) {
        employees = new ArrayList<>();

        try {
            // Connect to DB
            connection = DatabaseConnection.connect();
            log.info("Successfully connected to DB");

            //Create a prepared statement
            preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1, companyName);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Get the result in loop
            while(resultSet.next()) {

                firstName = resultSet.getString("first_name");
                lastName = resultSet.getString("last_name");

                employees.add(new Employee(firstName, lastName, companyName));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        } finally {
            DatabaseConnection.disconnect();
            log.info("Successfully disconnected from DB");
        }

        return employees;
    }

    public void createEmployee(Employee employee) {
        try {
            // Connect to DB
            connection = DatabaseConnection.connect();
            log.info("Successfully connected to DB");

            //Create a prepared statement
            preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getCompanyName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            log.error(e.getMessage());

        } finally {
            DatabaseConnection.disconnect();
            log.info("Successfully disconnected from DB");
        }
    }

    public ObservableList<Employee> employeesObservableList(String companyName) {
        ObservableList<Employee> observableList = FXCollections.observableList(getEmployees(companyName));
        return  observableList;
    }
}
