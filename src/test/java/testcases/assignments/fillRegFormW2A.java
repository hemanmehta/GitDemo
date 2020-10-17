package testcases.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fillRegFormW2A {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//Navigate to Way2automation.com
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Locate the Registration Form in the Page
		WebElement regForm = driver.findElement(By.className("ajaxsubmit"));
		//Select Username Field and set the value
		regForm.findElement(By.name("name")).sendKeys("DummyUserName");
		//Click on Submit button inside same form.
		regForm.findElement(By.className("button")).click();
		driver.quit();
	}

}
