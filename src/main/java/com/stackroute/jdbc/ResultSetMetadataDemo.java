package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo {

    public void  resultSetMetadataDemo() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");) {

            System.out.println("Returns the number of columns in this <code>ResultSet</code> object.");
            ResultSetMetaData metaData = resultSet.getMetaData();
            System.out.println(metaData.getColumnCount());

            System.out.println(" Indicates whether the designated column is automatically numbered.");
            System.out.println(metaData.isAutoIncrement(1));

            System.out.println(" Indicates whether the designated column can be used in a where clause.");
            System.out.println(metaData.isSearchable(1));

            System.out.println("Get the designated column's table's schema.");
            System.out.println(metaData.getSchemaName(1));

            System.out.println("Gets the designated column's table name.");
            System.out.println(metaData.getTableName(1));

            while (resultSet.next())
                System.out.println("ID:" + resultSet.getInt(1) + " Name:" + resultSet.getString(2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
