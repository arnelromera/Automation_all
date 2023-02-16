import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class tableGridInWebPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.className("tableFixHead")));
		
		
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		
		for(int i=0; i<values.size(); i++) {
			sum = sum + Integer.parseInt(values.get(i).getText());
		}
		
		System.out.println(sum);
		
		WebElement totalAmount = driver.findElement(By.cssSelector(".totalAmount"));
		int totalvalue = Integer.parseInt(totalAmount.getText().split(":")[1].trim());
		Assert.assertEquals(sum, totalvalue);
		
		if(sum == totalvalue) {
			System.out.println("Passed");
		}
	}

}
