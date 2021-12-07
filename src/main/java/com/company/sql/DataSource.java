package com.company.sql;

import java.sql.*;
import java.util.ArrayList;

import com.company.model.Customer;
import com.company.model.table.CustomerDAO;

public class DataSource {

    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/somedb";
    private static Connection connection = null;

    public DataSource() {

    }

    public static Connection getConnection() {
        if (connection == null) {
            tryConnect();
        }
        return connection;
    }

    public static void tryConnect() {
        System.out.println("Trying to connect...");

        try {
            connection = DriverManager.getConnection(CONNECTION_URL, "root", "example");
            System.out.println("Connected!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
