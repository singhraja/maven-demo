package ExtentReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import junit.framework.Assert;

public class GoogleSearchwithTestNGExtentReport {

	WebDriver driver= null;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test; 


	@BeforeTest
	public void setup() throws InterruptedException
	{
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html"); 
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rajaputra/Downloads/chromedriver_win32/chromedriver.exe");
		driver= new ChromeDriver();
		
		
			}
	

	@Test
	public void test1()
	{	
		driver.get("https://www.google.com/");
		// extent.createTest("Google Search Test one").pass("Navigated to google.com");
		//test.log(Status.INFO, "Starting testcase");
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google");
	}
	
	@Test
	public void test2()
	{	//test = extent.createTest("Google Search Test one","This is test to validate google search functionality");
		driver.findElement(By.name("q")).sendKeys("java");
		//test.pass("entered search in text box");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
	//	test.pass("pressed keyboard enter key");

	}

	
	@AfterMethod
	public void afterclass()
	{
		
	}
	
	@AfterSuite
	public void tearDown()
	{	
		//extent.flush();
		//driver.close();

	}
















}
