package testcases.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowSizeTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");
		
		int currentWidth = driver.manage().window().getSize().width;
		int currentHeight = driver.manage().window().getSize().height;

		for (int i=currentWidth ; i>100; i-=50) {
			Thread.sleep(100);
			Dimension min =  new Dimension(i,i);
			driver.manage().window().setSize(min);
		}

		for ( int i=200; i<=currentHeight; i+=50) {
			Thread.sleep(100);
			Dimension max =  new Dimension(i,i);
			driver.manage().window().setSize(max);

		}
	}
	

}
