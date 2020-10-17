package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sync_hardwaitTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Visit site
		//navigate.to() stores the browser history and cookie so that we can navigate back n forth.
		//driver.get() never stores the history and wait till whole page loaded every time
		driver.navigate().to("https://alaskatrips.poweredbygps.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='package-origin-hp-package']")).sendKeys("nyc");
		Thread.sleep(2000); //Hard Wait for 2 Seconds even though element is present within 1 Second.
		driver.findElement(By.xpath("//*[@id='package-origin-hp-package']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//*[@id='package-origin-hp-package']")).sendKeys(Keys.ENTER);
			

	}

}
