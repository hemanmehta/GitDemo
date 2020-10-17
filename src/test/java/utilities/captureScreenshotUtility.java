package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class captureScreenshotUtility {
	
	public static void captureScreenshot(WebDriver driver) throws IOException 
	{ 
		Date d = new Date();
		String filename = d.toString().replace(":","_").replace(" ", "_")+".jpeg";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("resources\\screenshots\\"+filename));
	}
	
	public static void captureElementScreenshot(WebElement element) throws IOException 
	{
		String screenshotName;
		File scrFile = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + "_element.jpg";
		FileUtils.copyFile(scrFile,new File("resources\\screenshots\\" + screenshotName));
		
		/*
		 * Point elepoint =ele.getLocation(); int elewidth = ele.getSize().getWidth();
		 * int eleheight = ele.getSize().getHeight();
		 * 
		 * File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * BufferedImage fullimage = ImageIO.read(screenshot);
		 * 
		 * BufferedImage elementScreenshot = fullimage.getSubimage(elepoint.getX(),
		 * elepoint.getY(), elewidth, eleheight);
		 * 
		 * //Description - ImageIO.write(RenderImageFile, OutputFormat, OutputFile );
		 * ImageIO.write(elementScreenshot, "jpeg", screenshot );
		 * 
		 * File elementScreenshotLocation = new
		 * File("resources\\screenshots\\googlelogo.jpeg");
		 * FileUtils.copyFile(screenshot, elementScreenshotLocation);
		 */
	}
	

}
