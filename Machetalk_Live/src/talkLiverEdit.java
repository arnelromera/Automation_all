import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class talkLiverEdit {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		driver.findElement(By.className("login")).click();
		
		// field value declaration
		String url = "https://dev-front.machetalk.jp/liver/";
		String email = "legendios@gmail.com";
		String password = "admin";
		String nickName = "legendios";
		String ageValue = "18歳";
		String residenceValue = "日本";
		String areaValue = "神奈川県";
		String performer_jobValue = "フリーター";
		String heightValue = "151 cm";
		String bodyTypeValue = "かなりスリム";
		String personalityValue = "女王様系";
		String [] hobbyValue = {"ゲーム","スポーツ","グルメ"};
		String activeTimeValue = "夜～深夜";
		String selfInroductionValue = "Test Test Test";
		
		driver.manage().window().maximize(); // maximize window
		driver.get(url); // get url
	
//		driver.findElement(By.className("login")).click();
	
		driver.findElement(By.className("regist")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='register_mail']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='register_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='register_password_conf']")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.name("register_nickname")).sendKeys(nickName);
		driver.findElement(By.id("btnProfileImgUpdate")).click();
		
//		Thread.sleep(5000);
		//daily login bunos
//		Open_Broadcast.Bonus("login",driver);
		
		
		Thread.sleep(5000);
		//daily login bunos
		Open_Broadcast.Bonus("dailybonus",driver);
		
		driver.findElement(By.xpath("//a[contains(.,'プロフィール編集')]")).click();
		
//		List<WebElement> fieldLabel = driver.findElements(By.xpath("//dl[@class='profile-item']"));
		

//		WebElement nickName = driver.findElement(By.xpath("//input[@class='mail nickname_count']"));

		//Upload a profile image
		WebElement cameraIcon = driver.findElement(By.xpath("//div[@id='camera_icon']"));
		
		//Code for clicking on the image button that brings up the window dialog box
		cameraIcon.click();

		//Putting all the absolute paths of the pics to upload(here, 3 files)
		String arr = "C:\\Users\\fdcar\\Downloads\\Image\\image1.jpg";

		//Copying the path of the file to the clipboard     
		StringSelection photo = new StringSelection(arr); //Putting the path of the image to upload
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(photo, null);

		//Pasting the contents of clipboard in the field "File name" of the Window Pop-up
		Thread.sleep(5000); //Some sleep time to detect the window popup
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		//To Click on the "Open" button to upload files
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
//		Thread.sleep(6000);
//		Actions crop = new Actions(driver);
//		WebElement cropTracker = driver.findElement(By.xpath("//body[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[1]"));
//		crop.clickAndHold(cropTracker).moveByOffset(30, 50).release().build().perform();
//		/*it will first click and Hold the cropTracker Element, after that it will move to the 
//		30px right side and 50px upward.*/
				
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[@id='save_crop']")).click();
		
		//charm
		WebElement charm = driver.findElement(By.xpath("//input[@class='charm_point charm_point_count']"));
		charm.sendKeys("automated test");
		
		// select age
		WebElement age = driver.findElement(By.xpath("//select[@name='age']"));
		Select ageDropdown = new Select(age);
		ageDropdown.selectByVisibleText(ageValue);
		
		// select residence
		WebElement residence = driver.findElement(By.xpath("//select[@id='residence']"));
		Select residenceDropdown = new Select(residence);
		residenceDropdown.selectByVisibleText(residenceValue);
		
		
		Thread.sleep(3000);
		
		// select area
		WebElement area = driver.findElement(By.xpath("//select[@id='area']"));
		Select areaDropdown = new Select(area);
		areaDropdown.selectByVisibleText(areaValue);
		
		
		// select performer_job
		WebElement performer_job = driver.findElement(By.xpath("//select[@name='performer_job']"));
		Select performerJobDropdown = new Select(performer_job);
		performerJobDropdown.selectByVisibleText(performer_jobValue);
		
		// select height
		WebElement height = driver.findElement(By.xpath("//select[@name='height']"));
		Select heightDropdown = new Select(height);
		heightDropdown.selectByVisibleText(heightValue);
		
		// select body type
		WebElement body_type = driver.findElement(By.xpath("//select[@name='body_type']"));
		Select body_typeDropdown = new Select(body_type);
		body_typeDropdown.selectByVisibleText(bodyTypeValue);
		
		// select body type
		WebElement personality = driver.findElement(By.xpath("//select[@name='personality']"));
		Select personalityDropdown = new Select(personality);
		personalityDropdown.selectByVisibleText(personalityValue);
		
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
			}
		}
		
		// select active time
		WebElement active_time = driver.findElement(By.xpath("//select[@name='active_time']"));
		Select active_TimeDropdown = new Select(active_time);
		active_TimeDropdown.selectByVisibleText(activeTimeValue);
		

		// Enter self introduction
		WebElement self_introduction = driver.findElement(By.xpath("//textarea[@name='self_introduction']"));
		self_introduction.sendKeys(selfInroductionValue);
		
		
		//click the submit button
		WebElement button_submit = driver.findElement(By.xpath("//button[@id='btn_submit_profileUpdate']"));
		button_submit.click();
		
		driver.close();
		
	}

}
