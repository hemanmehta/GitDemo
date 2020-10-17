package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class computeSegmentLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.hollisterco.com/shop/wd");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		WebElement footer =driver.findElement(By.xpath("//*[@id='home']/footer/div[2]/div[1]/div[2]"));
		WebElement footer_About_block =driver.findElement(By.xpath("//*[@id='home']/footer/div[2]/div[1]/div[2]/ul/li[1]"));
		WebElement footer_Help_block =driver.findElement(By.xpath("//*[@id='home']/footer/div[2]/div[1]/div[2]/ul/li[2]"));
		
		List<WebElement> links_about =footer_About_block.findElements(By.tagName("a"));
		List<WebElement> links_help =footer_Help_block.findElements(By.tagName("a"));
		
		
		//Total No of Links are on the page:
		System.out.println("Total No of Links on About Section:  "+links_about.size());
		System.out.println("Total No of Links on Help Section:  "+links_help.size());
		
		//Printing All the Hyperlinks of the page
		System.out.println("-------Links on About Section----------");
		for(int i=0; i<links_about.size(); i++) 
		{
			System.out.println("Links Name:     "+links_about.get(i).getText());
			System.out.println("Links URL :     "+links_about.get(i).getAttribute("href"));
		}
		System.out.println("-------Links on Help Section----------");
		for(int i=0; i<links_about.size(); i++) 
		{
			System.out.println("Links Name:     "+links_help.get(i).getText());
			System.out.println("Links URL :     "+links_help.get(i).getAttribute("href"));
		}		 
		
	}

}
