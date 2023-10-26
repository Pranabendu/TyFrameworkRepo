package Com.Hms.TestYantratest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import POM.Login_Page;
import POM.WelcomePge;
import hms.genericutility.BaceClass;
import hms.genericutility.JavaUtility;

public class Manage_Patient_HistorTest extends BaceClass {

	@Test(groups = "regration")
	public void history() throws InterruptedException {

//		WebDriver driver=new ChromeDriver();
//		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.titleContains(""));

		JavaUtility ju = new JavaUtility();
		WelcomePge w1 = new WelcomePge(driver);
		w1.clickondoctorloginlink();
		Login_Page l1 = new Login_Page(driver);
		l1.enterAllTheCredentialsAndClickOnLoginButton("Anuj@doctor.com", "Anuj123");

		// clicking on paitent dropdown
		driver.findElement(By.xpath("//i[@class='icon-arrow']")).click();
		Thread.sleep(1500);
		// clicking on add paitent link
		driver.findElement(By.xpath("//span[.=' Add Patient']/..")).click();
		Thread.sleep(1500);
		// entering the paitent name
		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Name']"))
				.sendKeys("Roy" + ju.getRandomNumber());
		// entering Patient Contact no
		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Contact no']")).sendKeys("6574839237");
		// entering Patient Email
		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Email id']"))
				.sendKeys("roy" + ju.getRandomNumber() + "@gmail.com");
		// selecting the Gender as a male
		driver.findElement(By.xpath("//label[@for='rg-male']")).click();
		// entering address
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Patient Address']")).sendKeys("Banshankari");
		// Entering age of the patient
		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Age']")).sendKeys("32");
		// entering medical history
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Patient Medical History(if any)']"))
				.sendKeys("healthy");
		Thread.sleep(1500);
		// clicking on submit button
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		Thread.sleep(2000);
		// clicking on paitent dropdown
		driver.findElement(By.xpath("//i[@class='icon-arrow']")).click();
		Thread.sleep(3000);
		// clicking on the manage patient link
		driver.findElement(By.xpath("//span[.=' Manage Patient ']")).click();

		// view new added patient
		WebElement viewUpadatedPat = driver.findElement(By.xpath("(//i[@class='fa fa-eye'])[last()]"));
		viewUpadatedPat.click();

		// add Medical History
		WebElement addMedHistory = driver
				.findElement(By.xpath("//button[@class='btn btn-primary waves-effect waves-light w-lg']"));
		addMedHistory.click();
		Thread.sleep(2000);
		// fill all the medical history

		WebElement bloodPressure = driver.findElement(By.xpath("//input[@name='bp']"));
		bloodPressure.sendKeys("BP is 120");

		WebElement bloodSugar = driver.findElement(By.xpath("//input[@name='bs']"));
		bloodSugar.sendKeys("sugar, BP, heart problem");

		WebElement weight = driver.findElement(By.xpath("//input[@name='weight']"));
		weight.sendKeys("78");

		WebElement temp = driver.findElement(By.xpath("//input[@name='temp']"));
		temp.sendKeys("98 degree celsius");

		WebElement prescription = driver.findElement(By.xpath("//textarea[@name='pres']"));
		prescription.sendKeys("dolo 65, sleep, drink more water");

		WebElement medHisSubmit = driver.findElement(By.xpath("//button[@name='submit']"));
		medHisSubmit.click();

		// handling alart confirmation popup
		Alert popup = driver.switchTo().alert();
		popup.accept();
		// clicking on the profile icon
		driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();

		// clicking on logout link
		driver.findElement(By.xpath("//a[@href='logout.php']/../..//a[contains(.,'Log Out')]")).click();

	}

}