package com.company;

import javax.swing.table.AbstractTableModel;

public class ConsultationTableModel extends AbstractTableModel {

    String[] columnNames = {"Patient's Name", "Date and Time", "Cost", "Consult time", "Booked Doctor"};

    @Override
    public int getRowCount() {
        return Main.consultations.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;

        if (columnIndex == 0) {
            temp = Main.patientLists.get(rowIndex).getFirstName() + " " + Main.patientLists.get(rowIndex).getLastName();

        } else if (columnIndex == 1) {
            temp = Main.consultations.get(rowIndex).getDate() + "         " + Main.consultations.get(rowIndex).getTime();

        } else if (columnIndex == 2) {
            temp = Main.consultations.get(rowIndex).getCost();

        } else if (columnIndex == 3) {
            temp = Main.consultations.get(rowIndex).getConsultTime();

        } else if (columnIndex == 4) {
            temp = Main.consultations.get(rowIndex).getBookedDoctor();

        }
        return temp;
    }

    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
}


