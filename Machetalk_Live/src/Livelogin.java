import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Livelogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//String[] userList = {"d08"};
		
		driver.manage().window().maximize();
		driver.get("https://dev-front.machetalk.jp/");
		driver.findElement(By.xpath("//button[@class='button_login btn_style btn_green-o']")).click();
		Thread.sleep(2000);
		Login test = new Login();
		test.login(driver);
		
		Thread.sleep(1000);
		Dailybonus dailyLoginBonus = new Dailybonus();
		dailyLoginBonus.Bonus("dailybonus", driver);

		
		//liverList(driver,userList);

	}
	
//	public static  void liverList(WebDriver driver,String[] userList)
//	{
//		int j=0;
//		List<WebElement> users = driver.findElements(By.xpath("//font[@style='vertical-align: inherit;']"));
//		for(int i=0;i<users.size();i++)
//			{
//			String name = users.get(i).getText();
//			
//			List<String> itemsNeededList = Arrays.asList(userList);
//			if(itemsNeededList.contains(name))
//				{
//				//click on Add to cart
//				driver.findElements(By.xpath("//img[@class='thumbnail']")).get(i).click();
//					if(j == userList.length)
//						{
//						break;
//						}
//				}
//			}
//		
//	}

}
