import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
//		driver.switchTo().frame(1);
//		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//instruction to enter to the frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
//		driver.findElement(By.id("draggable")).click();
		
		//scroll to the specific element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("draggable")));
		
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		
		// instruction to get out to the frame
		driver.switchTo().defaultContent();
		
		driver.findElement(By.cssSelector("a[href='http://jqueryui.com/sortable/']")).click();
	}

}
