import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tablelist {

		public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// maximize window
		driver.manage().window().maximize();
		
		int j=0;

		//get url
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		//declare arry list
		String [] productName = {"Cucumber", "Mushroom", "Banana", "Corn"};
		
		//To get the list in the page
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		// for loop to check the list
		for(int i=0; i<products.size(); i++ )
			{
				//Brocolli - 1 Kg
				//Brocolli,    1 kg
				//Spitting the text
				String [] name = products.get(i).getText().split("-");
				
				//trimming remaing spaces
				String formatedName = name[0].trim();
				
				//format it to get actual vegetable name
	
				//convert array into array list for easy search
	
				//  check whether name you extracted is present in arrayList or not-
				
				List<String> itemNeededList = Arrays.asList(productName);
							
				if(itemNeededList.contains(formatedName))
				{
					j++;
					// clicks for the button
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
					}
				if(j==productName.length)
				{
					break;
				}
				
			}
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),\"PROCEED TO CHECKOUT\")]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("arnelromera");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		

	}

}
