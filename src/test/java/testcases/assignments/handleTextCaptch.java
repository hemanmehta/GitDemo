package testcases.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleTextCaptch {
	private static long x;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//Navigate to URL
		driver.get("https://timesofindia.indiatimes.com/poll.cms");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Fetch the captcha values as String and split by single white space
		String que = driver.findElement(By.xpath("//*[@id=\"mathq2\"]")).getText();
		String[] question = que.split(" ");
		
		//Performing operations
		if(question[1].equalsIgnoreCase("+")) {
			x = Long.parseLong(question[0]) + Long.parseLong(question[2]); 
			
		}else if(question[1].equalsIgnoreCase("-")) {
			x = Long.parseLong(question[0]) - Long.parseLong(question[2]); 
			
		}else {
			x = Long.parseLong(question[0]) * Long.parseLong(question[2]); 
		}
		
		String str = Long.toString(x);
		//Setting answer to captch result box
		driver.findElement(By.xpath("//*[@id=\"mathuserans2\"]")).sendKeys(str);
		driver.quit();
	}

}
