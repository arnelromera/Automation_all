import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Talkliverusssage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String url = "https://dev-front.machetalk.jp/liver/";
		
		
		driver.manage().window().maximize(); // maximize window
		driver.get(url); // get url
	
		driver.findElement(By.className("login")).click();
		
		//daily login bunos
		Open_Broadcast.Bonus("login",driver);
		
		Thread.sleep(5000);
		//daily login bunos
		Open_Broadcast.Bonus("dailybonus",driver);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(.,'トークライバーの使い方')]")).click();
		
		
		List<String> list = Arrays.asList("トークライバーとは","オープン配信", "2ショット","メッセージ", "タイムライン","報酬形態");
		List <WebElement> howToUseTalkLiver = driver.findElements(By.xpath("//div[@class='item_ttl']"));
		for(int i=0; i<howToUseTalkLiver.size(); i++) {
			String item = howToUseTalkLiver.get(i).getText();
			if(list.contains(item)) {
//				howToUseTalkLiver.get(i).click();
//				howToUseTalkLiver.get(i).click();
//				driver.navigate().back();
//				Thread.sleep(10000);
//			}
				switch (item) {
				case "トークライバーとは":
					howToUseTalkLiver.get(i).click();
					driver.navigate().back();
					Thread.sleep(10000);
				case "オープン配信":
					howToUseTalkLiver.get(i).click();
					driver.navigate().back();
					Thread.sleep(10000);

				case "2ショット":
					System.out.println(item);
					break;
				case "メッセージ":
					System.out.println(item);
					break;
				case "タイムライン":
					System.out.println(item);
					break;
				case "報酬形態":
					System.out.println(item);
					break;
				}
			}
			if(i == 2) {
				
			}
			
		}
		
		
		

	}

}
