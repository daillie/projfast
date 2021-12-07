package com.company.gui;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.company.sql.query.Query;

public class App extends JFrame {
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 768;
    private final Map<String, TableWindow> tablesMap = new HashMap<>();
    private final JPanel topPanel = new JPanel();


    public App() {
        super("Db view");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);

        this.add(topPanel, BorderLayout.PAGE_START);
        init();
        pack();
    }

    public void init() {

        getTableNames().forEach(x -> {
            tablesMap.put(x, new TableWindow(x, getTableHeaders(x)));
        });

        tablesMap.keySet().forEach(System.out::println);
        tablesMap.forEach(this::createButton);
        setResizable(false);
    }

    private void createButton(String buttonName, TableWindow tableWindow) {
        JButton button = new JButton(buttonName);
        topPanel.add(button);
        button.addActionListener(actionEvent -> {
            System.out.println("showing table : " + buttonName);
            tableWindow.setVisible(true);
        });
    }

    private String[] getTableHeaders(String tableName) {
        String[] headers = new Query().getDBColumns(tableName);
        System.out.println(Arrays.toString(headers));
        return headers;
    }

    private void loadTable(String tableName) {

    }

    private Queue<String> getTableNames() {
        Queue<String> tables;
        tables = new Query().getDBTableNames();
        return tables;
    }
}
