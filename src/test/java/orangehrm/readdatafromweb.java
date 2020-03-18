package orangehrm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class readdatafromweb {
		
	
	//public static void main(String[] args) {
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
			driver.get("https://opensource-demo.orangehrmlive.com/");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			driver.findElement( By.id("txtUsername")).sendKeys("Admin"); //find element username and type Admin
			//--//*[@id="txtUsername"]
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");//find element password and type admin123
			driver.findElement(By.id("btnLogin")).click();
			
			
		}
		
		
		@Test(priority =1)//test priority
		public void OHRMTitleTest() 
		{	
			System.out.println("OHRM Title Test");
			String title =driver.getTitle();//validating if the URL by checking the title.
			System.out.println(title);
			
		}
		
		@Test(priority =2)//test priority
		public void OHRMEmployeelist()
		{
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList/reset/1");
		
		int r= driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr")).size();
		System.out.println("rows "+r);
		
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

