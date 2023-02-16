import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register {

	public void register () throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String url = "https://dev-front.machetalk.jp/liver/";
		String email = "sampleautomated@gmail.com";
		String password = "admin";
		String nickName = "Automated Registration";
		
		
		driver.get(url); // get url
		driver.manage().window().maximize(); // maximize window
	
		driver.findElement(By.className("regist")).click();
		driver.findElement(By.xpath("//input[@name='register_mail']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='register_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='register_password_conf']")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.name("register_nickname")).sendKeys(nickName);
		driver.findElement(By.id("btnProfileImgUpdate")).click();
		
//		Thread.sleep(2000);
//		driver.findElement(By.id("doGetBonus")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("button.btn_style")).click();
		
		Thread.sleep(5000);
		//daily login bunos
		Open_Broadcast.Bonus("dailybonus",driver);
	}

}
