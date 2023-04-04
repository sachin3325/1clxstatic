package stepdefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import runner_tagexpo_.ReusableMethods;

public class ECX_SignIn_Test extends ReusableMethods
{
  
 public static WebDriver driver;
 
 ReusableMethods obj=PageFactory.initElements(driver, ReusableMethods.class);
 
	
@SuppressWarnings("deprecation")

@Given("user able to enter 1clx sign-in page")
public void user_able_to_enter_1clx_sign_in_page() throws InterruptedException 
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.1clxlite.com");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	WebElement loginbtn = driver.findElement(By.xpath("//header/div[@id='sticky-header-sticky-wrapper']/div[@id='sticky-header']/div[1]/div[2]/div[3]/a[1]"));
	loginbtn.click();
	Thread.sleep(3000);
	WebElement element = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
	element.click();
	Thread.sleep(3000);
}

@When("the user enters the {string} and {string}")
public void the_user_enters_the_and(String string, String string2) throws InterruptedException 
{
	WebElement entermail = driver.findElement(By.xpath("//input[@id='email']"));
	entermail.sendKeys(string);
	Thread.sleep(3000);
	WebElement enterpass = driver.findElement(By.xpath("//input[@id='lpassword']"));
	enterpass.sendKeys(string2);
	Thread.sleep(3000);
	
	
}

@When("the user clicks the SignIn button.")
public void the_user_clicks_the_sign_in_button() throws InterruptedException 
{
	WebElement subbtn = driver.findElement(By.xpath("//button[@id='sisubmit']"));
	subbtn.click();
	Thread.sleep(3000);
	
	
	
}

@Then("User gets the results depends on their credentials")
public void user_gets_the_results_depends_on_their_credentials() throws IOException, InterruptedException
{
	if (driver.getPageSource().contains("Invalid Credential") || driver.getPageSource().contains("Enter Your Password"))
	{
		
		System.out.println("Errormsg Showing....!");
		
		Thread.sleep(5000);
		
		driver.close();
		
	} 
	else 
	{
       String title=driver.getTitle();
       System.out.println(title);
       
	}
}


}
