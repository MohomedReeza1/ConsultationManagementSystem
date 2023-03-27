package com.company;

import javax.swing.table.AbstractTableModel;

public class DoctorTableModel extends AbstractTableModel  {

    String[] columnNames = {"Doctor's Name", "Medical ID", "Specialization"};

    @Override
    public int getRowCount() {
        return Main.doctorLists.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;


        if (columnIndex == 0) {
            temp = Main.doctorLists.get(rowIndex).getFirstName() + " " + Main.doctorLists.get(rowIndex).getLastName();

        } else if (columnIndex == 1) {
            temp = Main.doctorLists.get(rowIndex).getMedicalId();

        } else if (columnIndex == 2) {
            temp = Main.doctorLists.get(rowIndex).getSpecialization();

        }
        return temp;
    }

    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
}
