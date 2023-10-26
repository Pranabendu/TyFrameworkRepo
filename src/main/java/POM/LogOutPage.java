package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.genericutility.BaceClass;
import hms.genericutility.WebActionUtility;


	/**
	 * This is generic Logout for all the page
	 * @author pranab
	 *
	 */
	public class LogOutPage  {
		
		
		
		// Admin Profile
		@FindBy(xpath = "//i[@class='ti-angle-down']")
		private WebElement profileLogo;
		
		// Logout Link
		@FindAll(@FindBy(xpath="//a[@href='logout.php']"))
		private WebElement logout;
		
		// Initialization
		public LogOutPage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		public WebElement getProfile() {
			return profileLogo;
		}

		public WebElement getLogout() {
			return logout;
		}

		
		// Business library method to perform logout
		public void performLogout(){
//			WebActionUtility waut = new WebActionUtility();
			profileLogo.click();
			try {
				Thread.sleep(1000);
				logout.click();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
}