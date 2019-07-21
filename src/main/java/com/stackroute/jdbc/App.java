package com.stackroute.jdbc;

import java.sql.DatabaseMetaData;

public class App {

    public static void main( String[] args ) {

        SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();
        RowSetDemo rowSetDemo = new RowSetDemo();
        ResultSetMetadataDemo resultSetMetadataDemo = new ResultSetMetadataDemo();
        JdbcTransactionDemo jdbcTransactionDemo = new JdbcTransactionDemo();
        JdbcBatchDemo jdbcBatchDemo = new JdbcBatchDemo();
        DatabaseMetadataDemo databaseMetadataDemo = new DatabaseMetadataDemo();

        System.out.println("\n Print ResultSet : \n");
        simpleJdbcDemo.getEmployeeDetails();
        System.out.println("############################################################\n");

        System.out.println("\n Print ResultSet in reverse order : \n");
        simpleJdbcDemo.getEmployeeDetailsInReverse();
        System.out.println("############################################################\n");

        System.out.println("\n Move ResultSet to second row & in reverse order : \n");
        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
        System.out.println("############################################################\n");

        System.out.println("\n Use PreparedStatement to display by name and gender : \n");
        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("Tiny", "f");
        System.out.println("############################################################\n");

        System.out.println("\n Executing RowSetDemo : \n");
        rowSetDemo.rowSetDemo();
        System.out.println("############################################################\n");

        System.out.println("\n Executing ResultSetMetadataDemo : \n");
        resultSetMetadataDemo.resultSetMetadataDemo();
        System.out.println("############################################################\n");

        System.out.println("\n Executing DatabaseMetadataDemo : \n");
        databaseMetadataDemo.databaseMetadataDemo();
        System.out.println("############################################################\n");

        System.out.println("\n Executing JdbcBatchDemo : \n");
        jdbcBatchDemo.jdbcBatchDemo();
        System.out.println("############################################################\n");

        System.out.println("\n Executing JdbcTransactionDemo : \n");
        jdbcTransactionDemo.jdbcTransactionDemo();
        System.out.println("############################################################\n");
    }
}