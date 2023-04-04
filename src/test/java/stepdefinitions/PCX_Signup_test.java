package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PCX_Signup_test 
{
	public static WebDriver driver;
	static String value;
	
	@SuppressWarnings("deprecation")
	@Given("user able to enter 1clx sign-up page")
	public void user_able_to_enter_1clx_sign_up_page() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.1clxlite.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		WebElement signupbtn = driver.findElement(By.xpath("//span[contains(text(),'Sign Up')]"));
		signupbtn.click();
		
		Thread.sleep(5000);
				
		
	}
	
	@When("the user enters the {string},{string},and {string}")
	public void the_user_enters_the_and(String string, String string2, String string3) throws InterruptedException 
	{
		WebElement entername= driver.findElement(By.xpath("//input[@id='name']"));
		entername.sendKeys(string);
		Thread.sleep(3000);
		
		WebElement entermail = driver.findElement(By.xpath("//input[@id='remail']"));
		entermail.sendKeys(string2);
		Thread.sleep(3000);
		
		WebElement enterpass = driver.findElement(By.xpath("//input[@id='password']"));
		enterpass.sendKeys(string3);
		Thread.sleep(3000);
		
		
	}
	
	@When("the user clicks the Create Account button.")
	public void the_user_clicks_the_create_account_button() throws InterruptedException 
	{
		WebElement subbtn = driver.findElement(By.xpath("//button[@id='susubmit']"));
		subbtn.click();
		Thread.sleep(3000);

	}
	
	@Then("User gets the results depends on their entering credentials")
	public void user_gets_the_results_depends_on_their_entering_credentials() throws InterruptedException 
	{
		
		
		  WebElement entercode =driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/nav[1]/ul[1]/li[3]/a[1]"));
		  entercode.sendKeys("35353674");
		  Thread.sleep(3000);
		  
		  WebElement verifycode = driver.findElement(By.xpath("//body/div[@id='signin']/div[@id='progress22']/div[@id='form']/div[2]/div[1]/form[1]/div[3]/button[1]"));
		  verifycode.click();
		  Thread.sleep(3000);
		 
		
		
			/*
			 * if(entercode.isDisplayed() && verifycode.isDisplayed() ) {
			 * entercode.sendKeys("35353674"); Thread.sleep(3000); verifycode.click();
			 * Thread.sleep(3000); //driver.close(); } else { driver.quit(); }
			 */
		 
		
		

		
		
		
	}




}
