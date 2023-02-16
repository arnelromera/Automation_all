import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class actionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		WebElement signin = driver.findElement(By.id("nav-link-accountList"));
		WebElement textbox = driver.findElement(By.id("twotabsearchtextbox"));
		
		Actions a = new Actions(driver);
		a.moveToElement(signin).contextClick().build().perform();
		a.moveToElement(textbox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
	}

}
