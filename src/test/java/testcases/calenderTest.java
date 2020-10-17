package testcases;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calenderTest {

	public static void main(String[] args) throws InterruptedException, ParseException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='departureCalendar']")).click();
		Thread.sleep(2000);
		
		String d = "7/09/2021";	//dd/mm/yyyy
		String[] months= {"January","February","March","April","May","June","July","August","September","October","November","December"};
		
		//extract day,month,year
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date mydate = df.parse(d);
		Calendar cal = Calendar.getInstance();
		cal.setTime(mydate);
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int yr =cal.get(Calendar.YEAR);
		String travelMonth = months[month]+" "+yr;
		System.out.println(travelMonth);
		
		String forwardArrow = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"; 
		String xpathMonthYearSelection = "//div[@class='DayPicker-Caption']";
		
		  while(!driver.findElement(By.xpath(xpathMonthYearSelection)).getText().equals(travelMonth)) {
			  driver.findElement(By.xpath(forwardArrow)).click();
		  }
		  
		  //select desired day in calendar
		  driver.findElement(By.xpath("//div[text()='"+day+"']")).click();
		 
		
		
		
	}

}
