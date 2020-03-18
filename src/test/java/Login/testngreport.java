package Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testngreport {

	
	WebDriver driver=null;  
	//pre conditions 
	@BeforeSuite
	public void setup()
	{
		System.out.println("Setup system property for chrome");
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rajaputra/Downloads/chromedriver_win32/chromedriver.exe");
		
		
	}
	
	
	@BeforeClass
	public void launchBrowser()
	{
		System.out.println("launch chrome Browser");
		driver= new ChromeDriver();
	}
	
	@BeforeMethod
	public void enterURL()
	{
		System.out.println("enter URL");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
	}
	
	
	//Test case
	
	
	@Test(priority =2)//test priority
	public void googleTitleTest() 
	{	
		System.out.println("Google Title Test");
		String title = driver.getTitle();//validating if the URL by checking the title.
		System.out.println(title);
	}
	
	@Test(priority=1)
	public void googlelogo()
	{
		boolean b= driver.findElement(By.xpath("//*[@id=\'hplogo\']")).isEnabled();// validating if google logo is displayed. 
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

