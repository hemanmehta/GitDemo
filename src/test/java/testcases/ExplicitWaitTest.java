package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.manage().window().maximize();
		//Locate Enable Button from Page and Perform Click.
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button")).click();
		//Now Apply Explicit Wait until specific Text is not shown UP
		WebDriverWait wait = new WebDriverWait(driver, 5);
		//Applying ExpectedCondition on the specific element
		if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"message\"]"), "It's enabled!")))
			System.out.println("Explicit Wait ran correctly.");
		
		
		driver.quit();
		

	}

}
