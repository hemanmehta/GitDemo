package testcases.actionapi;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.jar.asm.Opcodes;

public class handlingPopupTabsTest {
	public static WebDriver driver;
		public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		driver = new ChromeDriver(option);

		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"custom-button\"]/button")).click();
		driver.switchTo().activeElement();
		
		//2nd Page - Clicking on Login Button
		driver.findElement(By.xpath("//div[@class='login-button-options']/a[1]")).click();
		//Opening Debit Card Info page in new Tab
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div[1]/div/a")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		
		//3rd Page - Validating targeted page from all the open tabs.
		Iterator<String> itr = driver.getWindowHandles().iterator();
		while(itr.hasNext()) {
			driver.switchTo().window(itr.next());
			
			if(driver.getTitle().contains("EasyShop Platinum Debit Card"))
				System.out.println("Third Page is validated.");
			
			//driver.close();
			
		}
		
			
	}
}
