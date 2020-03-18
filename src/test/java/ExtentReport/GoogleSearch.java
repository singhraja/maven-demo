package ExtentReport;
 
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GoogleSearch {

	public static void main(String[] args) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html"); 
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("Google Search Test one","This is test to validate google search functionality");
		test.log(Status.INFO, "Starting testcase");
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rajaputra/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.google.com/");
		test.pass("Navigated to google.com");
		driver.findElement(By.name("q")).sendKeys("java");
		//test.pass("entered search in text box");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test.pass("pressed keyboard enter key");
		
		extent.flush();
		//driver.close();
		
		
	}

}
