package GFG_Maven.GFG_Maven;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Batchbonusaddition {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(0));
		
		driver.manage().window().maximize();
		driver.get("https://dev-admin.machetalk.jp/dashboard/present_days.html");
		
		adminLogin adminLogin = new adminLogin();
		adminLogin.AdminLogin(driver);
		
		//first layer tab list
//		String[] firstLayerTab = {"ログ・履歴"};
//		
		//second layer tab list
		String[] secondLayerTab = {"配信ログ"};
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tab[data-show='macherie']")));
		driver.findElement(By.cssSelector(".tab[data-show='macherie']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#navMenu-logrireki")).click();
	
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//span[@class='navMenu-subLabel'][contains(text(),'視聴者管理')])[1]")).click();
		checkRelationship(driver,secondLayerTab);
		
		Thread.sleep(2000);
//		viewerRegistration(driver,thirdLayerTab);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//a[@href='/talk_broadcast_log/add_bonus_star_csv.html']")));		
		driver.findElement(By.xpath("//a[@href='/talk_broadcast_log/add_bonus_star_csv.html']")).click();
		
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='input-group input-group-sm']")).click();
		
		
		//Putting all the absolute paths of the pics to upload(here, 3 files)
		String arr[] = {"C:\\Users\\fdcar\\OneDrive\\Desktop\\MT-2075\\2000_rows.csv"};

		//Copying the path of the file to the clipboard     
		StringSelection photo = new StringSelection(arr[0]); //Putting the path of the image to upload
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
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-upload']")));
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-upload']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-success btn-sm btn-add']")));
		driver.findElement(By.xpath("//button[@class='btn btn-success btn-sm btn-add']")).click();
		
	}
	
	//Second layer tab
	public static void checkRelationship(WebDriver driver,String[] secondLayerTab) {
		int j=0;
		List<WebElement> secondLayerTab1 = driver.findElements(By.xpath("//ul[@class='navMenu-subMenu']/li/span[@class='navMenu-subLabel']"));
		for(int i=0; i<secondLayerTab1.size(); i++) {
			String secondLayerList = secondLayerTab1.get(i).getText();
			
			List <String> secondLayerTab2 = Arrays.asList(secondLayerTab);
			if(secondLayerTab2.contains(secondLayerList)) {
				j++;
				driver.findElements(By.xpath("//ul[@class='navMenu-subMenu']/li/span[@class='navMenu-subLabel']")).get(i).click();
				if(j == secondLayerTab.length) {
					break;
				}
			}
		}
	}
}
