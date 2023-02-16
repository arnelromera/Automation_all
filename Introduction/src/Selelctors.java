import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selelctors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		//css select0r
		//<input type="text" placeholder = "User_name" value = "">
		//tag = input
		//attribute = type/placeholder/value

		//Selector
		
		//id = # 
		//xpath
			// - console validation = $x('xpath')
			// - //tagname[@attribute='value']
			// - //tagname[@attribute='value'][index] 
			// - parent to child 
				// - //parent_tag_name/child_tag_name[index]
		
		//css selector
			// - console validation = $('css selector')
			// - tagname[attribute='value']
			// - tagname[attribute='value']:nth-child(index) - child items
			// - css selector: parent to child 
				// - parent_tag_name childtag_name
		
			// Css selectors based on regular expressions - input[type* = 'pass']
			// tagname[contains(@type=value)] - //button[@class='value'];
				
		
		//name = 
		//class name = .
		//tag name = 
		//link text = 
		// partial link text = 
		
		//button[text()="text value"] 
			// replacement for tab is *
		
		// Sibling : child to parent
		 	// - absolute xpath (/html/body/header)
			// - relative xpath (//header/div/button[1])
			// - traverse from one sibling to other sibling (//header/div/button[1]/following-sibling::button[1])
			// - traverse from child to parent (//header/div/button[1]/parent::div)
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://dev-front.machetalk.jp/liver/");
		driver.manage().window().maximize();
		driver.findElement(By.className("login")).click();
		driver.findElement(By.cssSelector("input.mail")).sendKeys("rktest1@gmail.com");
		driver.findElement(By.xpath("//input[@name=\"login_password\"]")).sendKeys("admin");
		driver.findElement(By.className("btn_style")).click();
		
	
		//driver.close();
		
		
	}

}
