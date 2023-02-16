import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class talkLiverRegister {
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		driver.findElement(By.className("login")).click();
			// field value declaration
			String url = "https://dev-front.machetalk.jp/liver/";
			String email = "mt-2021-36@gmail.com";
			String password = "admin";
			String nickName = "mt-2021-36";
			
			driver.manage().window().maximize(); // maximize window
			driver.get(url); // get url
		
//			driver.findElement(By.className("login")).click();
		
			driver.findElement(By.className("regist")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='register_mail']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@name='register_password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@name='register_password_conf']")).sendKeys(password);
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(1000);
			driver.findElement(By.name("register_nickname")).sendKeys(nickName);
			driver.findElement(By.id("btnProfileImgUpdate")).click();
			
//			Thread.sleep(5000);
			//daily login bunos
//			Open_Broadcast.Bonus("login",driver);
			
			
			Thread.sleep(5000);
			//daily login bunos
			Open_Broadcast.Bonus("dailybonus",driver);
			
			driver.close();

		
	}

}
