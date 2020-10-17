package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.Soundbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class comboBoxTest {
			
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.jobserve.com/in/en/Job-Search/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='ddcl-selInd']/span/span")).click();
		Thread.sleep(1000); // Added to just see slowness in output for proper visibility
		driver.findElement(By.xpath("//*[@id='ddcl-selInd-i0']")).click();
		
		String industry = "Education";
		
		List<WebElement> allindustries = driver.findElements(By.xpath("//div[@id='ddcl-selInd-ddw']/div/div/label"));
		
		for(int i=0; i<allindustries.size(); i++) {
			System.out.print(allindustries.get(i).getText());
			System.out.println();
			
			if(allindustries.get(i).getText().equals(industry)) {
				allindustries.get(i).click();
			}
			
		}
	
		
		
	}

}
