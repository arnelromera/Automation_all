import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignement8_AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//maximize window
		driver.manage().window().maximize();
		
		//retrive url
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		
		// Handling AutoSuggestive dropdowns using Selenium
		driver.findElement(By.id("autocomplete")).sendKeys("united");
		
		Thread.sleep(3000);
		
		String a = "United States Minor Outlying Islands";
		//Scan all the list of suggested list
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
		
		for(WebElement option :options)
			{
			if(option.getText().equalsIgnoreCase(a))
				{
				option.click();
				break;
				}	
			}
		
		
//		driver.findElement(By.id("autocomplete")).sendKeys("ind");
//
//	    Thread.sleep(2000);
//
//	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
//
//	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
//
//	   System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); 

	}

}
