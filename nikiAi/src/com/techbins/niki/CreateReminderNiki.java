package com.techbins.niki;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author partha.jena
 *
 */

public class CreateReminderNiki 
{
	AndroidDriver driver;
	
	@BeforeTest(description="To start appium server and open niki app")
	public void setUp() throws Exception
	{
		//start appium server
		OpenAppiumServer.startAppiumSever();
		
		// created object of DesiredCapabilities class
		DesiredCapabilities capabilites=new DesiredCapabilities();
		
		//set device name Desired Capability
		capabilites.setCapability("deviceName", "32085e1011e5714d");
		
		//set BROWSER_NAME Desired Capability
		capabilites.setCapability(CapabilityType.BROWSER_NAME, "");
		
		//set platformVersion and platformName Desired Capability
		capabilites.setCapability("platformVersion", "6.0.1");
		capabilites.setCapability("platformName", "Android");
		
		//set appPackage and appActivity Desired Capability for niki.ai app
		capabilites.setCapability("appPackage", "com.techbins.niki");
		capabilites.setCapability("appActivity", "com.techbins.niki.SplashActivity");
		
		//Set appium server address and port number in URL string
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilites);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	@Test
	public void createReminder() throws Exception
	{
		// Tap on menu bar
		driver.findElement(By.xpath("//android.widget.ImageButton[contains(@content-desc,'Open navigation drawer')]")).click();
		
		// Tap on improve my experience 
		driver.findElement(By.xpath("//android.widget.TextView[@text='Improve My Experience']")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//Tap on create a new reminder
		 driver.findElement(By.xpath("//android.widget.TextView[@text='+ CREATE A NEW REMINDER']")).click();
		 		 
		 //Enter reminder title
		 driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'reminderTitle')]")).sendKeys("cab");
		 driver.hideKeyboard();
		 
		 // select type of reminder 
		 driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'frequencyMonthly')]")).click();
		 
		 //Tap on save and continue button
		 driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'saveReminderButton')]")).click();
		 
		 //Verify after creating remaining days displayed
		 Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'tvRemainingDays')]")).isDisplayed(),"created reminder is not active");
		 
	
    }
	
	@AfterTest(description="To stop driver and appium server")
	public void end() throws Exception
	{
		driver.quit();
		driver.lockDevice();
		
		// To stop appium server
		OpenAppiumServer.stopAppiumServer();
		
	}
	
}


