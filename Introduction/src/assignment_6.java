import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\Automatio\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector("#checkBoxOption3")).click();
		
		// fetch the text from the radio option
		String optionLabel = driver.findElement(By.cssSelector("label[for='honda']")).getText();
		System.out.println(optionLabel);
		
		// click the dropdown button
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		//staticDropdown.click();
		
		// select a value from the dropdown menu
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(optionLabel);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		// Enter the selected text in the name field
		driver.findElement(By.id("name")).sendKeys(optionLabel);
		
		// Click the alert button
		driver.findElement(By.id("alertbtn")).click();

		System.out.println(driver.switchTo().alert().getText());
		
		String text = driver.switchTo().alert().getText();
		
		if(text.contains(optionLabel))
		{
			System.out.println("Alert message success");
		}
		else
			System.out.println("Something wrong with execution");
		
		// switch context to alert
		driver.switchTo().alert().accept();
		

	}

}
