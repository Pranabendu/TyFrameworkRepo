package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Patient_Dashbord_page {
	// Deceleration
	@FindBy(xpath = "//span[.=' Book Appointment ']/..")
	private WebElement BookAppointment;

	@FindBy(xpath = "//span[.=' Appointment History ']/..")
	private WebElement AppointmentHistory;

	@FindBy(xpath = "//span[.=' Medical History ']/..")
	private WebElement MedicalHistory;
	
	@FindBy(xpath = "//h2[.='My Profile']/following-sibling::p/a")
	private WebElement myprofileLink;
	
	@FindBy(xpath = "//i[@class='ti-angle-down']")
	private WebElement profileicon;
	
	@FindBy(xpath = "//a[contains(.,'Change Password')]")
	private WebElement changepassword;
	
	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement logout;
	
	// Utilization
	public Patient_Dashbord_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Initialization
	public WebElement BookAppointmenttab() {
		return BookAppointment;
	}
	public WebElement AppointmentHistorytab() {
		return AppointmentHistory;
	}
	public WebElement MedicalHistorytab() {
		return MedicalHistory;
	}
	public WebElement myprofileLinktab() {
		return myprofileLink;
	}
	public WebElement profilelogoicon() {
		return profileicon;
	}
	public WebElement changepasswordlink() {
		return changepassword;
	}
	public WebElement logoutlink() {
		return logout;
	}
	
	// Business Library
	public void clickOnBookAppointmenttab() {
		BookAppointment.click();
	}
	public void clickonAppointmentHistorytab() {
		AppointmentHistory.click();
	}
	public void clickonMedicalHistorytab() {
		MedicalHistory.click();;
	}
	public void clickonmyprofileLinktab() {
		myprofileLink.click();;
	}
	public void clickonprofilelogoicon() {
		profileicon.click();;
	}
	public void clickonchangepasswordlink() {
		changepassword.click();;
	}
	public void clickonlogoutlink() {
		logout.click();
	}
}