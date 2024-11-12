package com.ea.framework.utils;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class ExcelUtils {

    static Workbook workbook = null;
    static Sheet worksheet;
    static Hashtable dic = new Hashtable();

    public ExcelUtils(String path) throws BiffException, IOException {
        workbook = Workbook.getWorkbook(new File(path));
        worksheet = workbook.getSheet("Sheet1");
        columnDirectory();
    }

    public static int RowCount() {
        return worksheet.getRows();
    }

    private static String readCell(int column, int row) {
        return worksheet.getCell(column, row).getContents();
    }

    private static void columnDirectory() {
        for (int col = 0; col < worksheet.getColumns(); col++) {
            dic.put(readCell(col, 0), col);
        }
    }

    public static String readCell(String columnName, int row) {
        return readCell(getData(columnName), row);
    }

    private static int getData(String colName) {
        {
            try {
                int value;
                value = ((Integer) dic.get(colName)).intValue();
                return value;
            } catch (NullPointerException e) {
                return (0);
            }
        }
    }
}
