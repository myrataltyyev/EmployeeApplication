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
public enum CompanyDataHandler {
    INSTANCE;

    // Company related variables
    private List<Company> companies = null;
    private String companyName = null;

    // DB related variables
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Connection connection = null;

    // Query statements
    private final String SELECT_QUERY = "SELECT company_name FROM \"Company\";";
    private final String INSERT_QUERY = "INSERT INTO \"Company\"(company_name) VALUES (?);";

    // Flag to indicate the insertion result
    private boolean successState;

    private List<Company> getCompanies() {
        companies = new ArrayList<>();

        try {
            // Connect to DB
            connection = DatabaseConnection.connect();
            log.info("Successfully connected to DB");

            //Create a prepared statement
            preparedStatement = connection.prepareStatement(SELECT_QUERY);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Get the result in loop
            while(resultSet.next()) {
                companyName = resultSet.getString("company_name");
                companies.add(new Company(companyName));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            log.error(e.getMessage());

        } finally {
            DatabaseConnection.disconnect();
            log.info("Successfully disconnected from DB");
        }

        return companies;
    }

    public boolean createCompany(Company company) {
        successState = false;
        try {
            // First check for the duplicate
            // thus, get the list of companies from the DB
            List<Company> companyList = getCompanies();
            boolean exists = false;

            // Iterate through the list and compare with the input
            for (Company companyItem: companyList) {
                if (companyItem.getCompanyName().strip().equals(company.getCompanyName().strip())){
                    exists = true;
                    successState = false;

                    log.info("The company already exists in the database");
                    return successState;
                }
            }

            // Connect to DB
            connection = DatabaseConnection.connect();
            log.info("Successfully connected to DB");

            if (!exists) {
                successState = true;

                //Create a prepared statement and execute the query
                preparedStatement = connection.prepareStatement(INSERT_QUERY);
                preparedStatement.setString(1, company.getCompanyName().strip());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            log.error(e.getMessage());

        } finally {
            DatabaseConnection.disconnect();
            log.info("Successfully disconnected from DB");
        }
        return successState;
    }

    public ObservableList<String> companiesObservableList() {
        ObservableList<String> observableList = FXCollections.observableArrayList();

        // Iterate through the company objects to get the name
        for (Company company: getCompanies()) {
            observableList.add(company.getCompanyName());
        }

        return observableList;
    }
}
