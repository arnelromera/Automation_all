import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();	
		driver.get("https://the-internet.herokuapp.com/");
		
		//to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.cssSelector("a[href='/windows']")));
				
		driver.findElement(By.cssSelector("a[href='/windows']")).click();

		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String>it = windows.iterator();
		
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.xpath("//h3[normalize-space()='New Window']")).getText());
		
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.xpath("//h3[normalize-space()='Opening a new window']")).getText());

	}

}
