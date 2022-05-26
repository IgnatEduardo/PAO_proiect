package com.company.repository;

import com.company.config.DatabaseConfiguration;
import com.company.user.entity.Address;
import com.company.user.entity.Employee;

import java.sql.*;

public class AddressRepository {
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS address " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "streetName varchar(30), " +
                "streetNumber  int, " +
                "cityName varchar(30), " +
                "countryName varchar(30) )";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertAddress(Address address) {
        String insertAddressSql = "INSERT INTO address(id, streetName, streetNumber, cityName, countryName) VALUES(?, ?,?,?,?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertAddressSql)) {
            preparedStatement.setInt(1, address.getId());
            preparedStatement.setString(2, address.getStreetName());
            preparedStatement.setInt(3, address.getStreetNumber());
            preparedStatement.setString(4, address.getCityName());
            preparedStatement.setString(5, address.getCountryName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAddress() {
        String insertAddressSql = "INSERT INTO address(id, streetName, streetNumber, cityName, countryName) VALUES(?, ?,?,?,?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            stmt.executeUpdate(insertAddressSql); // returns no of altered lines
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayAddress() {
        String selectSql = "SELECT * FROM address";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("streetName:" + resultSet.getString(2));
                System.out.println("streetNumber:" + resultSet.getDouble(3));
                System.out.println("cityName:" + resultSet.getDouble(4));
                System.out.println("countryName:" + resultSet.getDouble(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}