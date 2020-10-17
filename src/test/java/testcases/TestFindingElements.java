package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindingElements {
	private static WebElement username;
	private static WebElement nextButton;
	private static WebElement password;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		username = driver.findElement(By.id("identifierId"));
		username.sendKeys("heman.mehta07@gmail.com");
		
		driver.quit();
		
	}

}
