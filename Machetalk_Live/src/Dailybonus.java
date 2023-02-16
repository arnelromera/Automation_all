import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dailybonus {

	void Bonus(String act, WebDriver driver) throws InterruptedException
	{
		switch (act) {
		case "dailybonus" :
			//int d = 5;
			
			try {
				boolean doGetBonusPresence = driver.findElement(By.id("doGetBonus")).isDisplayed();
				boolean doGetBonusEnabled = driver.findElement(By.id("doGetBonus")).isDisplayed();
				if(doGetBonusPresence == true && doGetBonusEnabled == true)	
				{
					driver.findElement(By.id("doGetBonus")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//button[@class='btn_style btn_green modal_close']")).click();			
				}
			}
			catch(Exception e){
				
				System.out.println("User already claim the login bonus");
//				for(int i=0; i<d; i++) {
//					System.out.println("Teset");
//				}
			}
			break;
			
		case "register" :
			break;
			
		case "login" :
			driver.findElement(By.className("login")).click();
			driver.findElement(By.name("login_mail")).sendKeys("rktest6@gmail.com");
			driver.findElement(By.name("login_password")).sendKeys("admin");
			driver.findElement(By.className("btn_style")).click();
			break;
		  default :
				break;
		}
	}
}
