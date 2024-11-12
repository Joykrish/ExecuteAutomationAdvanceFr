package com.ea.framework.utils;

import com.ea.framework.config.Settings;

import java.sql.*;

public class DatabaseUtils {

    public static Connection open(String connectionString,String userName,String Password) {
        try {
            Class.forName(Settings.SQLDriver);
            return DriverManager.getConnection(connectionString,userName,Password);
        } catch (Exception e) {
            return null;
        }


    }

    public void close() {

    }

    public static  void executeQuery(String query, Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Print column headers
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultSet.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();

            // Print each row of the result set
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
