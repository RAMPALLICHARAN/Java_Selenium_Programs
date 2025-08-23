package Sample_Day24_DataProviderProgram;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderExcel {
	
	@DataProvider(name="credentials")
	
	public String[][] getData() throws IOException{
		
		File loginCredentialsFile = new File("C:\\Users\\91830\\Downloads\\Sample_Data.xlsx");
		System.out.println(loginCredentialsFile.exists());

		FileInputStream fis = new FileInputStream(loginCredentialsFile);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1"); // by name
//		XSSFSheet sheet = workbook.getSheetAt(0);  by index

		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfCols = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[noOfRows-1][noOfCols];
		for(int i = 0;i< noOfRows-1;i++) {
			for(int j = 0;j < noOfCols;j++) {
				DataFormatter dFormatter = new DataFormatter();
				data[i][j] = dFormatter.formatCellValue(sheet.getRow(i+1).getCell(j));
				System.out.println("Email & Password: "+data[i][j]);
			}
		}
		workbook.close();
		fis.close();
		return data;
	
}
}
	
	
	
	
	
	
	
	
	
