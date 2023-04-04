package other_1clx_tests;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.emulation.Emulation;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Responsive_test 
{
  
	public static WebDriver driver;

	 @DataProvider
	  public Object[][] mobileEmulation()
	  {
		return new Object[][]
				
				{
			
			{1280, 1024, 50,"Windows 11"},
			{320,480,40,"Iphone 4"},
			{414,896,50,"Iphone XR"},
			{390,844,50,"Iphone 12 pro"},
			{820,1180,40,"Ipad Air"},
			{320,568,75,"Iphone 5"},
			{375,812,64,"Iphone X"},
			{768,1024,50,"Ipad"},
			{375,667,78,"Iphone_6_7_8_"},
			{414,736,50,"Iphone_6_7_8_Plus"},
			{768,1024,50,"Ipad Mini"},
			{1024,1366,38,"Ipad Pro"},
			{375,667,78,"Iphone SE"},
			{360,640,80,"(360x640)"},
			{360,740,70,"(360x740)"},
			{320,658,79,"Galaxy S9 Plus"},
			{712,1138,45,"Galaxy Tab S4"},
			{412,915,57,"Galaxy S20 Ultra"},
			{280,653,79,"Galaxy Fold"},
			{412, 914, 50,"Galaxy A51 & A71"},
			{600,1024,50,"Blackberry Playbook1"},
			{800,1280, 40,"Kindle Fire HDX"},
			{384,640,75,"LG Optimus L70"}, 
			{640,360,100,"Microsoft Lumia 550"},
			{800,1280,40,"Nexus 10"},
			{384,640,75,"Nexus 4"},
			{412,732,50,"(412x732)"},
			{600,960,50,"Nexus 7"},
			{320,533,97,"Nokia Lumia 520"},
			{480,854,50,"Nokia N9"}, 
			{393,786,66,"(393x786)"},
			{353,745,70,"Pixel 4"},
			{393,851,61,"Pixel 5"}, 
			{912,1368,38,"Surface Pro 7"},
			{540,720,70,"Surface Duo"}, 
			{1024,600,50,"Nest Hub"},
			{1280,800,50,"Nest Hub Max"},
			{411,731,71,"Pixel 2"},
			{411,823,63,"Pixel 2XL"}, 
			{240,320,100,"JioPhone"},
			 	

			
			
	};  
	}
	
	
	
	
	
	
 @SuppressWarnings("deprecation")
@Test(dataProvider = "mobileEmulation")
 public void f(int height,int depth,int zoom,String name) throws InterruptedException, IOException 
 {
	  
	    WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver =new FirefoxDriver();
		driver.manage().window().maximize();
		DevTools devtool=driver.getDevTools();
		devtool.createSession();
		devtool.send(Emulation.setDeviceMetricsOverride(height,depth,zoom,true,
				Optional.empty(), 
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty()));
		
		driver.get("https://pasumai.tba.ai/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		JavascriptExecutor j = (JavascriptExecutor)driver;
		

		
		 if (j.executeScript("return document.readyState").toString().equals("complete"))
		 {
			 
	         System.out.println("Page has loaded");
	         j.executeScript("window.scrollBy(0,2000);");
	         Thread.sleep(2000);
	         j.executeScript("window.scrollBy(0,2000);");
	         Thread.sleep(2000);
	         j.executeScript("window.scrollBy(0,2000);");
	         Thread.sleep(2000);
	         j.executeScript("window.scrollBy(0,2000);");
	         Thread.sleep(2000);
				/*
				 * j.executeScript("window.scrollBy(0,2000);"); Thread.sleep(5000);
				 * j.executeScript("window.scrollBy(0,2000);"); Thread.sleep(5000);
				 * j.executeScript("window.scrollBy(0,2000);"); Thread.sleep(5000);
				 * j.executeScript("window.scrollBy(0,2000);"); Thread.sleep(5000);
				 */
	         j.executeScript("window.scrollBy(0,-4000);");
	         Thread.sleep(3000);
	         j.executeScript("window.scrollBy(0,-4000);");
	         Thread.sleep(3000);
				/*
				 * j.executeScript("window.scrollBy(0,-3000);"); Thread.sleep(5000);
				 * j.executeScript("window.scrollBy(0,-3000);"); Thread.sleep(5000);
				 * j.executeScript("window.scrollBy(0,-3000);"); Thread.sleep(5000);
				 */
	         
	         Thread.sleep(5000);
	         
	        File src=((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
	     	FileHandler.copy(src, new File("C:\\Users\\Sachithanandhan.S\\eclipse-workspace3\\tagexpo\\Pasumai_Power\\"+name+".png"));
		 }
	     else
	     {
	 	   	 System.out.println("Page has not loaded yet ");
	 	 }
	}
	
 
}
