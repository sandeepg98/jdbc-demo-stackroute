package com.stackroute.jdbc;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.DriverManager;
import com.sun.rowset.JdbcRowSetImpl;


public class RowSetDemo {

    private JdbcRowSet rowSet;

    public void rowSetDemo() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
             JdbcRowSetImpl rowSet = new JdbcRowSetImpl(connection);){

            rowSet.setCommand("Select * from employee");
            rowSet.execute();
            rowSet.addRowSetListener(new RowSetListener() {

                @Override
                public void rowSetChanged(RowSetEvent event) {
                    System.out.println("\n ----------rowset changed----------");
                }

                @Override
                public void rowChanged(RowSetEvent event) {
                    System.out.println("\n ----------row changed----------");
                }

                @Override
                public void cursorMoved(RowSetEvent event) {
                    System.out.println("\n ----------cursor moved----------");
                }
            });

            while (rowSet.next())
                System.out.println("Id: " + rowSet.getInt(1) + " Name: " + rowSet.getString(2) + " Age: " + rowSet.getInt(3) + " Gender: " + rowSet.getString(4));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}