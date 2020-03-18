package ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;

public class NoCommerceTest {

	
	
	public WebDriver driver;
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	
	@BeforeTest
	public void setExtent()
	{
		htmlreporter = new ExtentHtmlReporter(System.getProperty("extent.html"));
		htmlreporter.config().setDocumentTitle("Automation Report");
		htmlreporter.config().setReportName("Functional Report");
		htmlreporter.config().setTheme(Theme.DARK);
		
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windos10");
		extent.setSystemInfo("Browser", "Chrome");

		
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rajaputra/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	
	
	@Test
	public void nocommerceTitleTest()
	{
		//test = extent.createTest("nocommerceTittleTest");
		String title = driver.getTitle();
		
		System.out.println(title);
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@AfterMethod
	public void tearDown()
	{
	
	}
	
}
