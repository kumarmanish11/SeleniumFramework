package Project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class baseTest {

	// Creating here so that everyone can access it
	WebDriver driver;
	
	//Creating the Log4j Logger
	public static Logger log= LogManager.getLogger(baseTest.class.getName());

	@BeforeTest
	public WebDriver InitializeDriver() throws IOException {

		// Properties Object Creation
		Properties prop = new Properties();

		// Giving the FileInputStream to Read the Properties File
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Manish\\eclipse-workspace\\Framework_Project\\src\\test\\java\\Project\\data.properties");

		// Loading the Properties File
		prop.load(fis);
		log.info("Properties File has been loaded");

		// Getting the Browser Property via Properties File
		//String browsername = prop.getProperty("browser");
		
		// Getting the Browser Property via Maven+Jenkins
		String browsername = System.getProperty("browser");

		if (browsername.trim().equalsIgnoreCase("chrome")) {
			// Selenium Setup with Chrome
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Manish\\Documents\\Selenium Files\\chromedriver.exe");
			
			//Adding the Code for Headless Mode of Execution and Passing the object to driver initialization 
			ChromeOptions options = new ChromeOptions();
			//Adding the argument of User Agent so that Website does not think Robot has accessed it 
			options.addArguments("headless","user-agent=mrbean");
			
			driver = new ChromeDriver(options);
			
			log.info("Chrome Browser has been initialized");

		} else if (browsername.trim().equalsIgnoreCase("ie")) {
			// Selenium Setup with IE
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\Manish\\Documents\\Selenium Files\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
			log.info("IE Browser has been initialized");

		} else {
			// Selenium Setup with Chrome (If anything Fails i.e DEFAULT Browser)
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Manish\\Documents\\Selenium Files\\chromedriver.exe");
			driver = new ChromeDriver();
			
			log.info("Since no browser is defined so Chrome Browser has been initialized");

		}
		// Global Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("Implicit Timeout of 10 sec is provided");
		return driver;

	}

}
