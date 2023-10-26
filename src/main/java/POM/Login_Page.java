package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	// Deceleration
	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;
	
//	@FindAll({@FindBy(xpath=""),@FindBy(xpath="")})

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement login;

	// Utilization
	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Initialization
	public WebElement patientUN() {
		return username;
	}

	public WebElement patientPASS() {
		return password;
	}

	public WebElement patientLOGIN() {
		return login;
	}
	
	// business library
	public void enterAllTheCredentialsAndClickOnLoginButton(String UN,String PASS) {
		username.sendKeys(UN);
		password.sendKeys(PASS);
		login.click();
	}

}