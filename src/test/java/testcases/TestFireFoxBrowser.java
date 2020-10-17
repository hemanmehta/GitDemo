package testcases;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFireFoxBrowser {

	public static void main(String[] args) {
		// Using individual executiable files for browsers
		//System.setProperty("webdriver.gecko.driver", "E:\\eclipse_workspace\\SeleniumLearningUdemy\\resources\\geckodriver.exe");
		
		//Managing executables using WebDriverManager - add it to maven
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		String title =driver.getTitle();
		System.out.println("Page Title is:  "+title + "		Title Length is:  "+title.length());
		driver.quit();
	}

}
  