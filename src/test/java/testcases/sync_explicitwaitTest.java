package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sync_explicitwaitTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		//Visit site
		//navigate.to() stores the browser history and cookie so that we can navigate back n forth.
		//driver.get() never stores the history and wait till whole page loaded every time
		driver.navigate().to("https://alaskatrips.poweredbygps.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='package-origin-hp-package']")).sendKeys("nyc");
		Thread.sleep(2000); //Hard Wait for 2 Seconds even though element is present within 1 Second.
		driver.findElement(By.xpath("//*[@id='package-origin-hp-package']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//*[@id='package-origin-hp-package']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='package-origin-hp-package']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//*[@id='package-origin-hp-package']")).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='package-destination-hp-package']")).sendKeys("AH");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='package-destination-hp-package']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//*[@id='package-destination-hp-package']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='package-destination-hp-package']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//*[@id='package-destination-hp-package']")).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='package-departing-hp-package']")).sendKeys("05/21/2020");
		driver.findElement(By.xpath("//*[@id='package-departing-hp-package']")).sendKeys(Keys.ENTER);
		//Thread.sleep(15000); //BAD PRACTICE
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'We were unable')]")));
		System.out.println(driver.findElement(By.xpath("//h5[contains(text(),'We were unable')]")).getText());

	}

}
