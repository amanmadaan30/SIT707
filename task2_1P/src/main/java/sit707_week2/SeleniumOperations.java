package sit707_week2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

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
	
	
	public static void officeworks_registration_page(String url) throws IOException {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64/chromedriver.exe");
		
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

		/*
		 * Find following input fields and populate with values
		 */
		// Write code

		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Aman");

		element = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + element);
		// Send last name
		element.sendKeys("Madaan");

		element = driver.findElement(By.cssSelector("input#phoneNumber"));
		System.out.println("Found element: " + element);
		// Send phone number
		sleep(2);
		element.sendKeys("0464538247");

		element = driver.findElement(By.xpath("//input[@id='email']"));
		System.out.println("Found element: " + element);
		// Send email address
		element.sendKeys("amanmadaan20@gmail.com");

		element = driver.findElement(By.cssSelector("input#password"));
		System.out.println("Found element: " + element);
		// Send password
		element.sendKeys("Aman@4321");

		element = driver.findElement(By.cssSelector("input#confirmPassword"));
		System.out.println("Found element: " + element);
		// Send password
		element.sendKeys("Aman@4321");

		sleep(2);
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		element = driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.println("Found element: " + element);
		// Submit create account button
		//element.click();
		sleep(2);
		if(element.isEnabled()) {
			element.click();
		}
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("ss.png"));
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver

		// let us now complete registration on another website...
		driver.get("https://www.chemistwarehouse.com.au/login");

		element = driver.findElement(By.id("name"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Aman");
		sleep(2);
		element = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + element);
		// Send last name
		element.sendKeys("Madaan");
		sleep(2);
		element = driver.findElement(By.xpath("//input[@id='email']"));
		System.out.println("Found element: " + element);
		// Send email address
		element.sendKeys("amanmadaan10@gmail.com");
		sleep(2);
		element = driver.findElement(By.cssSelector("input#pass_confirmation"));
		System.out.println("Found element: " + element);
		// Send password
		element.sendKeys("Aman@4321");
		sleep(2);
		element = driver.findElement(By.cssSelector("input#pass2"));
		System.out.println("Found element: " + element);
		// Send password
		element.sendKeys("Aman@4321");
		sleep(2);
		element = driver.findElement(By.xpath("//input[@value='REGISTER']"));
		System.out.println("Found element: " + element);
		// Submit register button
		sleep(2);
		//element.click();
		if(element.isEnabled()) {
			element.click();
		}
		File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("ss2.png"));

		driver.close();
		driver.quit();
	}
	
}
