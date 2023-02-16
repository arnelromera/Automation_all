package dataDriven.excelDataProvider1;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataProvider1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
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
				System.out.println(column);
				
				while(rows.hasNext()) {
					Row r=rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("https://dev-front.machetalk.jp/liver/")) {
						Iterator<Cell> cv = r.cellIterator();
						while(cv.hasNext()) {
							System.out.println(cv.next().getStringCellValue());
						}
					}
				}
			}
			
		}

	}

}
