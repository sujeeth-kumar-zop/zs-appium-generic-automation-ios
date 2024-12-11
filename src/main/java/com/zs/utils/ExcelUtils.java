package com.zs.utils;

import com.zs.constants.Constants;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Class which contains function which interact with the Excel sheet which contains login credentials for different application
 */

public class ExcelUtils {
    private static Workbook workbook;
    private static Sheet sheet;

    /**
     * Loads the Excel file containing login details from the predefined path
     * ("src/main/resources/utils/login_details.xlsx") and reads its first sheet.
     * This method uses Apache POI to parse the Excel file. If any IO error occurs
     * (e.g., file not found or read error), an exception is caught, and its
     * stack trace is printed for debugging purposes.
     * @throws IOException If an error occurs while reading the Excel file.
     */

    public static void loadExcel() {
        try {
            File f = new File("src/main/resources/utils");
            File fs = new File(f, "login_details.xlsx");
            FileInputStream file = new FileInputStream(fs);
            workbook = WorkbookFactory.create(file);
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the username and password for a specified application from the loaded Excel sheet.
     * The method searches through the rows of the first sheet in the Excel file (loaded via the
     * "loadExcel" method), looking for a matching appName in the first column. If a match
     * is found, the corresponding username and password from the second and third columns are
     * returned in a string array. If no match is found, the method returns "null".
     *
     * @param appName The name of the application for which credentials are to be retrieved.
     * @return A string array containing the username and password for the specified application,
     *         or "null" if no matching application is found in the Excel sheet.
     */

    public static String[] getCredentialsForApp(String appName) {
        loadExcel();
        DataFormatter dataFormatter = new DataFormatter();
        for (Row row : sheet) {
            String appNameInExcel = dataFormatter.formatCellValue(row.getCell(0));
            String username = dataFormatter.formatCellValue(row.getCell(1));
            String password = dataFormatter.formatCellValue(row.getCell(2));

            if (appNameInExcel.equals(appName)) {
                return new String[]{username, password};
            }
        }
        return null;
    }
}
