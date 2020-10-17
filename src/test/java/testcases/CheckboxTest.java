package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import testcases.isElementPresentTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/*
		 * for(int i=1; i<=4; i++)
		 * driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
		 */

		WebElement checkboxBlock = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		List<WebElement> checkboxes = checkboxBlock.findElements(By.tagName("input"));
		System.out.println("Total No of CheckBoxes are--"+checkboxes.size());
		
		for(WebElement cbox : checkboxes) {
			cbox.click();
		}
		
		driver.quit();

	}

}
