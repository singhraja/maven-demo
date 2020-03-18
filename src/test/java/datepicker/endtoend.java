package datepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class endtoend {
	static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Rajaputra/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		//driver.findElement(By.name("ctl00$mainContent$ddl_originStation1")).click();
		//driver.findElement(By.xpath("//*[@id=\'dropdownGroup1\']/div/ul[1]/li[1]/a")).click();
		Thread.sleep(2000);
		
		
		//driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
}
	
	public static void selectDateByJS(WebElement driver, WebElement element, String date)
	{
		JavaScriptExecutor js=((JavaScriptExecutor) driver);
		js.ex
	}
	
}