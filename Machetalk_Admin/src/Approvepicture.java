import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Approvepicture {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		driver.get("https://dev-admin.machetalk.jp/dashboard/present_days.html");
		
		
//		//first layer tab list
//		String[] firstLayerTab = {"ログ・履歴"};
//		
		//second layer tab list
		String[] secondLayerTab = {"チェック関係"};
		
		//third layer tab list
		String[] thirdLayerTab = {"ストーリー管理"};
		
//		WebElement luluTab = driver.findElement(By.cssSelector(".tab[data-show='lulu']"));
//		WebElement エージェントTab = driver.findElement(By.cssSelector(".tab[data-show='macherie agent']"));
//		WebElement 共通Tab = driver.findElement(By.cssSelector(".tab[data-show='macherie variety common']"));
		
		adminLogin adminLogin = new adminLogin();
		adminLogin.AdminLogin(driver);
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tab[data-show='macherie']")));
		driver.findElement(By.cssSelector(".tab[data-show='macherie']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#navMenu-logrireki")).click();
//		storyMangementTab(driver,firstLayerTab);
		
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//span[@class='navMenu-subLabel'][contains(text(),'視聴者管理')])[1]")).click();
		checkRelationship(driver, secondLayerTab);
		
		Thread.sleep(2000);
		viewerRegistration(driver,thirdLayerTab);
		
		Thread.sleep(5000);
		String[] a = {"71521"};
		
		//driver.findElement(By.cssSelector("input[name='source_id']")).sendKeys(a);

		driver.findElement(By.cssSelector(".btn.btn-primary.member_index")).click();
		
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//div[@class='col-xs-12']/a")));
		
		
//		List<WebElement> storyList = driver.findElements(By.xpath("//div[@class='col-xs-12']/a"));
//		int j=0;
//		for(int i=0; i<storyList.size(); i++) {
//			String storyItem = storyList.get(i).getText();
//			System.out.println(storyItem);
//			List<String> storyManangement = Arrays.asList(a);
//			
//			if(storyManangement.contains(storyItem)) {
//				j++;
//				driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']")).click();
//				if(j == a.length) {
//					break;
//				}
//			}
//			
//		}
		
		String selectAllButton = "全て選択";
		List<WebElement> selectAllB = driver.findElements(By.xpath("//button[@class='btn btn-primary ttl_btn_select_all']"));
		
		for(int i = 0; i<selectAllB.size(); i++) {
			String selectedButtonList = selectAllB.get(i).getText();
			List<String> selectButton = Arrays.asList(selectAllButton);
			
			if(selectButton.contains(selectedButtonList)) {
				driver.findElements(By.xpath("//button[@class='btn btn-primary ttl_btn_select_all']")).get(i).click();
			}
		}
		
		String approvedSelectedButton = "選択中承認";
		List<WebElement> approveSelected = driver.findElements(By.xpath("//button[@class='btn btn-primary ttl_btn_approve_all']"));
		
		for(int i = 0; i<approveSelected.size(); i++) {
			String approvedSelectedButtons = approveSelected.get(i).getText();
			List<String> approvedButton = Arrays.asList(approvedSelectedButton);
			
			if(approvedButton.contains(approvedSelectedButtons)) {
				driver.findElements(By.xpath("//button[@class='btn btn-primary ttl_btn_approve_all']")).get(i).click();
			}
		}
		
		
	}
	
//	//first layer tab
//	public static void storyMangementTab(WebDriver driver,String[] firstLayerTab) {
//		List<WebElement> fistLayerTab = driver.findElements(By.xpath("//ul[@class='navMenu-rootTree']/li/span[@class='navMenu-topLabel nav-toggle']"));
//		for(int i=0; i<fistLayerTab.size(); i++) {
//			String storyMangementButton = fistLayerTab.get(i).getText();
//			List<String> storyManagement1 = Arrays.asList(firstLayerTab);
//			if(storyManagement1.contains(storyMangementButton)) {
//				driver.findElements(By.xpath("//ul[@class='navMenu-rootTree']/li/span[@class='navMenu-topLabel nav-toggle']")).get(i).click();
//				}
//		}
//		
//	}
	
	//Second layer tab
	public static void checkRelationship(WebDriver driver,String[] secondLayerTab) {
		int j=0;
		List<WebElement> secondLayerTab1 = driver.findElements(By.xpath("//ul[@class='navMenu-subMenu']/li/span[@class='navMenu-subLabel']"));
		for(int i=0; i<secondLayerTab1.size(); i++) {
			String secondLayerList = secondLayerTab1.get(i).getText();
			
			List <String> secondLayerTab2 = Arrays.asList(secondLayerTab);
			if(secondLayerTab2.contains(secondLayerList)) {
				j++;
				driver.findElements(By.xpath("//ul[@class='navMenu-subMenu']/li/span[@class='navMenu-subLabel']")).get(i).click();
				if(j == secondLayerTab.length) {
					break;
				}
			}
		}
		
	}
	
	//layer 3 tab
	public static void viewerRegistration(WebDriver driver,String[] thirdLayerTab) {
		int j=0;
		//To get the list in the page
		List<WebElement> viewerTab = driver.findElements(By.xpath("//ul[@class='navMenu-subMenu-2 open']/li/a"));
		
		// for loop to check the list
		for(int i=0; i<viewerTab.size(); i++ )
		{
			String viewerRegistrationButton = viewerTab.get(i).getText();
			
			List<String> viewerRegistration = Arrays.asList(thirdLayerTab);
			
			if(viewerRegistration.contains(viewerRegistrationButton))
			{
				j++;
				driver.findElements(By.xpath("//ul[@class='navMenu-subMenu-2 open']/li/a")).get(i).click();
				if(j == thirdLayerTab.length)
				{
				break;
				}
			}	
		}
	}

}
