package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mouseHoverActionTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Visit Spicejet.com
		driver.get("https://americangolf.co.uk");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[@class='a-level-1'][contains(text(),'Golf Clubs')]"))).build().perform();
		//driver.findElement(By.xpath("//a[@class='a-level-1'][contains(text(),'Golf Clubs')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='CLUBS_1']//span[@class='name'][contains(text(),'Drivers')]")));
		driver.findElement(By.xpath("//div[@id='CLUBS_1']//span[@class='name'][contains(text(),'Drivers')]")).click();
		
		
	}

}
