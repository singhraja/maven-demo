package Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class paralleltesting {
	
	WebDriver driver=null;  
	String url="https://accounts.google.com/signin";
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception
	{
		
	//	System.setProperty("webdriver.chrome.driver", "C:/Users/Rajaputra/Downloads/chromedriver_win32/chromedriver.exe");
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
			System.out.println("Setup system property for firefox");
			System.setProperty("webdriver.gecko.driver", "C://Users//Rajaputra//Downloads//geckodriver-v0.26.0-win32//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.out.println("Setup system property for chrome");
			System.setProperty("webdriver.chrome.driver","C:/Users/Rajaputra/Downloads/chromedriver_win32/chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	@Test
	public void testParameterWithXML() throws InterruptedException{
		driver.get("https://www.orbithc.com/");
		
	}
	
	
}
