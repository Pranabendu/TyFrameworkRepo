package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePge {
	
	// Deceleration
	@FindBy(xpath = "//h3[.='Admin Login']/../div[@class='button']/span/a")
	private WebElement adminlogin;
	
	@FindBy(xpath = "//h3[.='Patients']/../div[@class='button']/span/a")
	private WebElement patientlogin;
	
	@FindBy(xpath = "//h3[.='Doctors Login']/../div[@class='button']/span/a")
	private WebElement doctorlogin;
	
	// Utilization
	public WelcomePge(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	// Initialization
	public WebElement adminloginlink() {
		return adminlogin;
	}
	public WebElement patientloginlink() {
		return patientlogin;
	}
	public WebElement doctorloginlink() {
		return doctorlogin;
	}
	
	// business library
	public void clickonadminloginlink() {
		adminlogin.click();
	}
	public void clickonpatientloginlink() {
		patientlogin.click();
	}
	public void clickondoctorloginlink() {
		doctorlogin.click();
	}
}