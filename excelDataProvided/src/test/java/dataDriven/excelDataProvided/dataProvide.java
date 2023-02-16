package dataDriven.excelDataProvided;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataProvide {
		
	DataFormatter format = new DataFormatter();
	//multiple sets of data to our tests
	//array
	//5sets of data as 5 arrays from data provider to  your tests
	//then your test will run 5 times with 5 separate sets of data(arrays)
	
	@DataProvider(name="driveTest")
	public Object[][] getData() throws IOException {		
		FileInputStream fis = new FileInputStream("C://Users//fdcar//Downloads//Automatio//ExcelFiles//testtest.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		
		XSSFSheet sheets =	workBook.getSheetAt(0);
		int rowCount = sheets.getPhysicalNumberOfRows();
		XSSFRow row = sheets.getRow(0);
		int colCount = row.getLastCellNum();
		
		Object data[][] = new Object[rowCount-1][colCount];
		for(int i=0; i<rowCount-1; i++)
		{
			row = sheets.getRow(i+1);
			for(int j=0; j<colCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i][j] = format.formatCellValue(cell);
			}
		}
		return data;
	}

	@Test(dataProvider="driveTest")
	public void testCaseData(String URL, String USERNAME, String PASSWORD, String ROOMNAME, String USERNAME_LIVE, String CategoryName, String gift_Name, String gift_Count, String Viewing_time) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--use-fake-ui-for-media-stream=10");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.get(URL);
		System.out.println("The " + URL + " is entered");
		
		//login button
		WebElement loginButton = driver.findElement(By.className("login"));
		String loginButtonText = loginButton.getText();
		loginButton.click();
		System.out.println("The " + loginButtonText + " button is clicked");
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("login_mail")));
		
		//Username
		driver.findElement(By.name("login_mail")).sendKeys(USERNAME);
		System.out.println("The " + USERNAME + " username is entered");
		
		//password
		driver.findElement(By.name("login_password")).sendKeys(PASSWORD);
		System.out.println("The " + PASSWORD + " password is enetered");
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn_style btn_green']")));
		
		//login button
		WebElement loginButton1 = driver.findElement(By.xpath("//button[@class='btn_style btn_green']"));
		String loginButton1Text = loginButton1.getText();
		loginButton1.click();
		System.out.println("The " + loginButton1Text + " button is clicked");
		
		Thread.sleep(3000);
		Bonus("dailybonus", driver);
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='button size_m']")));
		
		//open broadcast button
		WebElement openBroadcast = driver.findElement(By.xpath("//a[@class='button size_m']"));
		String openBroadcastText = openBroadcast.getText();
		openBroadcast.click();
		System.out.println("The " + openBroadcastText + " button is clicked");
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("count_text")));
			
		//Room name
		driver.findElement(By.id("count_text")).sendKeys(ROOMNAME);
		System.out.println("The " + ROOMNAME + " room name is enetered");
		
		//Open broadcast tag
		driver.findElement(By.xpath("//ul/li[2]")).click();
		System.out.println("The open broadcast tag is clicked");
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn_style")));
		
		//continue open broadcast button
		WebElement continueOpenBroadcast = driver.findElement(By.cssSelector("button.btn_style"));
		String continueOpenBroadcastText = continueOpenBroadcast.getText();
		continueOpenBroadcast.click();
		System.out.println("The " + continueOpenBroadcastText + " button is clicked");
		
		Thread.sleep(5000);
		
		//Start open broadcast
		WebElement startOpenBroadcast = driver.findElement(By.cssSelector("button.button_open"));
		String startOpenBroadcastText = startOpenBroadcast.getText();
		startOpenBroadcast.click();
		System.out.println("The " + startOpenBroadcastText + " button is clicked");
		
		Thread.sleep(10000);
		
		WebElement sound = driver.findElement(By.id("btn-sound_own"));
		WebElement video = driver.findElement(By.id("btn-invite"));
		//Instantiating Actions class
		Actions actions = new Actions(driver);
		
		//mic
		actions.moveToElement(sound).click().build().perform();
		System.out.println("The mic icon is clicked");
		
		//Request 2 shots button
		actions.moveToElement(video).click().build().perform();
		System.out.println("The request 2 shots button is clicked");

		Thread.sleep(2000);
		
		// Start of joining to ang open broadcast
		WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
		
		// below code will navigate you to your desirable Url 
		driver.get("https://dev-front.machetalk.jp/");
		System.out.println("The https://dev-front.machetalk.jp is entered`");

		String[] roomName = {ROOMNAME};
		String[] giftCategoryName = {CategoryName};
		String[] giftName = {gift_Name};
		String giftCount = gift_Count;
		
		// login button
		WebElement viewerLoginButton = driver.findElement(By.cssSelector(".button_login.btn_style.btn_green-o"));
		String viewerLoginButtonText = viewerLoginButton.getText();
		viewerLoginButton.click();
		System.out.println("The "+ viewerLoginButtonText + "button is clicked");
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("login_mail")));
		
		//veiwer username
		driver.findElement(By.name("login_mail")).sendKeys(USERNAME_LIVE);
		System.out.println("The " + USERNAME_LIVE + " username is enetered");
		
		//viewer password
		driver.findElement(By.name("login_password")).sendKeys(PASSWORD);
		System.out.println("The " + PASSWORD + " password is enetered");

		//continue login button
		WebElement viewerContinueLoginButton = driver.findElement(By.xpath("//button[@class='btn_style btn_green']"));
		String viewerContinueLoginButtonText = viewerContinueLoginButton.getText();
		viewerContinueLoginButton.click();
		System.out.println("The " + viewerContinueLoginButtonText + " button is clicked");
		
		Thread.sleep(5000);
		
		//daily login bunos
		Bonus("dailybonus",driver);

		Thread.sleep(15000);
		//join broadcast
			try {
				joinBroadcast(roomName, driver);
			}
			catch(Exception e) {
				e.printStackTrace();
				 System.out.println("Error when the user tries to join to a broadcast. Please check the cridentials/Element");
				 driver.quit();
			}
		
		Thread.sleep(5000);
		//Switch to child window
		Set<String> windows = newTab.getWindowHandles(); //[parentid,childid,subchildId]
		Iterator<String>it = windows.iterator();
			while(it.hasNext()) {
				driver.switchTo().window(it.next());
			}

		Thread.sleep(15000);
		
		
		//select category tab
		categoryList(driver,giftCategoryName);
		
		//select gift
		Thread.sleep(5000);
		
