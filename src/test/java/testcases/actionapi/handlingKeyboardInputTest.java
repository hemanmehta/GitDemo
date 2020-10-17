package testcases.actionapi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingKeyboardInputTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(option);

		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("identifierId")).sendKeys("abc@gmail.com");
		//Fake click outside to transfer focus other than input field.
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]")).click();
		
		Actions a = new Actions(driver);
		a.keyDown(Keys.CONTROL).sendKeys(Keys.chord("a")).keyUp(Keys.CONTROL).perform();
		a.keyDown(Keys.CONTROL).sendKeys(Keys.chord("c")).keyUp(Keys.CONTROL).perform();
		driver.findElement(By.id("identifierId")).click();
		a.keyDown(Keys.CONTROL).sendKeys(Keys.chord("v")).keyUp(Keys.CONTROL).perform();
		
	}

}
