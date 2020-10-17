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

public class handlingTabTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.hollisterco.com/shop/wd");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		WebElement footer =driver.findElement(By.xpath("//*[@id='home']/footer/div[2]/div[1]/div[2]"));
		WebElement footer_About_block =driver.findElement(By.xpath("//*[@id='home']/footer/div[2]/div[1]/div[2]/ul/li[1]"));
		//WebElement footer_Help_block =driver.findElement(By.xpath("//*[@id='home']/footer/div[2]/div[1]/div[2]/ul/li[2]"));
		
		List<WebElement> links_about =footer_About_block.findElements(By.tagName("a"));
		//List<WebElement> links_help =footer_Help_block.findElements(By.tagName("a"));
		
		//Opening the Links in new Tabs.
		for(int i=0; i<links_about.size(); i++) {
			String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			links_about.get(i).sendKeys(clickOnLinkTab);
			Thread.sleep(1000);
		}
		/*
		 * getWindowHandles() returns Return a set of window handles which can be used
		 * to iterate over all open windows of this WebDriver instance by passing them
		 * to switchTo().WebDriver.Options.window()
		 */
	
		
		Iterator<String> itr = driver.getWindowHandles().iterator();
		while(itr.hasNext()) {
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}
		
	}

}
