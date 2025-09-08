package Nopcommerce;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    // Read cell data
    public String getCellData(String excelPath, String sheetName, int rowNum, int colNum) throws IOException {
        try (FileInputStream fis = new FileInputStream(excelPath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) return null;

            Row row = sheet.getRow(rowNum);
            if (row == null) return null;

            Cell cell = row.getCell(colNum);
            if (cell == null) return null;

            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell).trim();
        }
    }

    // Overwrite data in row 1 (second row)
    public void overwriteData(String excelPath, String sheetName, String email, String password) throws IOException {
        try (FileInputStream fis = new FileInputStream(excelPath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                sheet = workbook.createSheet(sheetName);
            }

            Row row = sheet.getRow(1);
            if (row == null) {
                row = sheet.createRow(1);
            }

            row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(email);
            row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(password);

            try (FileOutputStream fos = new FileOutputStream(excelPath)) {
                workbook.write(fos);
            }
        }
    }
}
