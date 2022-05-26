package com.company.repository;

import com.company.config.DatabaseConfiguration;
import com.company.user.entity.Employee;

import java.sql.*;

public class EmployeeRepository {
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS employee " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "name varchar(30), " +
                "age int, " +
                "email varchar(30), " +
                "FOREIGN KEY (address_id) REFERENCES address(address_id), " + //foreign key
                "position varchar(30), " +
                "salary double)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertEmployee(Employee employee) { //TODO cu foreign key pentru address
        String insertEmployeeSql = "INSERT INTO employee(id, name, age, email, address, position, salary) VALUES(?, ?,?,?,?,?,?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertEmployeeSql)) {
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getAddress().toString());
            preparedStatement.setString(6, employee.getPosition());
            preparedStatement.setDouble(7, employee.getSalary());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEmployee() {
        String insertEmployeeSql = "INSERT INTO employee(id, name, age, email, address, position, salary) VALUES('eduardo', 20, 'eduardo.ygn@gmail.com', 'republicii 20 Adjud Romania', 'inginer', 100)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            stmt.executeUpdate(insertEmployeeSql); // returns no of altered lines
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayEmployee() {
        String selectSql = "SELECT * FROM employee";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getInt(1));
                System.out.println("Name:" + resultSet.getString(2));
                System.out.println("Age:" + resultSet.getInt(3));
                System.out.println("Email:" + resultSet.getString(3));
                System.out.println("Address:" + resultSet.getString(3));
                System.out.println("Position:" + resultSet.getString(3));
                System.out.println("Salary:" + resultSet.getDouble(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}