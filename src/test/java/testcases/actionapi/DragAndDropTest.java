package testcases.actionapi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement itemToDrop = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		
		WebElement droppable = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		
		new Actions(driver).dragAndDrop(itemToDrop, droppable).perform();
		
		//To drag n drop element on specific location
		//new Actions(driver).dragAndDropBy(itemToDrop, 400, 350).perform();
		
	}
	

}
