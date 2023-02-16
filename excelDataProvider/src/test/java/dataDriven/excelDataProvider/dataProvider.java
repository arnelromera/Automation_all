package dataDriven.excelDataProvider;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
	DataFormatter formatter = new DataFormatter();
	
	@Test(dataProvider="driveTest")
//	public void testCasteData(String url, String email, String password, String nickName) throws InterruptedException
//	{
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		
//		
//		
//		String url = "https://dev-front.machetalk.jp/liver/";
//		String email = "legendios@gmail.com";
//		String password = "admin";
//		String nickName = "legendios";
//		
//		
//		driver.manage().window().maximize(); // maximize window
//		driver.get(url); // get url
//		
//		driver.findElement(By.className("regist")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@name='register_mail']")).sendKeys(email);
//		driver.findElement(By.xpath("//input[@name='register_password']")).sendKeys(password);
//		driver.findElement(By.xpath("//input[@name='register_password_conf']")).sendKeys(password);
//		
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		
//		driver.findElement(By.name("register_nickname")).sendKeys(nickName);
//		driver.findElement(By.id("btnProfileImgUpdate")).click();
//		
//		Thread.sleep(5000);
//		daily login bunos
//		Open_Broadcast.Bonus("login",driver);
//		
//		Thread.sleep(5000);
//		//daily login bunos
//		Bonus("dailybonus",driver);
//		
//		driver.findElement(By.xpath("//a[contains(.,'プロフィール編集')]")).click();
//	}
		
	
	@DataProvider(name="driveTest")
	public Object[][] getData() throws IOException {
		FileInputStream fis = new FileInputStream("C://Users//fdcar//Downloads//Automatio//ExcelFiles//dataProvider.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		// get the sheet number.
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		// get the number of rows.
		int rowsCount = sheet.getPhysicalNumberOfRows();
		
		
		XSSFRow row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();	
		
		Object data[][] = new Object[rowsCount-1][columnCount];
		
		// get the rows
		for(int i=0; i<rowsCount-1; i++) {
			row = sheet.getRow(i+1);
			// get the columns
			for(int j=0; j<columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i][j]= formatter.formatCellValue(cell);
			}
		}
		return data;
	}
	static void Bonus(String act, WebDriver driver) throws InterruptedException
	{
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	       .withTimeout(Duration.ofSeconds(30))
	       .pollingEvery(Duration.ofSeconds(5))
	       .ignoring(NoSuchElementException.class);
		
		switch (act) {
		case "dailybonus" :
			try {
				boolean doGetBonusPresence = driver.findElement(By.id("doGetBonus")).isDisplayed();
				boolean doGetBonusEnabled = driver.findElement(By.id("doGetBonus")).isDisplayed();
				if(doGetBonusPresence == true && doGetBonusEnabled == true)	
				{
					System.out.println("The daily login modal bonus is displayed");
					driver.findElement(By.id("doGetBonus")).click();
					Thread.sleep(5000);
					System.out.println("The daily login get modal bonus is displayed");
					driver.findElement(By.cssSelector(".btn_style.btn_green.modal_close")).click();			
				}
			}
			catch(Exception e){
				
				System.out.println("The get bonus modal is not displayed.");
			}
			break;
		}
	}
	
}

	


