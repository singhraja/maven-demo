package Login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrbitContact {

public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
	String browser;
	Properties prop;
	prop = new Properties();
	prop.load(new FileInputStream(new File("C:\\JAVA projects\\maven-demo\\src\\test\\resources\\test.properties")));
	  
	String url=null;
	String name=null;
	String email=null;
	String phone=null;
	String message=null;
	
	 
	browser = prop.getProperty("browser");
	  System.out.println("browser:"+browser);
	  if ( browser.equals("firefox")) {
		  System.out.println("browser:"+browser);
		  //add relative path
		  System.setProperty("webdriver.gecko.driver", "C://Users//Rajaputra//Downloads//geckodriver-v0.26.0-win32//geckodriver.exe");
	    }  else {
	      System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriver") );
	    }
	  WebDriver driver= new ChromeDriver();
	  
	  
	  
		driver.get(prop.getProperty("url"));
		driver.findElement(By.linkText("Contact us")).click();
		
		driver.findElement(By.id("name")).sendKeys(prop.getProperty("name"));
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.id("phone")).sendKeys(prop.getProperty("phone"));
		driver.findElement(By.id("message")).sendKeys(prop.getProperty("message"));
		
		
	}
	
}
