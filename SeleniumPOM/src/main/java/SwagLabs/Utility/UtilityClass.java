package SwagLabs.Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


import SwagLabs.Base.BaseClass;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;




public class UtilityClass extends BaseClass {
	
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	


	// Code to read data from Excel file
	public String[][] getTableArray(String filePath, String sheetName) throws IOException {
        String[][] dataTable = null;
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();
        dataTable = new String[rowCount][columnCount];
        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < columnCount; j++) {
                Cell cell = row.getCell(j);
                if (cell == null) {
                    dataTable[i - 1][j] = "";
                } else {
                    dataTable[i - 1][j] = getCellValueAsString(cell);
                }
            }
        }
        workbook.close();
        fis.close();
        return dataTable;
    }

    private String getCellValueAsString(Cell cell) {
        Object result = null;
        switch (cell.getCellType()) {
            case STRING:
                result = cell.getStringCellValue();
                break;
            case NUMERIC:
                result = String.valueOf(cell.getNumericCellValue());
                break;
            case BOOLEAN:
                result = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                result = cell.getCellFormula();
                break;
            default:
                return "";
        }
         return result.toString();
    }
    
    
    
    
    
    			// Method to take a screenshot at the end of the test					
    public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
    
    
    
    
    
    
}