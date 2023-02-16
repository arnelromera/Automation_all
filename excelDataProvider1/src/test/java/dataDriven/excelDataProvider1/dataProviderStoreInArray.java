package dataDriven.excelDataProvider1;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataProviderStoreInArray {

	public ArrayList<String> getData(String testcaseName) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		
		FileInputStream fis = new FileInputStream("C://Users//fdcar//Downloads//Automatio//ExcelFiles//broadcaster_login.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		
		int sheets = workBook.getNumberOfSheets();
		
		for(int i=0; i<sheets; i++) {
			if(workBook.getSheetName(i).equalsIgnoreCase("Sheet1"));
			{
				XSSFSheet sheet=workBook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> ce = firstRow.cellIterator();
				int k=0;
				int column=0;
				while(ce.hasNext()) {
					Cell value = ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("URL"))
					{
						column = k;
					}
					k++;
				}
				while(rows.hasNext()) {
					Row r=rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						Iterator<Cell> cv = r.cellIterator();
						while(cv.hasNext()) {
							Cell c = cv.next();
							if(c.getCellType() == Cell.CELL_TYPE_STRING) {
								a.add(c.getStringCellValue());
							}
							else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								;
							}
						}
					}
				}
			}
			
		}
		return a;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	}

}
