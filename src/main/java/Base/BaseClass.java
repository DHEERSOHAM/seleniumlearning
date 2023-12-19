package Base;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import browserfactory.BrowserFactory;
import dataProvider.ConfigReader;

public class BaseClass {
	public WebDriver driver;
	@BeforeClass
	public void setupBrowser()
	{
		driver = BrowserFactory.startbrowser( ConfigReader.getProperty("browser") , ConfigReader.getProperty("url"));
		
	}
	@AfterClass
	public void closebrowser()
	{
		driver.quit();
	}

}
