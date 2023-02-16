import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction{

	public static void main(String[] args) {
		
		//Invoking Browser
		//Chrome - ChromeDriver exten->Methods close get
		//Firefox- FirefoxDriver ->methods close get
		// WebDriver  close  get
		//WebDriver methods + class methods

		// Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Firefox
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		//WebDriver driver1 = new FirefoxDriver();

		//Microsoft Edge
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\edgedriver_win64\\msedgedriver.exe");
		//WebDriver driver2 = new EdgeDriver();
		
		driver.get("https://dev-front.machetalk.jp/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		//driver.quit();
		
	}
}
