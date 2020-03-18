package orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangeHRMEmployeeList {

	public static void main(String[] args) {
		WebDriver driver=null;  
		//set webdriver
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rajaputra/Downloads/chromedriver_win32/chromedriver.exe");
		driver= new ChromeDriver();
		//driver access the file
		driver.get("https://opensource-demo.orangehrmlive.com/");
		// (driver.manage()).window().maximize();//maximize the window
		
				driver.findElement( By.id("txtUsername")).sendKeys("Admin"); //find element username and type Admin
		//--//*[@id="txtUsername"]
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");//find element password and type admin123
		
		
		driver.findElement(By.id("btnLogin")).click();
		
		String title =driver.getTitle();
		System.out.println(title);
		
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList/reset/1");
		
		
		//find webelements on the file
		int r= driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr")).size();
		System.out.println("rows "+r);
		
		
		int Statuscount=0;
		//print the webelements
		for(int i=2; i<=r; i++)
		{
			
			String id =driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr["+i+"]/td[2]")).getText();
			//System.out.println(id);
			//String id1 =driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td[2]");
			String Lastname =
			driver.findElement(By.linkText("Last Name")).getText();
			System.out.println(id + " " + Lastname);
			/*
		if(status.equals("Enabled"))
		{
			
				Statuscount=Statuscount+1;
		}
		
		}
		
		System.out.println("No of emplpoyees Enabled: "+Statuscount);
		//driver.close();
		*/
		
	}
		


	}

}
