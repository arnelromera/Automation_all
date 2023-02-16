import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	
	public ArrayList<String> getData(String testCaseName) throws IOException {
		
		ArrayList<String> a = new ArrayList<String>();
		
		//fileInputStream argument
		FileInputStream fis = new FileInputStream("C://Users//fdcar//Downloads//Automatio//ExcelFiles//excelDriven.xlsx");
		
		//access the excel file
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		//access the sheets of the excel files
		int sheets = workbook.getNumberOfSheets();
		for(int i = 0; i<sheets; i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("Testcase")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				//identify Testcase column by scanning the entire 1st row
				Iterator<Row> rows = sheet.iterator();
				
				// the next is use to move to the next rows
				Row firstrow = rows.next();
				
				Iterator<Cell> ce = firstrow.cellIterator();
				int k = 0;
				int column = 0;
				while(ce.hasNext()) {
					Cell value = ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("Testcase")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
			
				//once column is identified. then scan the testcase column to identify the Purchase
				while(rows.hasNext()) {
					Row r = rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						
						// after you grab purchase testcase row = pull all the data of that row and geed into test
						Iterator <Cell> cv = r.cellIterator();
						while(cv.hasNext()) {
							
							Cell c = cv.next();
							if(c.getCellType()==Cell.CELL_TYPE_STRING) {
								a.add(c.getStringCellValue());								
							}
							else{
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
					
				}
			}
		}
		return a;
	}
}
