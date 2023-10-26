package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.genericutility.WebActionUtility;

public class Patient_BookAppointment_page {
	// Deceleration
	
	// Doctor Specialization 
	@FindBy(xpath = "//select[@name='Doctorspecialization']")
	private WebElement Doctorspecialization;

	// Doctors 
	@FindBy(xpath = "//select[@id='doctor']")
	private WebElement doctor;

	// Date
	@FindBy(xpath = "//input[@name='appdate']")
	private WebElement appdatepopup;
	
	// Particular date address
	@FindBy(xpath = "//tbody/tr[5]/td[5]")
	private WebElement date;
	
	// time component
	@FindBy(xpath = "//input[@name='apptime']")
	private WebElement time;
	
	// Hour
	@FindBy(xpath = "//input[@class='bootstrap-timepicker-hour form-control']")
	private WebElement hour;
	
	//minute
	@FindBy(xpath = "//input[@class='bootstrap-timepicker-minute form-control']")
	private WebElement min;
	
	// AM PM
	@FindBy(xpath = "//input[@class='bootstrap-timepicker-meridian form-control']")
	private WebElement AMPM;
	
	// Submit
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement submit;
	
	// Utilization
	public Patient_BookAppointment_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Initialization
	public WebElement DoctorspecializationDropdown() {
		return Doctorspecialization;
	}
	public WebElement doctorDropdown() {
		return doctor;
	}
	public WebElement clickOnappdatepopup() {
		return appdatepopup;
	}
	public WebElement clickOnTheParticulardate() {
		return date;
	}
	public WebElement ClickonThetimeTextfield() {
		return time;
	}
	public WebElement clearANDenterThehour() {
		return hour;
	}
	public WebElement clearANDEnterTheminute() {
		return min;
	}
	public WebElement clearAndEnterAMPM() {
		return AMPM;
	}
	public WebElement clickOnsubmitButton() {
		return submit;
	}
	
	// Business libraries
	public void doAllTheAction(WebActionUtility webact,WebDriver driver) throws InterruptedException {
		webact.select(Doctorspecialization, "Dentist");
		webact.select(doctor, "Anuj");
		webact.waitForElementInDOM(driver);
		appdatepopup.click();
		date.click();
		hour.clear();
		hour.sendKeys("11");
		
		min.clear();
		min.sendKeys("43");
		AMPM.clear();
		AMPM.sendKeys("AM");
		webact.waitForElementInDOM(driver);
		submit.click();
	}
}