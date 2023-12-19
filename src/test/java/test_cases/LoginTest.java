package test_cases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.HomePage;
import Pages.login_page;
import browserfactory.BrowserFactory;
import dataProvider.CustomDataProvider;


public class LoginTest extends BaseClass {
	
	@Test(dataProvider = "EmpDataSet" , dataProviderClass = CustomDataProvider.class)
	public void logintoapp(String user,String pass)
	{
		login_page login = new login_page(driver);
		login.loginToApp(user,pass);
		HomePage home = new HomePage(driver);
		Assert.assertTrue(home.getWelcomemsg().contains("Welcome"));
		home.clickONSignout();
		Assert.assertTrue(login.isSignInPresent());
		
	}

}
