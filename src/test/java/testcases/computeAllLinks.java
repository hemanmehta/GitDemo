package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class computeAllLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> links =driver.findElements(By.tagName("a"));
		
		//Total No of Links are on the page:
		System.out.println("Total No of Links on the page:  "+links.size());
		
		//Printing All the Hyperlinks of the page
		for(int i=0; i<links.size(); i++) {
			System.out.println("Links Name:     "+links.get(i).getText());
			System.out.println("Links URL :     "+links.get(i).getAttribute("href"));
		}
		
		//By User X
		System.out.println("Test Message6 by User X");
		
		//Develop Branch American Time Zone Architect2
		System.out.println("New Message-3 by American Timezone Architect2");
		System.out.println("New Message-4 by American Timezone Architect2");

	}

}
