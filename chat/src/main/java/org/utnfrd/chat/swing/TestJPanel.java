package org.utnfrd.chat.swing;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;

public class TestJPanel extends JPanel {

    private MyModel model;
    private JTable table;

    public TestJPanel() {

        init();
        setVisible(true);
    }

    private void init() {

        table = new JTable(model = new MyModel());
        //setViewportView(table);

        JButton add = new JButton("add row");
        add.addActionListener(getAddListener());
        JButton remove = new JButton("remove row");
        remove.addActionListener(getRemoveListener());

//        JPanel p = new JPanel();
        this.add(add);
        this.add(remove);
        // this.add(p, BorderLayout.NORTH);

        table.setDragEnabled(false);


        //table.getColumnModel().getColumn(1).setWidth(20);


        JScrollPane jScrollPane = new JScrollPane(table);

        this.add(jScrollPane);


        model.addColumn("Protocol");
        model.addColumn("Contact");

        model.addRow();
        model.addRow();


        //table.setBounds(50,50,100,100);

        table.setShowGrid(false); // No muestra la grilla

        table.getColumnModel().getColumn(0).setWidth(20);

        table.getColumnModel().getColumn(0).setResizable(false);    // no de puede cambiar el tamanio de las columnas
        table.getColumnModel().getColumn(1).setResizable(false);    // no de puede cambiar el tamanio de las columnas

        table.setAutoCreateRowSorter(false);

        model.setValueAt("UDP",0,0);
        model.setValueAt("TCP",1,0);

        model.setValueAt("bb",0,1);
        model.setValueAt("cc",1,1);


        //table.getColumn(0).setWidth(20);
        table.getColumnModel().getColumn(0).setMaxWidth(100);
        table.getColumnModel().getColumn(1).setMaxWidth(270);



    }

    private ActionListener getRemoveColListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedColumn = table.getSelectedColumn();
                if (selectedColumn != -1) {
                    stopEditing();
                    model.removeColumn(selectedColumn);
                }
            }
        };
    }

    private ActionListener getAddColListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.addColumn("aaaaa");
            }
        };
    }

    private ActionListener getRemoveListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    stopEditing();
                    model.removeRow(selectedRow);
                }
            }

        };
    }

    private ActionListener getAddListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow();
            }
        };
    }

    private void stopEditing() {
        TableCellEditor cellEditor = table.getCellEditor();
        if (cellEditor != null) {
            cellEditor.stopCellEditing();
        }
    }

    public static void main(String... strings) {
        new TestJPanel();
    }

    private class RowData {

        private Map<Integer, Object> values = new HashMap<Integer, Object>();

        public Object getValueForCol(int columnIndex) {
            if (values.containsKey(columnIndex)) {
                return values.get(columnIndex);
            }
            return "aaa";
        }

        public void setValueForCol(Object aValue, int columnIndex) {
            values.put(columnIndex, aValue);
        }

    }

    private class ColData {

        private Map<Integer, Object> values = new HashMap<Integer, Object>();

        public Object getValueForCol(int columnIndex) {
            if (values.containsKey(columnIndex)) {
                return values.get(columnIndex);
            }
            return "bbb";
        }

        public void setValueForCol(Object aValue, int columnIndex) {
            values.put(columnIndex, aValue);
        }

    }

    private class MyModel extends AbstractTableModel {

        int colIndex = 0;
        private List<String> cols = new ArrayList<String>();
        private List<RowData> rows = new ArrayList<TestJPanel.RowData>();

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public String getColumnName(int column) {
            return cols.get(column).toString();
        }

        @Override
        public int getRowCount() {
            return rows.size();
        }

        public void addRow() {
            rows.add(new RowData());
            fireTableRowsInserted(rows.size(), rows.size());
        }

        public void removeRow(int selectedRow) {
            rows.remove(selectedRow);
            fireTableRowsDeleted(selectedRow, selectedRow);
        }

        public void removeColumn(int selectedColumn) {
            cols.remove(table.convertColumnIndexToModel(selectedColumn));
            fireTableStructureChanged();
        }

        public void addColumn(String value) {

            cols.add(value);
            fireTableStructureChanged();
        }

        @Override
        public int getColumnCount() {
            return cols.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            RowData rowData = rows.get(rowIndex);
            return rowData.getValueForCol(columnIndex);
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            RowData rowData = rows.get(rowIndex);
            rowData.setValueForCol(aValue, columnIndex);
            fireTableCellUpdated(rowIndex, columnIndex);
        }

    }

}