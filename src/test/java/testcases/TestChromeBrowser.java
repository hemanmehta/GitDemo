package testcases;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestChromeBrowser {

	public static void main(String[] args) {
		// Using individual executiable files for browsers
		//System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\SeleniumLearningUdemy\\resources\\chromedriver.exe");
		
		//Managing executables using WebDriverManager - add it to maven
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.quit();
	}

}
  