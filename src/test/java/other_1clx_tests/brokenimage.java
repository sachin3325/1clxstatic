package other_1clx_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
public class brokenimage 
{

	public static void main(String[] args) 
	
	{
		
		        WebDriverManager.firefoxdriver().setup();
		        WebDriver driver = new FirefoxDriver();
		        driver.get("https://vsaconstruction.in/");

		        List<WebElement> images = driver.findElements(By.tagName("img"));
		        System.out.println(images.size());
		        
		        for (WebElement image : images) 
		        {
		            String src = image.getAttribute("src");
		            
		            try 
		            {
		                int responseCode = Utils.getResponseCode(src);
		                if (responseCode != 200)
		                {
		                    System.out.println("Broken image URL: " + src);
		                }
		               
		            } 
		            catch (Exception e) 
		            {
		                System.out.println("Error checking image URL: " + src);
		            }
		        }

		        driver.quit();
		    }
		}

		class Utils 
		{
		    public static int getResponseCode(String urlString) throws Exception 
		    {
		        URL url = new URL(urlString);
		        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		        connection.setRequestMethod("GET");
		        connection.connect();
		        return connection.getResponseCode();
		    }
		}

		
