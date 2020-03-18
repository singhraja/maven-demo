package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrbitContactUs {

public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rajaputra/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.orbithc.com/");
		driver.findElement(By.linkText("Contact us")).click();//("/*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[4]/a")).click();
		driver.findElement(By.id("name")).sendKeys("test");
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("1234567890");
		driver.findElement(By.id("message")).sendKeys("we are trying automation");
		
		
		
	}
	
}
