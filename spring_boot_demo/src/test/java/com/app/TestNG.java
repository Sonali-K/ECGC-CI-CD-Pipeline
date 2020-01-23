package com.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.config.PropertiesFile;
import com.app.log4j.Log4jDemo;

public class TestNG {
	
	WebDriver driver = null;
	public static String browserName=null;
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		
		 if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/home/cdac-kharghar2/STS-Workspace-N/spring_boot_demo/drivers/geckodriver/geckodriver");
			driver = new FirefoxDriver();
		}
		
		
		logger.info("Browser started");
		
	}

	@Test
	public void googleSearch() {
			
		//goto google.com
		driver.get("http://localhost:4200/");
		logger.info("Navigated to webapplication UI");
		
		//enter text in search textbox
		//driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		
		//click on search button
		//driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.id("1"));

		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
	}
	
	@AfterTest
	public void tearDownTest() {
		
		//close browser
				driver.close();
				//driver.quit();
				System.out.println("Test Completed Successfully");
				PropertiesFile.setProperties();
		
	}


}
