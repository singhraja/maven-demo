package Login;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String browser;
		Properties prop;
		
		
		/*
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rajaputra/Downloads/chromedriver_win32/chromedriver.exe");
		
		*/
		prop = new Properties();
		prop.load(new FileInputStream(new File("C:\\JAVA projects\\maven-demo\\src\\test\\resources\\test.properties")));
		  
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
		  
		  
		  
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("java");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		//driver.close();
		
		
	}

}
