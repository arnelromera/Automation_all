import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

		public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		addItems(driver,itemsNeeded);
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),\"PROCEED TO CHECKOUT\")]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("arnelromera");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		
		}
	
	

		public static  void addItems(WebDriver driver,String[] itemsNeeded)
		{
		int j=0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++)
			{
			//Brocolli - 1 Kg
			//Brocolli,    1 kg
	
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
	
			//format it to get actual vegetable name
			//convert array into array list for easy search
			//check whether name you extracted is present in arrayList or not-
	
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			if(itemsNeededList.contains(formattedName))
				{
				j++;

				//click on Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
					if(j == itemsNeeded.length)
						{
						break;
						}
				}
			}
		}	
}
