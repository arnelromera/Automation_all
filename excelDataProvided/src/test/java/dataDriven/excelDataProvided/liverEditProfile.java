package dataDriven.excelDataProvided;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class liverEditProfile {
	
	DataFormatter format = new DataFormatter();
	@DataProvider(name="driveTest")
	public Object[][] getData() throws IOException {		
		FileInputStream fis = new FileInputStream("C://Users//fdcar//Downloads//Automatio//ExcelFiles//LiverEditProfile.xlsx");
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
	public void testCaseData(String URL, String USERNAME, String PASSWORD, String charm, 
			String nickName, String ageValue, String residenceValue, String areaValue, 
			String performer_jobValue, String heightValue, String bodyTypeValue,
			String personalityValue, String hobby1, String hobby2, String hobby3, String activeTimeValue,
			String selfInroductionValue) throws InterruptedException
	{	
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--use-fake-ui-for-media-stream=10");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(10));
		
		String [] hobbyValue = {hobby1, hobby2, hobby3};
		
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
		
		Thread.sleep(3000);

		//click the edit profile button
		WebElement プロフィール編集 =  driver.findElement(By.xpath("//a[contains(.,'プロフィール編集')]"));
		String プロフィール編集Text = プロフィール編集.getText();
		System.out.println("The " + プロフィール編集Text + " is clicked");
		プロフィール編集.click();
		
		Thread.sleep(3000);
		//nickname
		WebElement nickNameField = driver.findElement(By.xpath("//input[@class='mail nickname_count']"));
		nickNameField.sendKeys(Keys.CONTROL + "a");
		nickNameField.sendKeys(Keys.DELETE);
		nickNameField.sendKeys(nickName);
		System.out.println("The " + nickName + " text is entered");
		
		//charm
		WebElement charmField = driver.findElement(By.xpath("//input[@class='charm_point charm_point_count']"));
		charmField.sendKeys(Keys.CONTROL + "a");
		charmField.sendKeys(Keys.DELETE);
		charmField.sendKeys(charm);
		System.out.println("The " + charm + " text is entered");
		
		//age
		WebElement age = driver.findElement(By.xpath("//select[@name='age']"));
		Select ageDropdown = new Select(age);
		ageDropdown.selectByVisibleText(ageValue);
		System.out.println("The " + ageValue + " is selected");
		
		// select residence
		WebElement residence = driver.findElement(By.xpath("//select[@id='residence']"));
		Select residenceDropdown = new Select(residence);
		residenceDropdown.selectByVisibleText(residenceValue);
		System.out.println("The " + residenceValue + " is selected");
		
		Thread.sleep(3000);
		
		// select area
		WebElement area = driver.findElement(By.xpath("//select[@id='area']"));
		Select areaDropdown = new Select(area);
		areaDropdown.selectByVisibleText(areaValue);
		System.out.println("The " + areaValue + " is selected");
		
		// select performer_job
		WebElement performer_job = driver.findElement(By.xpath("//select[@name='performer_job']"));
		Select performerJobDropdown = new Select(performer_job);
		performerJobDropdown.selectByVisibleText(performer_jobValue);
		System.out.println("The " + performer_jobValue + " is selected");
		
		// select height
		WebElement height = driver.findElement(By.xpath("//select[@name='height']"));
		Select heightDropdown = new Select(height);
		heightDropdown.selectByVisibleText(heightValue);
		System.out.println("The " + heightValue + " is selected");
		
		// select body type
		WebElement body_type = driver.findElement(By.xpath("//select[@name='body_type']"));
		Select body_typeDropdown = new Select(body_type);
		body_typeDropdown.selectByVisibleText(bodyTypeValue);
		System.out.println("The " + bodyTypeValue + " is selected");
		
		// select body type
		WebElement personality = driver.findElement(By.xpath("//select[@name='personality']"));
		Select personalityDropdown = new Select(personality);
		personalityDropdown.selectByVisibleText(personalityValue);
		System.out.println("The " + personalityValue + " is selected");
		
		// Select hobbies
		List <WebElement> hobby = driver.findElements(By.xpath("//div[@class='checkbox']/label"));
		int j=0;
		for(int i=0; i<hobby.size(); i++){
			String hobbyList = hobby.get(i).getText();
			List<String> hobbies = Arrays.asList(hobbyValue);
			if(hobbies.contains(hobbyList)) {
				j++;
				hobby.get(i).click();
				if(j == hobbyValue.length) {
					break;
				}
				System.out.println("The " + hobbyList + " is checked");
			}
		}
		
		// select active time
		WebElement active_time = driver.findElement(By.xpath("//select[@name='active_time']"));
		Select active_TimeDropdown = new Select(active_time);
		active_TimeDropdown.selectByVisibleText(activeTimeValue);
		System.out.println("The " + activeTimeValue + " is selected");
		
		// Enter self introduction
		WebElement self_introduction = driver.findElement(By.xpath("//textarea[@name='self_introduction']"));
		self_introduction.sendKeys(Keys.CONTROL + "a");
		self_introduction.sendKeys(Keys.DELETE);
		self_introduction.sendKeys(selfInroductionValue);
		System.out.println("The " + selfInroductionValue + " text is entered");
		
		//click the submit button
		WebElement button_submit = driver.findElement(By.xpath("//button[@id='btn_submit_profileUpdate']"));
		String buttonSubmitText = button_submit.getText();
		System.out.println("The " + buttonSubmitText + " text is entered");
		button_submit.click();
	
		System.out.println("The browser is closed");
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

}
