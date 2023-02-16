import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Open_Broadcast {
	
	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--use-fake-ui-for-media-stream=10");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		WebDriverManager.chromedriver().setup();
		
		driver.manage().window().maximize();
		driver.get("https://dev-front.machetalk.jp/liver/");
		
		driver.findElement(By.className("login")).click();
		
		test a = new test();
		
//		Login test = new Login();
//		test.login(driver);
		
//		Register test = new Register();
//		test.register();
		Bonus("login", driver);
		
		Thread.sleep(3000);
		Bonus("dailybonus", driver);
		
		
		driver.findElement(By.xpath("//a[@class='button size_m']")).click();
		System.out.println("The login button is clicked");
		driver.findElement(By.id("count_text")).sendKeys(a.roomName);
		driver.findElement(By.xpath("//ul/li[2]")).click();
		driver.findElement(By.cssSelector("button.btn_style")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button.button_open")).click();
		
		
		Thread.sleep(10000);
//		Thread.sleep(2000);
		WebElement sound = driver.findElement(By.id("btn-sound_own"));
		WebElement video = driver.findElement(By.id("btn-invite"));
		//WebElement video = driver.findElement(By.className("video"));
		//Instantiating Actions class
		Actions actions = new Actions(driver);
		
		//Hovering on main menu
		actions.moveToElement(sound).click().build().perform();
		Thread.sleep(6000);
		actions.moveToElement(video).click().build().perform();
		
		
		
		//below code will open Tab for you as well as switch the control to new Tab
		WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
		// below code will navigate you to your desirable Url 
		driver.get("https://dev-front.machetalk.jp/");
		
		test aa = new test();
		
		String broadcastName = aa.roomName;
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
		Set<String> windows = newTab.getWindowHandles(); //[parentid,childid,subchildId]
		Iterator<String>it = windows.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

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
			
		
		Thread.sleep(120000);
		driver.quit();
	}
		// Locating the element from Sub Menu
		//WebElement subMenu = driver.findElement(By.id("btn-sound_own"));

		//To mouseover on sub menu
		//actions.moveToElement(subMenu);

		//build()- used to compile all the actions into a single step 
		//actions.click().build().perform();
//		Thread.sleep(2000);
//		driver.findElement(By.id("btn-sound_own")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.id("btn-invite")).click();

	
	
	
	static void Bonus(String act, WebDriver driver) throws InterruptedException
	{
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	       .withTimeout(Duration.ofSeconds(30))
	       .pollingEvery(Duration.ofSeconds(5))
	       .ignoring(NoSuchElementException.class);
		
		switch (act) {
		case "dailybonus" :
			try {
				boolean doGetBonusPresence = driver.findElement(By.id("doGetBonus")).isDisplayed();
				boolean doGetBonusEnabled = driver.findElement(By.id("doGetBonus")).isDisplayed();
				if(doGetBonusPresence == true && doGetBonusEnabled == true)	
				{
					System.out.println("The daily login modal bonus is displayed");
					driver.findElement(By.id("doGetBonus")).click();
					Thread.sleep(5000);
					System.out.println("The daily login get modal bonus is displayed");
					driver.findElement(By.cssSelector(".btn_style.btn_green.modal_close")).click();			
				}
			}
			catch(Exception e){
				
				System.out.println("The get bonus modal is not displayed.");
			}
			break;
			
		case "register" :
			break;
			
		case "login" :
			WebElement doGetBonus = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			    	 if(driver.findElement(By.name("login_mail")).isEnabled())	
						{
			    		 return driver.findElement(By.name("login_mail"));
						}
			    	 else
			    	 {
			    		 return null;
			    	 }
			     }
			   });
			System.out.println("The login page is displayed");
			doGetBonus.sendKeys("mt-2021-5@gmail.com");
			driver.findElement(By.name("login_password")).sendKeys("admin");
			driver.findElement(By.xpath("//button[@class='btn_style btn_green']")).click();
			break;
		  default :
			  break;
		}
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
