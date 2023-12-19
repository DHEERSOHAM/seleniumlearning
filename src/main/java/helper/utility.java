package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class utility {
	
	
	
		
	
	public static WebElement highlightElement(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px solid red;'", ele);
		waitforsec(1);
		js.executeScript("arguments[0].setAttribute('style','background:white;border:2px solid white;'", ele);
		return ele;
		
	}


	public static Alert waitForAlert(WebDriver driver,int time)
	{
        Alert alt= null; // manual way of doing waits
		
		    for(int i=0;i<time;i++)
		    {
			    try 
			    {
				    alt = driver.switchTo().alert();
				    break;
				
				
			    }
			    catch(NoAlertPresentException e)
			    {
				    utility.waitforsec(1);
			    }
		    }
		    return alt; 
            
	}
	public static void waitforsec(int secounds)
	{
		try {
			Thread.sleep(secounds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void capturescreenshot(WebDriver driver)
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\MyScreenshots\\"+ currentdate()+".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			System.out.println("something went wrong" +e.getMessage());
		
		}
		
	}
	public static String capturescreenshotinBase64(WebDriver driver)
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		String base64 = ts.getScreenshotAs(OutputType.BASE64);
		return base64;
	}
	public static void ElementScreenshot(WebElement ele)
	{
		File src = ele.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\ele_screenshot\\ele_" + currentdate()+".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("something went wrong" +e.getMessage());
		}
	}
	public static String currentdate()
	{
		Date d = new Date();//currentdate
		SimpleDateFormat mydate = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String date = mydate.format(d);
		System.out.println(date);
		return date;
		
	}
	
}



