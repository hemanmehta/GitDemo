package testcases.assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class countLinkW2A {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//Navigate to Google.com
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Searching for way2automation in the Search box
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("way2automation");
		//Performing click on Google Search Button
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).click();
		//Performing Click on Very First Search Result
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a")).click();
		
		//Finding total no of links on opened New WebPage i.e. way2automation.com
		List<WebElement> links =driver.findElements(By.tagName("a"));
		
		//Total No of Links are on the page:
		System.out.println("Total No of Links on the page:  "+links.size());
		
		//Printing All the Hyperlinks of the page
		for(int i=0; i<links.size(); i++) {
			System.out.println("Links Name:     "+links.get(i).getText());
			System.out.println("Links URL :     "+links.get(i).getAttribute("href"));
		}
		driver.quit();
	}
	
}
