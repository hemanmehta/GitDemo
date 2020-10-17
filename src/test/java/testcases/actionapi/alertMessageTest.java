package testcases.actionapi;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alertMessageTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(option);

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		
		
		  Alert alertMessage = driver.switchTo().alert();
		  System.out.println("Alert Message:"+alertMessage.getText());
		  alertMessage.accept();
		 
		
			/*
			 * WebDriverWait wait = new WebDriverWait(driver, 10); Alert alertMessage =
			 * wait.until(ExpectedConditions.alertIsPresent());
			 * System.out.println("Alert Message:"+alertMessage.getText());
			 * alertMessage.accept();
			 */	

	}
}
