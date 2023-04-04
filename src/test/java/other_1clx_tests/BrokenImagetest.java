package other_1clx_tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenImagetest 
{
	
	public static WebDriver driver;
	public static int invalidImageCount;
	
	
  @Test
  public void f() 
  {
	  
	  try 
	  {
			invalidImageCount = 0;
			List<WebElement> imagesList = driver.findElements(By.tagName("img"));
			System.out.println("Total no. of images are " + imagesList.size());
			for (WebElement imgElement : imagesList)
			{
				if (imgElement != null) 
				{
					verifyimageActive(imgElement);
				}
			}
			
			System.out.println("Total no. of invalid images are " + invalidImageCount);
		} 
	  
	  catch (Exception e) 
	  {
			e.printStackTrace();
			System.out.println(e.getMessage());
	  }
  
  }
  
  @SuppressWarnings("deprecation")
@BeforeClass
  public void beforeClass() 
  {
	    WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	    
		driver.get("https://vsaconstruction.in/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  
  }

  @AfterClass
  public void afterClass() 
  {
	  if (driver != null)
			driver.quit();
  }
  
  public void verifyimageActive(WebElement imgElement) 
  {
		try 
		{
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			
			if (response.getStatusLine().getStatusCode() != 200)
				invalidImageCount++;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
  
  
  }
}
