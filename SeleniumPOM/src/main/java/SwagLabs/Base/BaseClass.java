package SwagLabs.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.*;



import SwagLabs.Utility.UtilityClass;
import SwagLabs.Utility.WebEventListener;

public class BaseClass {
	
	// Global variables
	public static  WebDriver driver;  // WebDriver instance
	public static Properties prop;  // Properties object to load configuration properties
	

	public  static EventFiringDecorator<WebDriver> e_driver;
	public static WebEventListener eventListener;
	
	
	// Constructor to load the properties file
	public BaseClass() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Sadiq\\Desktop\\Automation\\SeleniumPOM\\src\\main\\java\\SwagLabs\\Config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
    // Method to initialize the WebDriver and open the browser
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sadiq\\Desktop\\Automation\\SeleniumPOM\\chromedriver.exe");
		    driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sadiq\\Desktop\\Automation\\SeleniumPOM\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Sadiq\\Desktop\\Automation\\SeleniumPOM\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Please enter a valid browser name");
		}
		
	
		
		
		
		
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver = new EventFiringDecorator<WebDriver>(eventListener);
		driver = e_driver.decorate(driver);
		
		
		
		
		
		
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilityClass.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(UtilityClass.PAGE_LOAD_TIMEOUT));
		driver.get(prop.getProperty("url"));
		
		

}
	}
