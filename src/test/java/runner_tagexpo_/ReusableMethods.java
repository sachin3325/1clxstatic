package runner_tagexpo_;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ReusableMethods 
{
	public static WebDriver driver;
	 

	
	public void Scrnshot(String filepath,WebDriver driver) throws IOException 
	{
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File SrcFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destFile=new File(filepath + ".png");
		FileUtils.copyFile(SrcFile, destFile);		
	}

	public void scrolldown(WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,3000)");
		js.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(5000);
	}
  	
	
	
		
	}

