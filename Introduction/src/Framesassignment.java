import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Framesassignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		
		//to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.linkText("Nested Frames")));
				
		driver.findElement(By.linkText("Nested Frames")).click();
		
		WebElement frameTop = driver.findElement(By.name("frame-top"));			
//		System.out.println(driver.findElements(By.tagName("frame")).size());
				
		driver.switchTo().frame(frameTop);
		WebElement frameLeft = driver.findElement(By.xpath("//frame[@name='frame-left']"));
		driver.switchTo().frame(frameLeft);
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frameTop);
		WebElement frameMiddle = driver.findElement(By.name("frame-middle"));
		driver.switchTo().frame(frameMiddle);
		System.out.println(driver.findElement(By.id("content")).getText());
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frameTop);
		WebElement frameRight = driver.findElement(By.name("frame-right"));
		driver.switchTo().frame(frameRight);
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		
		driver.switchTo().defaultContent();
		WebElement frameButtom = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		driver.switchTo().frame(frameButtom);		
		System.out.println(driver.findElement(By.xpath("//body")).getText());
//		System.out.println(driver.findElement(By.linkText("LEFT")).getText());
		
		

	}

}
