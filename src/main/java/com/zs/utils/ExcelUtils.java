package com.zs.utils;

import com.zs.constants.Constants;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {


    private static Workbook workbook;
    private static Sheet sheet;
    public static void loadExcel(String loginDetailsPath) {
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

    public static String[] getCredentialsForApp(String appName) {

        loadExcel(Constants.LOGIN_DETAILS_PATH);
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
