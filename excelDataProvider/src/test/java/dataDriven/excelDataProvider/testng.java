package dataDriven.excelDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testng {

	@Test(dataProvider="driveTest")
	public void testCasteData(String greeting, String communication, int id)
	{
		System.out.println(greeting+communication+id);
		
	}
	
	
	@DataProvider(name="driveTest")
		public Object[][] getData() {
		Object[][] data = {{"hello","text","1"},{"bye","message","143"},{"solo","call","1123"}};
		return data;
	}
	
}
