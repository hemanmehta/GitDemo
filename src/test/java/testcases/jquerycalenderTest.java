package testcases;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jquerycalenderTest {
		
	static int currentDay=0, currentMonth=0, currentYear=0;
	static int targetDay=0, targetMonth=0, targetYear=0;
	static int jumpMonthsBy=0;
	static boolean increment=true;
	
	public static void getCurrentDayMonthYear() {
		Calendar cal = Calendar.getInstance();
		currentDay = cal.get(Calendar.DAY_OF_MONTH);
		currentMonth= cal.get(Calendar.MONTH)+1;
		currentYear=cal.get(Calendar.YEAR);
	}	
	
	public static void getTargetDayMonthYear(String dateToSet) {
		String date = dateToSet;
		String[] subdate = date.split("/");
		
		targetDay = Integer.parseInt(subdate[0]);
		targetMonth = Integer.parseInt(subdate[1]);
		targetYear = Integer.parseInt(subdate[2]);
		
	}
	
	public static void calculateMonthsToJump() {
		if((targetMonth - currentMonth) > 0 ) {
			jumpMonthsBy = (targetMonth - currentMonth);
		}
		else
		{
			jumpMonthsBy = (currentMonth - targetMonth);
			increment = false;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		String dateToSet="30/09/2020";
		getCurrentDayMonthYear();
		System.out.println(currentDay+" "+currentMonth+" "+currentYear);
		
		getTargetDayMonthYear(dateToSet);
		System.out.println(targetDay+" "+targetMonth+" "+targetYear);
		
		calculateMonthsToJump();
		System.out.println(jumpMonthsBy);
		System.out.println(increment);
		
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/datepicker/default.html"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).click();
		
		for(int i=0; i<jumpMonthsBy; i++) {
			if(increment) 
			{
				driver.findElement(By.xpath("/html/body/div/div/a[2]")).click();
			}else 
			{
				driver.findElement(By.xpath("/html/body/div/div/a[1]")).click();
			}
			Thread.sleep(1000);	
			
		}
		driver.findElement(By.linkText(Integer.toString(targetDay))).click();
		
		
		
		
		
	}

}
