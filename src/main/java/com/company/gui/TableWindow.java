package com.company.gui;

import com.company.model.EntityAbstract;
import com.company.model.table.CustomerDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TableWindow extends JDialog {
    private final String[] headers;
    private final String tableName;
    private JTable table;
    private final DefaultTableModel tableModel;
    private JScrollPane jScrollPane;
    private final static int ROW_COUNT = 0;

    public TableWindow(String tableName, String[] headers) {
        this.setSize(300, 300);
        this.tableName = tableName;
        this.headers = headers;
        this.tableModel = new DefaultTableModel(headers, ROW_COUNT);
        initWindow();
    }

    private void initWindow() {
        this.setTitle("Table: " + tableName);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                setVisible(false);
            }
        });
        initTable();
        initButtons();
        setResizable(true);
        pack();
    }

    private void initButtons() {
        JButton button = new JButton("load");
        button.addActionListener(x -> loadDataToTable());
        this.add(button, BorderLayout.PAGE_END);

        button.setVisible(true);
    }

    private void initTable() {
        this.table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.table.setVisible(true);
        this.jScrollPane = new JScrollPane(table);
        this.jScrollPane.setVisible(true);
        this.add(jScrollPane);
    }

    private void loadDataToTable() {
        EntityAbstract[] entities = new CustomerDAO().getAll().toArray(new EntityAbstract[0]);
        clearDataFromTable();
        for (EntityAbstract entityAbstract : entities) {
            addRow(entityAbstract.getFieldValuesAsStringArray());
        }
        System.out.println();
    }

    private void clearDataFromTable() {
        if (tableModel.getRowCount() > 0) {
            for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
                deleteRow(i);
            }
        }
    }

    private void deleteRow(int rowId) {
        tableModel.removeRow(rowId);
    }

    private void addRow(String[] values) {
        tableModel.addRow(values);
    }


    public String[] getHeaders() {
        return headers;
    }
}
