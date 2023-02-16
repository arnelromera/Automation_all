import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class adminLogin {
	public void AdminLogin (WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.name("login_id")).sendKeys("fdc");
		driver.findElement(By.name("password")).sendKeys("fdc");
		
		WebElement staticDropdown = driver.findElement(By.name("login_type"));
		//Static dropdowns
		Select dropdown = new Select(staticDropdown);
		//select by option value
		dropdown.selectByIndex(3);
		driver.findElement(By.className("btn-primary")).click();
	}

}
