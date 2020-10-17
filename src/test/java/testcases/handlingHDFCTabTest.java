package testcases;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingHDFCTabTest {
	static WebDriver driver;
	
	public static WebElement switchToModal() {
		WebElement modal = driver.switchTo().activeElement();
		return modal;
	}
	
	public static void switchToMain() {
		driver.switchTo().parentFrame();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.hdfc.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Switching focus on Pop up modal1 advertisement
		//WebElement modal1 = driver.switchTo().activeElement();
		
		WebElement modal1 =switchToModal();
		
		//Clicking on Close icon
		modal1.findElement(By.xpath("/html/body/div[2]/div[18]/div/div/div[1]/button")).click();
		
		//Switching focus back to main home page
		//driver.switchTo().parentFrame();
		
		switchToMain();
		driver.findElement(By.linkText("Careers")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		
		//driver.findElement(By.linkText("Blogs")).click();
		/*
		 * Iterator<String> itr = driver.getWindowHandles().iterator();
		 * 
		 * String parentID = itr.next(); //point to current parent window String childID
		 * = itr.next(); //point to next child window
		 * 
		 * driver.switchTo().window(childID); //switch to child window
		 * System.out.println(driver.getTitle()); //print title of child window
		 * 
		 * driver.switchTo().window(parentID); // switch to parent window
		 * System.out.println(driver.getTitle()); // print title of parent window
		 */
		Iterator<String> itr = driver.getWindowHandles().iterator();
		while(itr.hasNext()) {
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}
		
		
		
	}

}
