package com.Qfix_Payment.com.Qfix_Payment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Payment {
	
	public static WebDriver driver;
	public static Select dropdown;
	
	
	@BeforeTest
	public void beforeClass() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demostores.eduqfix.com/marketplace/account/login");
		Thread.sleep(3000);
	}

	@AfterTest
	public void afterClass() throws InterruptedException {
		Thread.sleep(5000);
		//driver.quit();
	}

	@Test(priority=1)
	public void Production_Login(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement username= driver.findElement(By.xpath("//input[@id='email']"));
		username.sendKeys("demoseller@test.com");
		WebElement password= driver.findElement(By.xpath("//input[@id='pass']"));
		password.sendKeys("Demo@123");
		WebElement loginClk = driver.findElement(By.xpath("//span[contains(text(),'Sign in')]"));
		loginClk.click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//String title= "";
		//Assert.assertEquals(title, driver.getTitle());
	}
	
	@Test(priority=2)
	public void Click_Home(){
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Homeclk= driver.findElement(By.xpath("/html[1]/body[1]/div[2]/header[1]/div[2]/div[3]/a[1]"));
		Homeclk.click();
		
		}
	
	@Test(priority=3)
	public void Product_clk() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement product_clk = driver.findElement(By.xpath("//li[4]//div[1]//div[1]//a[1]//span[1]//span[1]"));
		product_clk.click();
		Thread.sleep(3000);
		
		WebElement Select_product = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/form[1]/div[1]/div[1]/div[2]/button[1]/span[1]"));
		Select_product.click();	
		Thread.sleep(3000);
		
		WebElement Add_to_cart = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/header[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[5]/div[1]/a[1]"));
		Add_to_cart.click();
		Thread.sleep(3000);
		}
	
	@Test(priority=4)
	public void checkout() throws InterruptedException{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement cart_clk = driver.findElement(By.xpath("//div[@class='header_right_wrapper col-lg-4']//div[@class='minicart-wrapper']"));
	cart_clk.click();
	Thread.sleep(300);
	
	WebElement checkout_clk =  driver.findElement(By.xpath("//div[@id='ui-id-2']//a[@class='default-btn btn-gradient']"));
	checkout_clk.click();
	Thread.sleep(300);
	
	}
	@Test(priority=5)
	public void checkout_Details() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement Proceed_clk = driver.findElement(By.xpath("//button[@class='button action continue primary']"));
		Proceed_clk.click();
		Thread.sleep(300);
	}
	
}