package com.ea.framework.utils;

import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CucumberUtils {

    // DataCollection class with getter methods
    private static class DataCollection {
        private String columnName;
        private String columnValue;
        private int rowNumber;

        public DataCollection(String columnName, String columnValue, int rowNumber) {
            this.columnName = columnName;
            this.columnValue = columnValue;
            this.rowNumber = rowNumber;
        }

        public String getColumnName() {
            return columnName;
        }

        public String getColumnValue() {
            return columnValue;
        }

        public int getRowNumber() {
            return rowNumber;
        }

        @Override
        public String toString() {
            return "DataCollection{" +
                    "columnName='" + columnName + '\'' +
                    ", columnValue='" + columnValue + '\'' +
                    ", rowNumber=" + rowNumber +
                    '}';
        }
    }

    // Using Map to store lists of DataCollection entries per column
    public static Map<String, List<DataCollection>> dataCollectionMap = new HashMap<>();

    public static Map<String, List<DataCollection>> convertDataTableToDictionary(DataTable table) {
        List<List<String>> data = table.asLists(String.class);
        int rowNumber = 1;

        // Iterate through each row (starting from 1 to skip headers)
        for (int i = 1; i < data.size(); i++) {
            List<String> col = data.get(i);

            // Loop through each column in the row
            for (int colIndex = 0; colIndex < col.size(); colIndex++) {
                String columnName = data.get(0).get(colIndex); // Get header as key
                String columnValue = col.get(colIndex);        // Get cell value

                DataCollection dataCollection = new DataCollection(columnName, columnValue, rowNumber);
                System.out.println("Data collections value: " + dataCollection);

                // Store each DataCollection in a list under its columnName
                dataCollectionMap
                        .computeIfAbsent(columnName, k -> new ArrayList<>())
                        .add(dataCollection);
            }
            rowNumber++;
        }
        return dataCollectionMap;
    }

    // Method to get cell value based on column name and row number
    public static String getCellValue(String columnName, int rowNumber) {
        List<DataCollection> collections = dataCollectionMap.get(columnName);

        if (collections != null) {
            for (DataCollection entry : collections) {
                if (entry.getRowNumber() == rowNumber) {
                    return entry.getColumnValue();
                }
            }
        }
        return "No data found";
    }
}