//				addGift(driver,gift_Name, giftCount);
			
		addGift(driver, giftName, giftCount);
		
		int viewingtime = Integer.parseInt(Viewing_time);
		Thread.sleep(viewingtime);
		System.out.println("The viewing is completed");
		
		driver.quit();
	}

	public void Bonus(String act,WebDriver driver) throws InterruptedException
	{		
		switch (act) {
		case "dailybonus" :
			try {
				boolean doGetBonusPresence = driver.findElement(By.id("doGetBonus")).isDisplayed();
				boolean doGetBonusEnabled = driver.findElement(By.id("doGetBonus")).isDisplayed();
				if(doGetBonusPresence == true && doGetBonusEnabled == true)	
				{
					//daily login bunos modal
					System.out.println("The daily login modal bonus is displayed");
					WebElement claimBunos = driver.findElement(By.id("doGetBonus"));
					String claimBunosText = claimBunos.getText();
					claimBunos.click();
					System.out.println("The " + claimBunosText + " button is clicked");
					
					Thread.sleep(5000);
					
					//get modal bonus
					System.out.println("The daily login get modal bonus is displayed");
					WebElement getModalBonus = driver.findElement(By.cssSelector(".btn_style.btn_green.modal_close"));	
					String getModalBonusText = getModalBonus.getText();
					getModalBonus.click();
					System.out.println("The " + getModalBonusText + " button is clicked");
				}
			}
			catch(Exception e){
				
				System.out.println("The get bonus modal is not displayed.");
			}
			break;
			
		  default :
			  break;
		}
	}
	//join brooadcast method
	public  void joinBroadcast(String[] roomName,  WebDriver driver) {
			int j=0;
			List<WebElement> broadcast = driver.findElements(By.xpath("//div[@class='room']"));
			
			for(int i=0; i<broadcast.size(); i++) {
				
				String broadcastlist = broadcast.get(i).getText();
				
				List<String> itemsNeededList = Arrays.asList(roomName);
				
					if(itemsNeededList.contains(broadcastlist)) 
					{
						j++;
						driver.findElements(By.xpath("//div[@class='liver ng-scope']")).get(i).click();
						System.out.println("The user join to "+ broadcastlist + " broadcast");
						
						if(j == roomName.length) {
							break;
						}
					}
			}
			
		}

		//category tab method
	public  void categoryList(WebDriver driver,String[] giftCategoryName) {
			int j=0;
			List<WebElement> categoryName = driver.findElements(By.cssSelector(".swiper-slide"));
			
			for(int i=0; i<categoryName.size(); i++) {
				
				String categorylist = categoryName.get(i).getText();
				
				List<String> giftCategoryNameList = Arrays.asList(giftCategoryName);
				
					if(giftCategoryNameList.contains(categorylist)) 
					{
						j++;
						driver.findElements(By.cssSelector(".swiper-slide")).get(i).click();
						System.out.println("The " + categorylist + " category is clicked");
						if(j == giftCategoryName.length) {
							break;
						}
					}
					else
					{
						WebElement category = driver.findElement(By.xpath("//div[@class='swiper-button-next']"));
						Actions actions = new Actions(driver);
						
						//Hovering on main menu
						actions.moveToElement(category).perform();
						System.out.println("The next button is clicked");
					}
			}
			
		}
		
		//gifting method
	public  void addGift(WebDriver driver,String[] giftName, String giftCount) {
			
			int j=0;
			List<WebElement> giftNameElement = driver.findElements(By.xpath("//div[@class='list-item ng-scope']/p"));
			
			for(int i=0; i<giftNameElement.size(); i++) {
				
				String giftNameList = giftNameElement.get(i).getText();
				
				List<String> giftasdfNameList = Arrays.asList(giftName);
				
					if(giftasdfNameList.contains(giftNameList)) 
					{
						j++;
						WebElement a = driver.findElements(By.xpath("//div[@class='list-item ng-scope']")).get(i);
						int giftCounValue = Integer.parseInt(giftCount);
						System.out.println("The " + giftNameList + " gift is clicked");
						for(int i1=0; i1<giftCounValue; i1++) {
							a.click();
						}
						if(j == giftName.length) {
							break;
						}
					}		
			}
		}
}
