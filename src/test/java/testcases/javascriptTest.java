package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javascriptTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[@class='lbl_input latoBold  appendBottom5'][contains(text(),'From')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='root']//div[@role='combobox']/input[@placeholder='From']")).sendKeys("MUMBAI");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='root']//div[@role='combobox']/input[@placeholder='From']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//*[@id='root']//div[@role='combobox']/input[@placeholder='From']")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		
		String script ="return document.getElementById(\"fromCity\").value";
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		
		String result = js.executeScript(script).toString();
		System.out.println(result);
		


	}

}
