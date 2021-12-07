package com.company.sql.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.company.sql.DataSource;

public class Query {

    private final Connection conn;

    public Query() {
        conn = DataSource.getConnection();
    }

    public ResultSet createQuery(String query) {
        try {
            PreparedStatement ps = DataSource.getConnection().prepareStatement(query);
            return ps.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Queue<String> getDBTableNames() {
        Queue<String> tables = new LinkedList<>();

        try {
            ResultSet rs = conn.prepareStatement("show tables").executeQuery();
            while (rs.next()) {
                tables.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tables;
    }

    public String[] getDBColumns(String tableName) {
        ArrayList<String> columns = new ArrayList<>();
        try {
            ResultSet rs = conn.prepareStatement("describe " + tableName).executeQuery();
            while (rs.next()) {
                columns.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columns.toArray(new String[0]);
    }
}
