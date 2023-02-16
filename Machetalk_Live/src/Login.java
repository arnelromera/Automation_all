import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
//	private String email;
//	private String password;
//	
//	public void setLogin(String Nemail, String Npassword) {
//		this.email = Nemail;
//		this.password = Npassword;
//		
//	}	
	public void login (WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.name("login_mail")).sendKeys("lebron@gmail.com");
		driver.findElement(By.name("login_password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@class='btn_style btn_green']")).click();
	}
}
