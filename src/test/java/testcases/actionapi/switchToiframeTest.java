package testcases.actionapi;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class switchToiframeTest {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(option);

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//you can also switch frames without name or id using switchTo.frames(0)
		driver.switchTo().frame("iframeResult");
		//JS Script is already defined on above mentioned url, we are just injecting invocation of script.
		String script="myFunction()";
		((JavascriptExecutor)driver).executeScript(script);
		//Commented click event so that JS script is not executed upon onClick event.
		//driver.findElement(By.xpath("/html/body/button")).click();
				
		//Injecting User defined JS to highlight button with red color.
		String script_highlightElement = "arguments[0].style.border='3px solid red'";
		((JavascriptExecutor)driver).executeScript(script_highlightElement,driver.findElement(By.xpath("//*[@id='mySubmit']")));
		
		
		driver.switchTo().parentFrame();
		
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println("Total No of iframe Tags:"+iframeList.size());
		
		for(WebElement iframe : iframeList) {
			System.out.println(iframe.getAttribute("id"));
		}
		
	}
}
