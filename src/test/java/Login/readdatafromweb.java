package Login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class readdatafromweb {
	WebDriver driver=null; 
	protected String browser;
	Properties prop;
	static ExtentTest test;
	static ExtentReports report;
	//pre conditions 
	@BeforeSuite
	public void setup() throws FileNotFoundException, IOException
	{
		System.out.println("Setup system property for chrome");
		  prop = new Properties();
		 //prop.load( new FileInputStream("path/test.properties") );
		  prop.load(new FileInputStream(new File("C:\\JAVA projects\\maven-demo\\src\\test\\resources\\test.properties")));
		  browser = prop.getProperty("browser");
		  //System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriver") );
		  System.out.println("browser:"+browser);
		  if ( browser.equals("firefox")) {
			  System.out.println("browser:"+browser);
			  //add relative path
			  System.setProperty("webdriver.gecko.driver", "C://Users//Rajaputra//Downloads//geckodriver-v0.26.0-win32//geckodriver.exe");
		    }  else {
		      System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriver") );
		    }
		
		 
	}
	
		
	@BeforeClass
	public void launchBrowser() throws InterruptedException
	{
		System.out.println("launch chrome Browser");
		if(browser.equals("firefox"))
		driver= new FirefoxDriver();
		else 
		driver= new ChromeDriver();
		
		System.out.println("enter URL");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement( By.id("txtUsername")).sendKeys(prop.getProperty("username")); //find element username and type Admin
		//--//*[@id="txtUsername"]
		driver.findElement(By.id("txtPassword")).sendKeys(prop.getProperty("password"));//find element password and type admin123
		Thread.sleep(2000);
		driver.findElement(By.id("btnLogin")).click();
		
		//
		//report = new ExtentReports(System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
		
		//report.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		
		
		
	}
	
	
	@BeforeMethod
	public void enterURL()
	{
		
		System.out.println("before method");
	
	
	}
	
	
	@Test(priority =1)//test priority
	public void OHRMTitleTest() 
	{	//test = report.startTest("OHRMTitleTest");
		System.out.println("OHRM Title Test");
		String title =driver.getTitle();//validating if the URL by checking the title.
		System.out.println(title);
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		/*if(driver.getTitle().equals("OrangeHRM"))
			
			{
			
			test.log(LogStatus.PASS, "Navigated to the specified URL");
			
			}
			
			else
			
			{
			
			test.log(LogStatus.FAIL, "Test Failed");
			
			}
			*/
			}

	
	@Test(priority =3)//test priority
	public void OHRMEmployeelist() throws InterruptedException
	{	Thread.sleep(2000); 
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
	driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList/reset/1");
	
	int r= driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr")).size();
	System.out.println("rows "+r);
	
	}
	
	@Test(priority =2)//test priority
	public void OHRMAddEmployee() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
	driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");
	
	System.out.println("Add Employee details ");
	driver.findElement(By.id("firstName")).sendKeys("abc");
	driver.findElement(By.id("lastName")).sendKeys("smith");
	driver.findElement(By.id("btnSave")).click();
	driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);		
	Thread.sleep(2000);
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
		//report.endTest(test);
		//report.flush();

	}
	
	@AfterSuite
	public void aftersuite()
	{
		System.out.println("End of the test Suite");
		//driver.quit();
	}
}

