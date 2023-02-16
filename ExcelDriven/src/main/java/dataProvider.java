import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class dataProvider {
	
	// multiple set of data to our tests
	// array public
	// 5 sets of data as 5 arrays from data provider to your tests
	// then your test will run 5 times separately
	
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
