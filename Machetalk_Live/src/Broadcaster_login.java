import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class Broadcaster_login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		driver.get("https://dev-front.machetalk.jp/liver/");
		
		driver.findElement(By.className("login")).click();
		
		Bonus("login", driver);
		
		Thread.sleep(3000);
		Bonus("dailybonus", driver);
		
		
		Thread.sleep(2000);
		driver.close();

	}
	
	static void Bonus(String act, WebDriver driver) throws InterruptedException
	{
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	       .withTimeout(Duration.ofSeconds(30))
	       .pollingEvery(Duration.ofSeconds(5))
	       .ignoring(NoSuchElementException.class);
		
		switch (act) {
		case "dailybonus" :
			try {
				boolean doGetBonusPresence = driver.findElement(By.id("doGetBonus")).isDisplayed();
				boolean doGetBonusEnabled = driver.findElement(By.id("doGetBonus")).isDisplayed();
				if(doGetBonusPresence == true && doGetBonusEnabled == true)	
				{
					System.out.println("The daily login modal bonus is displayed");
					driver.findElement(By.id("doGetBonus")).click();
					Thread.sleep(5000);
					System.out.println("The daily login get modal bonus is displayed");
					driver.findElement(By.cssSelector(".btn_style.btn_green.modal_close")).click();			
				}
			}
			catch(Exception e){
				
				System.out.println("The get bonus modal is not displayed.");
			}
			break;
			
		case "register" :
			break;
			
		case "login" :
			WebElement doGetBonus = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			    	 if(driver.findElement(By.name("login_mail")).isEnabled())	
						{
			    		 return driver.findElement(By.name("login_mail"));
						}
			    	 else
			    	 {
			    		 return null;
			    	 }
			     }
			   });
			System.out.println("The login page is displayed");
			doGetBonus.sendKeys("debutandroid@gmail.com");
			driver.findElement(By.name("login_password")).sendKeys("admin");
			driver.findElement(By.xpath("//button[@class='btn_style btn_green']")).click();
			break;
		  default :
			  break;
		}
	}

}