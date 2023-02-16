import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//maximize window
		driver.manage().window().maximize();
		
		//retrive url
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Static Dropdown
		// CURRENCY
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		//Static dropdowns
		Select dropdown = new Select(staticDropdown);
		
		//select by index
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//select by visible text
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//select by option value
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		
		
		//PASSENGER LIST
		// start of the passendger script
		driver.findElement(By.id("divpaxinfo")).click();
		
		//waiting time for the page to stable
		Thread.sleep(1000);
		
		// register an adult more than 1 but less than 5
		// while loop
		/*
		 * int i = 1; while(i<5) { driver.findElement(By.id("hrefIncAdt")).click(); i++;
		 * }
		 */
		
		// for loop
		for(int i=1; i<5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		//end of the passendger script
	
		
		
		//Dynamic Dropdowns
		//start of the distination
		
		// from button
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		//waiting time to stable the page
		Thread.sleep(2000);
		
		//to button
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		//end of the distination
		
		// Parent-Child relationship locator to Identify the objects Uniquely
			// - //div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']
			// - //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA'] 
			
		
		
		// Handling AutoSuggestive dropdowns using Selenium
		driver.findElement(By.id("autosuggest")).sendKeys("chi");
		
		Thread.sleep(3000);
		
		//Scan all the list of suggested list
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(WebElement option :options)
			{
			if(option.getText().equalsIgnoreCase("Taiwan, Province of China"))
				{
				option.click();
				break;
				}	
			}
		
	}

}
