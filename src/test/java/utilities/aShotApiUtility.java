package utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utilities.captureScreenshotUtility;

public class aShotApiUtility {
	public static WebDriver driver;
	
	public static void captureScreenshot(WebDriver driver) throws IOException 
	{ 
		Date d = new Date();
		String filename = d.toString().replace(":","_").replace(" ", "_")+".jpeg";
		
		//capturing Full Image Screenshot
		Screenshot fullScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(fullScreenshot.getImage(), "jpeg", new File("resources\\screenshots\\ashot_"+filename));	
	}
	
	public static void captureElementScreenshot(By locator) throws IOException 
	{ 
		Date d = new Date();
		String filename = d.toString().replace(":","_").replace(" ", "_")+".jpeg";
		
		//Capturing Screenshot at specific Element
		WebElement ele = driver.findElement(locator);
		Screenshot eleScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,ele);
		ImageIO.write(eleScreenshot.getImage(), "jpeg", new File("resources\\screenshots\\ashot_elementImage.jpeg"));
	
	}
	
		

			
		
		
		

}
