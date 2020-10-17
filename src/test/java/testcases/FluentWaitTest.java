package testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.manage().window().maximize();
		//Locate Enable Button from Page and Perform Click.
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button")).click();
		//Now Apply Fluent Wait until specific Text is not shown UP
		Wait<WebDriver> wait = new FluentWait<WebDriver> (driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(2))
				.withMessage("Fluent Wait TRiggered")
				.ignoring(NoSuchElementException.class);
		
		
		
		//Applying ExpectedCondition on the specific element
		if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"message\"]"), "It's enabled!")))
			System.out.println("Fluent Wait ran successfully.");
		
		
		driver.quit();
		

	}

}
