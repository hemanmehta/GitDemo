package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ajaxDropdownTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		
		WebDriver driver = new ChromeDriver();
		

		driver.get("https://gsrtc.in/site/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Closing modal pop-up
		//driver.findElement(By.id("cboxClose")).click();
		driver.switchTo().activeElement().findElement(By.xpath("//div[@id='colorbox']//button[@id='cboxClose']")).click();
		driver.switchTo().parentFrame();
		//checking active screen focus
		System.out.println(driver.switchTo().parentFrame().getTitle());
		
		WebElement sourceField = driver.findElement(By.id("matchStartPlaceA"));
	    sourceField.clear();
	    sourceField.click();
	    sourceField.sendKeys("rajk");
	     
	    driver.findElement(By.xpath("//*[contains(text(),'RAJKOT CENTRAL BUSSTAND')]")).click();

		



	}

}
