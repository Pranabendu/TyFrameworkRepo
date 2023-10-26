package Com.Hms.TestYantratest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.Login_Page;

import POM.WelcomePge;
import hms.genericutility.BaceClass;


public class Integration_between_Doctor_and_PateintTest extends BaceClass{

	@Test(groups = "regration")
	public void doctor() throws InterruptedException, IOException {
		
		FileInputStream f1 = new FileInputStream("./files/propertyfile.properties");
		Properties p1 = new Properties();
		p1.load(f1);
		String DrUn = p1.getProperty("doctorun");
		String Url = p1.getProperty("hmsurl");
		String DrPass = p1.getProperty("doctorpass");
		String PtUn = p1.getProperty("patientun");
		String PtPass = p1.getProperty("patientpass");
	
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		
		// click on the patient module
		WelcomePge w1 = new WelcomePge(driver);
		w1.clickonpatientloginlink();

		// creating the object of the patient login page
		Login_Page plp = new Login_Page(driver);
		// entering username,password and clicking on login button
		plp.enterAllTheCredentialsAndClickOnLoginButton(PtUn, PtPass);
		
		// clicking on book appointment link
		WebElement bookappointment = driver.findElement(By.xpath("//span[.=' Book Appointment ']/.."));
		bookappointment.click();
		// selecting doctor specialization as a dentist
		WebElement dd = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
		Select s1 = new Select(dd);
		s1.selectByVisibleText("Dentist"); 
		// selecting doctor 
		WebElement dd2 = driver.findElement(By.xpath("//select[@id='doctor']"));
		Select s2 = new Select(dd2);
		s2.selectByVisibleText("Anuj");
		Thread.sleep(2000);
		// clicking on date popup
		WebElement datepopup = driver.findElement(By.xpath("//input[@name='appdate']"));
		datepopup.click();
		Thread.sleep(2000);
				
		// Entering the date
		WebElement date = driver.findElement(By.xpath("//tbody/tr[5]/td[5]"));
		date.click();
		Thread.sleep(1000);
		// clicking on the time component
		WebElement time = driver.findElement(By.xpath("//input[@name='apptime']"));
		time.click();
		Thread.sleep(1000);
		// Entering the hour
		WebElement hour = driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-hour form-control']"));
		hour.clear();
		Thread.sleep(1000);
		hour.sendKeys("09");
		// Entering the minute
		WebElement min = driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-minute form-control']"));
		min.clear();
		Thread.sleep(1000);
		min.sendKeys("25");
		// Entering the AM-PM
		WebElement AMPM = driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-meridian form-control']"));
		AMPM.clear();
		Thread.sleep(1000);
		AMPM.sendKeys("AM");
		Thread.sleep(1000);
		// clicking on the submit button 
		WebElement submit = driver.findElement(By.xpath("//button[@name='submit']"));
		submit.click();
		// handling the popup
		Alert handle = driver.switchTo().alert();
		handle.accept();
		Thread.sleep(2000);
		// click on appointment history button
		WebElement ptappointmentHistory = driver.findElement(By.xpath("//span[.=' Appointment History ']/.."));
		ptappointmentHistory.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		
		String Expected = driver.findElement(By.xpath("//tbody/tr[last()]/td[position()=5]")).getText();
		
		Thread.sleep(2000);
		// clicking on the profile logo
		WebElement profile_logo = driver.findElement(By.xpath("//i[@class='ti-angle-down']"));
		profile_logo.click();
		Thread.sleep(1000);
		// clicking on the logout button
		WebElement logout = driver.findElement(By.xpath("//a[@href='logout.php']"));
		logout.click();
		
		Thread.sleep(2000);
		
		// clicking on the doctor module
		w1.clickondoctorloginlink();
		// entering all credentials
		plp.enterAllTheCredentialsAndClickOnLoginButton(DrUn, DrPass);
		
		
//		// click on appointment history button
//		WebElement DrappointmentHistory = driver.findElement(By.xpath("//span[.=' Appointment History ']/.."));
//		DrappointmentHistory.click();
//		Thread.sleep(1500);
//		// scrolling down
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,200)");
//		// clicking on cancel link
//		WebElement cancelbtn = driver.findElement(By.xpath("//tbody/tr[last()]/td[position()=8]"));
//		cancelbtn.click();
//		Alert handle2 = driver.switchTo().alert();
//		handle2.accept();
		
		// clicking on patient dropdown in the doctor module
		driver.findElement(By.xpath("//i[@class='icon-arrow']")).click();
		Thread.sleep(2000);
		// clicking on the manage patient link
		driver.findElement(By.xpath("//span[.=' Manage Patient ']")).click();
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		
		// locating last patient date and time
		WebElement Actual = driver.findElement(By.xpath("//tbody/tr[last()]/td[position()=5]"));
		
		
		if (Actual.getText().contains(Expected)) {
			System.out.println("Test Case Is Pass");
		} else {
			System.out.println("Test Case Fail");
		}
		
		
		// clicking on the profile logo
		WebElement Doc_profile_logo = driver.findElement(By.xpath("//i[@class='ti-angle-down']"));
		Doc_profile_logo.click();
		Thread.sleep(1000);
		// clicking on the logout button
		WebElement logoutdoc = driver.findElement(By.xpath("//a[@href='logout.php']"));
		logoutdoc.click();
		Thread.sleep(2000);		
		
		
	}

}