import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// maximize window
		driver.manage().window().maximize();

		String text = "arnel";
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();

		// ok button only
		// validate text present in the alert modal
		System.out.println(driver.switchTo().alert().getText());

		// switch context to alert
		driver.switchTo().alert().accept();

		// ok and cancel button
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("confirmbtn")).click();

		// validate text present in the alert modal
		System.out.println(driver.switchTo().alert().getText());

		// clicks the cancel butotn
		driver.switchTo().alert().dismiss();

	}

}
