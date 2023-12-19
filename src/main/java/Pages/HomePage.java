package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	By signout = By.xpath("//button[normalize-space()='Sign out']");
	By welcomeMSG= By.xpath("//h4");
	public void clickONSignout()
	{
		driver.findElement(signout).click();
		
	}
	public String getWelcomemsg()
	{
		return driver.findElement(welcomeMSG).getText();
	}

}
