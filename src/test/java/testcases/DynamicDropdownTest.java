package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropdownTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Visit Spicejet.com
		driver.get("https://www.spicejet.com/default.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		//Click Departure City drop down
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		//Click on 'Bengaluru (BLR)' from departure city
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']//a[contains(text(),'Bengaluru (BLR)')]")).click();
		//Click on 'Chennai (MAA)' from arrival city
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']//a[contains(text(),'Chennai (MAA)')]")).click();
		/*
			//*[@id="ctl00_mainContent_ddl_destinationStation1_CTXT"]//a[contains(text(),'Chennai (MAA)')]
		 
		 */
		
	}

}
