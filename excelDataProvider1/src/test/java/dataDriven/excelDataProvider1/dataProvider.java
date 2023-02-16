package dataDriven.excelDataProvider1;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
	DataFormatter format = new DataFormatter();
	
	@Test(dataProvider = "driveTest")
	public void testCaseData(String URL, String USERNAME, String PASSWORD) {
		System.out.println(URL + USERNAME + PASSWORD);
	}
	
	// multiple sets of data to our test
	// array
	// 5sets of data as 5 arrays from data provider to your tests
	// then your test will run 5 times with 5 separate sets of data(array)
	
	
	@DataProvider(name = "driveTest")
	public Object[][] getData() throws IOException {
		
//		Object[][] data = {{"URL", "UserName","Password"},{"URL", "UserName","Password"},{"URL", "UserName","Password"}};
		FileInputStream file = new FileInputStream("C://Users//fdcar//Downloads//Automatio//ExcelFiles//dataProvider.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		
		// get read of the sheet name
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();
		
		Object data[][] = new Object[rowCount-1][columnCount];
		
		for(int i=0; i<rowCount-1; i++)
		{
			row = sheet.getRow(i+1);
			for(int j=0; j<columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i][j] = format.formatCellValue(cell);
			}
		}
		return data;
	}
}
