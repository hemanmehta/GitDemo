package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTest {
	private static By ddown = By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[1]/tbody/tr/td/table/tbody/tr[2]/td[3]/select");
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://echoecho.com/htmlforms11.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement dropdown = driver.findElement(ddown);
		Select s1 = new Select(dropdown);
		s1.selectByIndex(1);
		s1.selectByVisibleText("Milk");
		WebElement dropdownFirst = driver.findElement(By.name("dropdownmenu"));
		//To find total count of the available options
		List<WebElement> values = dropdownFirst.findElements(By.tagName("option"));
		System.out.println("Total No of Available Options in Dropdown    :"+values.size());
		
		//Printing All the elements of options
		//List starts from 0 to SIZE-1
		for(int i=0; i<values.size(); i++) {
			System.out.println(values.get(i).getText());
		}
		
		//List<WebElement> optionList1 = s1.getOptions();
				driver.quit();
		
	}

}
