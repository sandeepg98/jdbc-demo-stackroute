package com.stackroute.jdbc;

import java.sql.*;

public class SimpleJdbcDemo {

    private Connection connection;
    private  Statement statement;
    private ResultSet resultSet;


    /*Print ResultSet*/
    public void getEmployeeDetails() {

        //Load the required drivers
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Try to create a connection with your database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");) {

            while (resultSet.next())
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2) + " Age: " + resultSet.getInt(3) + " Gender: " + resultSet.getString(4));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }


    /*Print ResultSet in reverse order*/
    public void getEmployeeDetailsInReverse() {

        //Load the required drivers
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Try to create a connection with your database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");) {

            resultSet.afterLast();

            while (resultSet.previous())
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2) + " Age: " + resultSet.getInt(3) + " Gender: " + resultSet.getString(4));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /*Move ResultSet to second row and print in reverse order*/
    public void getEmployeeDetailsFromSecondRowInReverse() {

        //Load the required drivers
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Try to create a connection with your database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");) {

            resultSet.absolute(3);

            while (resultSet.previous())
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2) + " Age: " + resultSet.getInt(3) + " Gender: " + resultSet.getString(4));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /*Use PreparedStatement to display by name and gender*/
    public void getEmployeeDetailsByNameAndGender(String name,String gender) {

        //Load the required drivers
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Try to create a connection with your database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE name='"+name+"' AND gender='"+gender+"'");) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2) + " Age: " + resultSet.getInt(3) + " Gender: " + resultSet.getString(4));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}