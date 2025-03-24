package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.commons.io.FileUtils;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "D:/Coding/College/SIT333/Task1.1/driverWorking/chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement firstName = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + firstName);
		// Send first name
		firstName.sendKeys("Ahsan");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		WebElement lastName = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + lastName);
		// Send last name
		lastName.sendKeys("Khan");
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		WebElement button= driver.findElement(By.className("iJIqgV"));
		System.out.println("Found element: " + button);
		// Click button
		button.click();
		
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		TakesScreenshot screenshot = (TakesScreenshot) driver;  
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);  // Capture screenshot

        // Define path to save screenshot
        File destFile = new File("C:/Users/samri/Downloads/screenshot.png");

        // Save the screenshot using Apache Commons IO
        try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

        System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());

		// Sleep a while
		sleep(5);
		
		// close chrome driver
		driver.close();	
	}
	
	
}
