import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class joinOpenBroadCast {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--use-fake-ui-for-media-stream=10");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://dev-front.machetalk.jp/");
		
		test a = new test();
		
		String broadcastName = a.roomName;
		String[] giftCategoryName = {"ピックアップ"};
		String[] giftName = {"節分"};
		

		// login button
		WebElement loginButton = driver.findElement(By.cssSelector(".button_login.btn_style.btn_green-o"));
		String loginButtonText = loginButton.getText();
		loginButton.click();
		System.out.println(loginButtonText + "button is clicked");
		
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("login_mail")));
		
		//login modal
		try {
			Login test = new Login();
			test.login(driver);
		}
		catch(Exception e) {
			 e.printStackTrace();
			 System.out.println("Error when logging in. Please check the cridentials");
			 System.exit(1);
		}
		
		Thread.sleep(5000);
		
		//daily login bunos
		Open_Broadcast.Bonus("dailybonus",driver);

		Thread.sleep(15000);
		//join broadcast
		try {
			joinBroadcast(driver,broadcastName);
		}
		catch(Exception e) {
			e.printStackTrace();
			 System.out.println("Error when the user tries to join to a broadcast. Please check the cridentials/Element");
			 System.exit(1);
		}
		
		
		Thread.sleep(5000);
		//Switch to child window
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
		Iterator<String>it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);

		Thread.sleep(15000);
		
//		//comment section
//		try {
//			ArrayList<String> contain = new ArrayList<String>(Arrays.asList("Automated comment 1", "Automated comment 2", "Automated comment 3", "Automated comment 4", "Automated comment 5", "Automated comment 6", "Automated comment 7" ));
//			for(String s : contain) {
//				if(s.contains(s)) {
//					String a = s;
//					driver.findElement(By.cssSelector("#inputComment")).sendKeys(a);
//					driver.findElement(By.cssSelector("button[type='submit']")).click();
//				}
//			}	
//		}
//		catch(Exception e) {
//			System.out.println("Some error in the comment section");			
//		}
		
		//select category tab
		categoryList(driver,giftCategoryName);
		
		//select gift
		Thread.sleep(5000);
		addGift(driver,giftName);
			
//		driver.switchTo().window(parentId);
	}
	
	//join brooadcast method
	public static void joinBroadcast(WebDriver driver,String broadcastName) {
		int j=0;
		List<WebElement> broadcast = driver.findElements(By.xpath("//div[@class='room']"));
		
		for(int i=0; i<broadcast.size(); i++) {
			
			String broadcastlist = broadcast.get(i).getText();
			
			List<String> itemsNeededList = Arrays.asList(broadcastName);
			
				if(itemsNeededList.contains(broadcastlist)) 
				{
					j++;
					driver.findElements(By.xpath("//div[@class='liver ng-scope']")).get(i).click();
					if(j == broadcastName.length()) {
						break;
					}
				}
		}
		
	}

	//category tab method
	public static void categoryList(WebDriver driver,String[] giftCategoryName) {
		int j=0;
		List<WebElement> categoryName = driver.findElements(By.cssSelector(".swiper-slide"));
		
		for(int i=0; i<categoryName.size(); i++) {
			
			String categorylist = categoryName.get(i).getText();
			
			List<String> giftCategoryNameList = Arrays.asList(giftCategoryName);
			
				if(giftCategoryNameList.contains(categorylist)) 
				{
					j++;
					driver.findElements(By.cssSelector(".swiper-slide")).get(i).click();
					System.out.println("The category name is clicked");
					if(j == giftCategoryName.length) {
						break;
					}
				}
				else
				{
					WebElement category = driver.findElement(By.id("swiper_category"));
					Actions actions = new Actions(driver);
					
					//Hovering on main menu
					actions.moveToElement(category);
					
					driver.findElement(By.xpath("//div[@class='swiper-button-next']")).click();
					System.out.println("The next button is clicked");
				}
		}
		
	}
	
	//gifting method
	public static void addGift(WebDriver driver,String[] giftName) {
		
		int j=0;
		List<WebElement> giftNameElement = driver.findElements(By.xpath("//div[@class='list-item ng-scope']/p"));
		
		for(int i=0; i<giftNameElement.size(); i++) {
			
			String giftNameList = giftNameElement.get(i).getText();
			
			List<String> giftasdfNameList = Arrays.asList(giftName);
			
				if(giftasdfNameList.contains(giftNameList)) 
				{
					j++;
					WebElement a = driver.findElements(By.xpath("//div[@class='list-item ng-scope']")).get(i);
					int count = 50;
					for(int i1=0; i1<count; i1++) {
						a.click();
					}
					if(j == giftName.length) {
						break;
					}
				}		
		}
	}
}
