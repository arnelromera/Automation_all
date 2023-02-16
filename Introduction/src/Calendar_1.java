import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// open the browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		// get the url of the website
		driver.get("https://www.path2usa.com/travel-companion/");
		
		//to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("form-field-travel_comp_date")));		
		Thread.sleep(2000);
		
		// click the date button
		driver.findElement(By.id("form-field-travel_comp_date")).click();
		
		// locate the specific date
		while(!driver.findElement(By.className("flatpickr-month")).getText().contains("May")) {
			driver.findElement(By.className("flatpickr-next-month")).click();
		}
		
		Thread.sleep(1000);
		
		// grab the common attribute and put it in a list
		List<WebElement> dayList = driver.findElements(By.className("flatpickr-day"));
		
		// initialize the size of the list
		int dayListCount = driver.findElements(By.className("flatpickr-day")).size();
		
		// loop to locate the specified date and grab the text
		for(int i=0; i<dayListCount; i++) {
			String dayText = dayList.get(i).getText();
			
			// validate the grab text is equal to the specific date and click the date
			if(dayText.equalsIgnoreCase("1")) {
				driver.findElements(By.className("flatpickr-day")).get(i).click();
				break;
			}
		}
	}
}
