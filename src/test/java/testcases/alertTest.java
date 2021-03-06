package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alertTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Visit Spicejet.com
		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/form/input")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		System.out.println("Test Message1");
		System.out.println("Test Message2");
		System.out.println("Test Message3");
		
		//By User X
		System.out.println("Test Message4 by User X");
		System.out.println("Test Message5 by User X");
		
		//Develop Branch Asian Time Zone Architect1
		System.out.println("New Message-1 by Asian Timezone Architect1");
		System.out.println("New Message-2 by Asian Timezone Architect1");
		
		
	}

}
