package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login_page {
	
		
	    WebDriver driver;
	    public login_page(WebDriver driver)
	    {
		    this.driver = driver;
	    }

	    By user = By.id("email1");
	    By pass = By.name("password1");
	    By login = By.xpath("//button[text()='Sign in']");
	    By loginHeader = By.xpath("//h2[normalize-space()='Sign In']");
	    public void loginToApp(String username,String pw)

	    {
		    driver.findElement(user).sendKeys(username);
		    driver.findElement(pass).sendKeys(pw);
		    driver.findElement(login).click();

	    }
	    public boolean isSignInPresent()
	    {
	    	return driver.findElement(loginHeader).isDisplayed();
	    }
	


}
