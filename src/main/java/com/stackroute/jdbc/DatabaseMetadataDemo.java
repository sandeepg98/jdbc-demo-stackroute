package com.stackroute.jdbc;

import java.sql.*;

public class DatabaseMetadataDemo {

    public void databaseMetadataDemo() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");) {

            DatabaseMetaData metaData=connection.getMetaData();

            System.out.println("Retrieves whether this database supports sharding.");
            System.out.println(//metaData.supportsSharding()
                    "Can't use this Function(.supportsShardng)");
            System.out.println("Retrieves whether this database supports REF CURSOR.");
            System.out.println(//metaData.supportsRefCursors()
                    "can't use this Function(.supportsRefCursors)" );
            System.out.println("Retrieves whether the current user can call all the procedures\n" +
                    " returned by the method <code>getProcedures</code>.");
            System.out.println(metaData.allProceduresAreCallable());
            System.out.println("Retrieves whether the current user can use all the tables returned\n" +
                    "     * by the method <code>getTables</code> in a <code>SELECT</code>\n" +
                    "     * statement.");
            System.out.println(metaData.allTablesAreSelectable());
            System.out.println("Retrieves the URL for this DBMS.");
            System.out.println(metaData.getURL());
            System.out.println("Retrieves the user name as known to this database.");
            System.out.println(metaData.getUserName());
            System.out.println("Retrieves whether this database is in read-only mode.");
            System.out.println(metaData.isReadOnly());
            System.out.println("Retrieves the name of this database product.");
            System.out.println(metaData.getDatabaseProductName());
            System.out.println("Retrieves the name of this JDBC driver.");
            System.out.println(metaData.getDriverName());
            System.out.println("Retrieves whether this database stores tables in a local file.");
            System.out.println(metaData.usesLocalFiles());
            System.out.println(" Retrieves whether this database treats mixed case unquoted SQL identifiers as\n" +
                    "     * case sensitive and as a result stores them in mixed case.");
            System.out.println(metaData.supportsMixedCaseIdentifiers());
            System.out.println("Retrieves the string used to quote SQL identifiers.\n" +
                    "     * This method returns a space \" \" if identifier quoting is not supported.");
            System.out.println(metaData.getIdentifierQuoteString());
            System.out.println(" Retrieves a comma-separated list of all of this database's SQL keywords\n" +
                    "     * that are NOT also SQL:2003 keywords.");
            System.out.println(metaData.getSQLKeywords());
            System.out.println("Retrieves a comma-separated list of math functions available with\n" +
                    "     * this database.  These are the Open /Open CLI math function names used in\n" +
                    "     * the JDBC function escape clause.");
            System.out.println(metaData.getNumericFunctions());
            System.out.println("Retrieves a comma-separated list of string functions available with\n" +
                    "     * this database.  These are the  Open Group CLI string function names used\n" +
                    "     * in the JDBC function escape clause.");
            System.out.println(metaData.getStringFunctions());
            System.out.println("* Retrieves a comma-separated list of system functions available with\n" +
                    "     * this database.  These are the  Open Group CLI system function names used\n" +
                    "     * in the JDBC function escape clause.");
            System.out.println(metaData.getSystemFunctions());
            System.out.println("* Retrieves the string that can be used to escape wildcard characters.\n" +
                    "     * This is the string that can be used to escape '_' or '%' in\n" +
                    "     * the catalog search parameters that are a pattern (and therefore use one\n" +
                    "     * of the wildcard characters).");
            System.out.println(metaData.getSearchStringEscape());
            System.out.println("Retrieves the database vendor's preferred term for \"schema\".");
            System.out.println(metaData.getSchemaTerm());
            while (resultSet.next())
                System.out.println("id:" + resultSet.getInt(1) + " Name:" + resultSet.getString(2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
