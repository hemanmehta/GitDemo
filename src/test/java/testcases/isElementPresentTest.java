package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class isElementPresentTest {
	
	private static WebDriver driver;
	public static boolean isElementPresent(By locator) {
		try {
			driver.findElement(locator);
			return true;
			
		}catch(Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*
		 * 	isEnabled - Checks button is enabled or not
		 * 	isSelected - Checks for option is selected or not
		 * 	isDisplayed - Checks for visibility of an element. It does not check whether Element is present in HTML DOM or not.
		 * 	(And there is not built in method in selenium lib to check the presence of an element.)
		 * 	
		 */
		System.out.println(isElementPresent(By.xpath("//*[@id=\"searchLanguage\"]")));
		System.out.println(driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]")).isEnabled());
		
		driver.quit();
		
		
		
	}

}
