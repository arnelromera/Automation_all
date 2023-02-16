import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// one way
		// maximize window
		driver.manage().window().maximize();

		// retrive url
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		
		 //start of the distination // from button
		 driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); 
		 driver.findElement(By.xpath("//a[@value='BLR']")).click();
		 
		 //waiting time to stable the page 
		 Thread.sleep(2000);
		 
		 //to button 
		 driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		 //end of the distination
		 
		 Thread.sleep(2000); 
		 //Calendar Selected
		 driver.findElement(By.className("ui-datepicker-today")).click();
		 
		 // checking if the return date is enabled
		 if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
		 System.out.println("is disabled"); Assert.assertTrue(true); } else {
		 Assert.assertTrue(false); }
		  
		 //PASSENGER LIST // start of the passendger script
		 driver.findElement(By.id("divpaxinfo")).click();
		 
		 //waiting time for the page to stable 
		 Thread.sleep(1000);
		 
		 // for loop 
		 for(int i=1; i<5; i++) {
			 driver.findElement(By.id("hrefIncAdt")).click(); 
		 }
		 
		 driver.findElement(By.id("btnclosepaxoption")).click();
		 System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); 
		 //end of the passendger script
		  
		 // Start of CURRENCY 
		 WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		  
		 //Static dropdowns 
		 Select dropdown = new Select(staticDropdown);
		 
		 //select by index 
		 dropdown.selectByIndex(3);
		 System.out.println(dropdown.getFirstSelectedOption().getText()); 
		 // end of curreny
		  
		 //Search button
		 driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click(); 
		 //end of one way Thread.sleep(2000);
		 

		// start of round trip
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

		// start of the distination
		// from button
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DED']")).click();

		// waiting time to stable the page
		Thread.sleep(2000);

		// to button
		driver.findElement(By.xpath("(//a[@value='PNQ'])[2]")).click();
		// end of the distination

		Thread.sleep(2000);
		// Calendar Selected
		driver.findElement(By.className("ui-datepicker-today")).click();

		// checking if the return date is enabled
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		Thread.sleep(1000);
		driver.findElement(By.linkText("25")).click();

		// PASSENGER LIST
		// start of the passendger script
		driver.findElement(By.id("divpaxinfo")).click();

		// waiting time for the page to stable
		Thread.sleep(1000);

		// for loop
		// Adult
		for (int i = 1; i < 2; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		// Child
		for (int i = 1; i < 3; i++) {
			driver.findElement(By.id("hrefIncChd")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		// end of the passendger script

		// CURRENCY
		WebElement staticDropdown1 = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		  
		//Static dropdowns 
		Select dropdown1 = new Select(staticDropdown1);
		 
		//select by index 
		dropdown1.selectByValue("USD");
		System.out.println(dropdown1.getFirstSelectedOption().getText()); 
		// end of curreny
		  
		//Search button
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click(); 
		// end of round trip
		
		Thread.sleep(2000);

	}

}
