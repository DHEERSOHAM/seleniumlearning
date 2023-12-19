package listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import helper.utility;

public class ExtentManager {
	public static ExtentReports extent;
	public static ExtentReports  getInstance()
	{
		if(extent==null)
		{
			extent = createInstance();
			return extent;
		}
		else
		{
			return extent;
		}
		
			
		
	}

	
	public static ExtentReports createInstance()
	{
		ExtentSparkReporter spark = new ExtentSparkReporter(".\\reports\\AutoamtionReport"+ utility.currentdate()+ ".html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("Autoamtion report");
		spark.config().setDocumentTitle("sprint 1 report");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		return extent;
		
	}

}
