package org.utnfrd.chat.swing;

import org.utnfrd.model.User;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.LinkedList;

public class UserTableModel extends AbstractTableModel {

    private ArrayList<User> list = new ArrayList<User>();

    String[] columnNames = {"Protocol", "Contact"};

    private LinkedList datos = new LinkedList();

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public void setValueAt( Object v, int r, int c )  {
        fireTableCellUpdated( r, c );
    }

    @Override
    public String getColumnName( int c ) {
        return columnNames[c];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        //all cells false
        return true;
    }

}
