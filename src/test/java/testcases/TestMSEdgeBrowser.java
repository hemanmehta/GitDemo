package testcases;

import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMSEdgeBrowser {

	public static void main(String[] args) {
		// Using individual executiable files for browsers
		//System.setProperty("webdriver.edge.driver", "E:\\eclipse_workspace\\SeleniumLearningUdemy\\resources\\msedgedriver.exe");
		
		//Managing executables using WebDriverManager - add it to maven
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.google.com");
		driver.quit();
	}

}
  