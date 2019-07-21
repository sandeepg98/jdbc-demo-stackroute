package com.stackroute.jdbc;

import  java.sql.*;
import java.util.Scanner;

public class JdbcTransactionDemo {

    public void jdbcTransactionDemo() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");) {

            connection.setAutoCommit(false);
            statement.addBatch("Insert into employee values(1,\"Sabya\",21,\"M\")");
            statement.addBatch("Insert into employee values(2,\"Agha\",21,\"M\")");
            statement.addBatch("Insert into employee values(3,\"Mites\",21,\"M\")");
            statement.addBatch("Insert into employee values(4,\"Paku\",21,\"M\")");
            statement.addBatch("Insert into employee values(5,\"Rohit\",21,\"M\")");
            statement.addBatch("Insert into employee values(6,\"Abinash\",21,\"M\")");
            statement.addBatch("Insert into employee values(7,\"Utkarsh\",21,\"M\")");
            statement.addBatch("Insert into employee values(8,\"Vishal\",21,\"M\")");

            statement.executeBatch();
            statement.clearBatch();

            ResultSet resultSet1 = statement.executeQuery("Select * from employee");

            while (resultSet1.next())
                System.out.println("id: " + resultSet1.getInt(1) + "Name:" + resultSet1.getString(2));

            resultSet1.close();
            System.out.println("You Want to commit or rollback");
            Scanner scanner=new Scanner(System.in);

            if(scanner.next().equals("commit"))
                connection.commit();

            else
                connection.rollback();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
