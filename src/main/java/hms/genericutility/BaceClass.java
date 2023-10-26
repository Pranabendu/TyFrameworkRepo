package hms.genericutility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import POM.LogOutPage;
import POM.Login_Page;
import POM.WelcomePge;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaceClass {
	public static WebDriver listenerDriver;
	public WebDriver driver;
//	create object for Utility

	FileUtility fut = new FileUtility();
	WebActionUtility waut = new WebActionUtility();
	ExcelUtility exut = new ExcelUtility();
	DataBaseUtility dbut = new DataBaseUtility();
	
	// all the POM pages
	WelcomePge wellcome = new WelcomePge(driver);
	Login_Page login = new Login_Page(driver);
	LogOutPage logout = new LogOutPage(driver);
	
	// get the filePath	
	String MainUrl = fut.fetchDataFromProperty("hmsurl");
	
	/**
	 * connect to the database
	 */
	@BeforeSuite(groups = {"smoke","regression"})
	public void connectToDB() {
		try {
			dbut.connectDB();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		Reporter.log("Data base is connected",true);
	}

	/**
	 * Open the Browser
	 */
	@BeforeClass(groups = {"smoke","regression"})
	public void openBrowser() {
	    String Browser = fut.fetchDataFromProperty("browser");
	    System.out.println(Browser);
	//	String Browser = System.getProperty("browser");
	    if (Browser.equalsIgnoreCase("chrome")) {
	    	WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(MainUrl);
		} else {
			WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(MainUrl);
		}
	    //listenerDriver = driver;
//	    switch (Browser.toLowerCase()) 
//	    {
//	        case "chrome":	
//	        	WebDriverManager.chromedriver().setup();
//	            driver = new ChromeDriver();  
//	            listenerDriver = driver;
//	            driver.manage().window().maximize();
//	            Reporter.log("Chrome is connected", true);
//	            break;
//	        case "firefox":
//	        	WebDriverManager.firefoxdriver().setup();
//	            driver = new FirefoxDriver();
//	            listenerDriver = driver;
//	            Reporter.log("Firefox is connected", true);
//	            break;
//	        default:
//	        	WebDriverManager.chromedriver().setup();
//	            driver = new ChromeDriver();
//	            listenerDriver = driver;
//	            driver.manage().window().maximize();
//	            Reporter.log("Default Chrome is connected", true);
//	    }
	    
	    waut.waitForElementInDOM(driver);
	}

	
/**
 * Here, login to Applications 
 */
	@BeforeMethod(groups = {"smoke","regression"})
	public void loginToApplication() {
		Reporter.log("Login has to be done",true);
		
//		String PUN = fut.fetchDataFromProperty("patientun");
//		String PUN = System.getProperty("patientun");
//		String PPASS = fut.fetchDataFromProperty("patientpass");
//		String PPASS = System.getProperty("patientpass");
//		
//		// "Open the browser and enter the test URL"
//		driver.get(MainUrl);
//		// click for patient module
//		
//		wellcome.clickonpatientloginlink();
//
//		// Login as patient with the valid user name and password
//		login.enterAllTheCredentialsAndClickOnLoginButton(PUN, PPASS);
	}

	 /**
	 * Here we are login to Applications as Doctor
	 */
//	@BeforeMethod(groups = {"smoke","regression"},enabled = false)
//	public void loginToApplicationasAsDoctor() {
//
//		String DUN = fut.fetchDataFromProperty("doctorun");
//		String DPASS = fut.fetchDataFromProperty("doctorpass");
//		
//		// "Open the browser and enter the test URL"
//		
//		driver.get(MainUrl);
//		// click for doctor module
//		wellcome.clickondoctorloginlink();
//		waut.waitForElementInDOM(driver);
//		login.enterAllTheCredentialsAndClickOnLoginButton(DUN, DPASS);
//		
//	}


	/**
	 * Login to the Application as Admin
	 */
//	@BeforeMethod(groups = {"smoke","regression"},enabled = false)
//	public void loginToApplicationAsAdmin() {
//		
//		String adminUsername = fut.fetchDataFromProperty("adminun");
//		String adminPassword = fut.fetchDataFromProperty("adminpass");
//		
//		// "Open the browser and enter the test URL"
//		
//		driver.get(MainUrl);
//		// click for admin module
//		wellcome.clickonadminloginlink();
//
//		// Login as Admin with the valid user name and password
//		
//		
//		login.enterAllTheCredentialsAndClickOnLoginButton(adminUsername, adminPassword);
//		Reporter.log("Logged in as Admin.....",true);
//	}

	/**
	 * Logout From the Application
	 */
	@AfterMethod(groups = {"smoke","regression"})
	public void logoutToApplication() {
			
		// Perform logout
		try {
			logout.performLogout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Reporter.log("Logout Succfully", true);

	}

	/**
	 * Close the browser
	 */
	@AfterClass(groups = {"smoke","regression"},alwaysRun = true)
	public void closeBrowser() {
		if(driver!=null) {
			driver.quit();

			Reporter.log("Browser is closing...",true);
		}
	}
 /**
 * Close the Data Base
 */
	@AfterSuite(groups = {"smoke","regression"},alwaysRun = true)
	public void closeDB() {
		try {
			dbut.closeDB();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		Reporter.log("Data base is closing...",true);
	}
	
}