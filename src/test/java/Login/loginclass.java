package Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class loginclass {

		WebDriver driver=null;  
		String url="https://accounts.google.com/signin";
		static ExtentTest test;
		static ExtentReports report;
		
		//pre conditions 
		@BeforeSuite
		
		public void setup() 
		{
			System.out.println("Setup system property for chrome");
			System.setProperty("webdriver.chrome.driver","C:/webdrivers/chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			/*options.addArguments("test-type");
			options.addArgument("--start-maximized");*/
			options.addArguments("--disable-web-security");
			/* options.addArguments("--allow-running-insecure-content");*/
			capabilities.setCapability("chrome.binary","C:/webdrivers/chromedriver.exe");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(options);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(options);

			
		}

	
		@BeforeClass
		
		public void launchBrowser()
		{
			System.out.println("launch firefox Browser");
			report = new ExtentReports(System.getProperty("C:\\Users\\Rajaputra\\Desktop\\DemoTestCases")+"\\ExtentReportResults.html");
			test = report.startTest("ExtentDemo");

						
		}
		
		
		
		@BeforeMethod
		public void enterURL()
		{
			driver.get(url);
			
            driver.findElement(By.id("identifierId")).sendKeys("samritrajaputra@gmail.com"); 

            //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);      

            WebDriverWait wait=new WebDriverWait(driver, 20);               

            driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();         

            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);        

            driver.findElement(By.name("password")).sendKeys("Madhavi1");             
            driver.findElement(By.id("passwordNext")).click();
           // driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click(); 
            //driver.findElement(By.className("CwaK9")).click();
		}
		
		
		
		//Test case
		
		
		@Test(priority=2)
		public void googleTitleTest() throws InterruptedException
		{	
			System.out.println("Google Title Test");
			Thread.sleep(3000);
			String title = driver.getTitle();//validating if the URL by checking the title.
			System.out.println(title);
		}
		
		@Test(priority=1)
		public void googlelogo()
		{	
			boolean b= driver.findElement(By.xpath("//*[@id=\'hplogo\']")).isEnabled();
			 //validating if google logo is displayed. 
			System.out.println(b);
		}
		
		
		//Post Test
		@AfterMethod
		public void aftermethod()
		{
			System.out.println("This is after test");
		}
		
		@AfterTest
		public void aftertest()
		{
			System.out.println("after test delete all cookies");
			driver.manage().deleteAllCookies();
		}
		
		@AfterSuite
		public void aftersuite()
		{
			System.out.println("End of the test Suite");
			//driver.quit();
		}
		
		
	

	}


