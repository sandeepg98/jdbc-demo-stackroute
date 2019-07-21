package com.stackroute.jdbc;

import java.sql.*;

public class JdbcBatchDemo {

    public void jdbcBatchDemo() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
             Statement statement = connection.createStatement();) {

            statement.addBatch("Insert into employee values(5,\"Sabya\",21,\"M\")");
            statement.addBatch("Insert into employee values(6,\"Agha\",21,\"M\")");
            statement.addBatch("Insert into employee values(7,\"Mites\",21,\"M\")");
            statement.addBatch("Insert into employee values(8,\"Paku\",21,\"M\")");
            statement.addBatch("Insert into employee values(9,\"Rohit\",21,\"M\")");
            statement.addBatch("Insert into employee values(10,\"Abinash\",21,\"M\")");
            statement.addBatch("Insert into employee values(11,\"Utkarsh\",21,\"M\")");
            statement.addBatch("Insert into employee values(12,\"Vishal\",21,\"M\")");
            statement.executeBatch();
            statement.clearBatch();
            ResultSet resultSet1 = statement.executeQuery("Select * from employee");
            while (resultSet1.next())
                System.out.println("id:" + resultSet1.getInt(1) + " Name:" + resultSet1.getString(2));

            resultSet1.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
