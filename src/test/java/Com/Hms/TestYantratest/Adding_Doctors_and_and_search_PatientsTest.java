package Com.Hms.TestYantratest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.Login_Page;
import POM.WelcomePge;
import hms.genericutility.BaceClass;
import hms.genericutility.FileUtility;
import hms.genericutility.JavaUtility;

//@Listeners(hms.genericutility.ListenerImplementation.class)
public class Adding_Doctors_and_and_search_PatientsTest extends BaceClass{

	@Test(groups = "smoke")
	public void patient() throws InterruptedException {
//	public static void main(String[] args) throws InterruptedException{
		
		JavaUtility jut = new JavaUtility();
		WelcomePge wlp = new WelcomePge(driver);
		Login_Page lp = new Login_Page(driver);
		FileUtility fut = new FileUtility();
		
//		String url = fut.fetchDataFromProperty("hmsurl");
		String AdminUn = fut.fetchDataFromProperty("adminun");
		String AdminPass = fut.fetchDataFromProperty("adminpass");
		wlp.clickonadminloginlink();
		lp.enterAllTheCredentialsAndClickOnLoginButton(AdminUn,AdminPass);
		
		
		// clicking on doctors tab in the admin dashbord page
		WebElement doctors = driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/li[position()=2]//div[@class='item-content']"));
		doctors.click();
		Thread.sleep(1000);
		// clicking in the add doctor 
		WebElement addDoctor = driver.findElement(By.xpath("//span[.=' Add Doctor']/.."));
		addDoctor.click();
		
		// locating doctor specialization dropdown
		WebElement specialization = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
		
		Select s1 = new Select(specialization);
		s1.selectByVisibleText("Dentist");
		Thread.sleep(1000);
		
		// entering doctor name
		WebElement drname = driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Name']"));
		drname.sendKeys("Roy"+"_"+jut.getRandomNumber());
		
		// entering clinic address
		WebElement clAddress = driver.findElement(By.xpath("//textarea[@placeholder='Enter Doctor Clinic Address']"));
		clAddress.sendKeys("Bangaluru");
		
		// Entering doctor consultancy Fees
		WebElement drFees = driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Consultancy Fees']"));
		drFees.sendKeys("700");
		
		// Entering doctor phone no
		WebElement phno = driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Contact no']"));
		phno.sendKeys(jut.getRandomMobileNumber());
		
		// Entering doctor mail id
		WebElement mail = driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Email id']"));
		mail.sendKeys("roy"+jut.getRandomNumber()+".gmail.com");
		
		// Entering new password
		WebElement newpass = driver.findElement(By.xpath("//input[@placeholder='New Password']"));
		newpass.sendKeys("roy123");
		
		// confirming password
		WebElement cnpass = driver.findElement(By.xpath("//input[@placeholder='Confirm Password']"));
		cnpass.sendKeys("roy123");
		
		// clicking on submit button
		WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
		submit.click();
		Thread.sleep(2000);		
				
		// clicking on patient search tab
		WebElement ptsearch = driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/li[last()]/a"));
		ptsearch.click();
		
		// entering data into the search 
		WebElement search = driver.findElement(By.xpath("//input[@id='searchdata']"));
		search.sendKeys("John");
		
		// clicking on the search button
		WebElement searchbtn = driver.findElement(By.xpath("//button[@id='submit']"));
		searchbtn.click();
		
		// clicking on the view icon
		WebElement viewicon = driver.findElement(By.xpath("//tbody/tr/td[last()]/a"));
		viewicon.click();
		
		// validating the manage patient page
		String expected = "view-patient";
		String actual = driver.getCurrentUrl();
		if (actual.contains(expected)) {
			System.out.println("manage patient page is varified");
		}
		// clicking on reports tab
		WebElement reports = driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/li[position()=9]/a"));
		reports.click();
		
		// clicking on the between dates reports
		driver.findElement(By.xpath("//a[@href='between-dates-reports.php']")).click();
		
		// validating the between dates reports page
		String exp_page = "between-dates-reports";
		String act_page = driver.getCurrentUrl();
		if (act_page.contains(exp_page)) {
			System.out.println("between-dates-reports page is varified");
		}
		
		Thread.sleep(1000);
		// passing the data in the from date
		WebElement from_date = driver.findElement(By.xpath("//input[@id='fromdate']"));
		from_date.sendKeys("01");
		Thread.sleep(1000);
		from_date.sendKeys("06");
		Thread.sleep(1000);
		from_date.sendKeys("2023");
		
		Thread.sleep(2000);
		
		// passing the data in the to date
		WebElement to_date = driver.findElement(By.xpath("//input[@id='todate']"));
		to_date.sendKeys("30");
		Thread.sleep(1000);
		to_date.sendKeys("06");
		Thread.sleep(1000);
		to_date.sendKeys("2023");
		
		// clicking on submit button
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		// selecting all the dates from the table
		List<WebElement> alldates = driver.findElements(By.xpath("//tbody/tr/td[position()=5]"));
		
		
		// validating with the month
		int c = 0;
		for (WebElement dates : alldates) {
			String [] arr =dates.getText().split(" ");
			String s = "";
			for (int i = 0; i < 1; i++) {
				s = arr[i];
			}
			String s2 = ""; 
			String [] crr = s.split("-");
			for (int i = 2; i <= 2; i++) {
				s2 = crr[i];
			}
			int no = Integer.parseInt(s2);
			if (no>=01 || no<=06) {
				c++;
				System.out.println("test case is pass");
			} else {
				System.out.println("test case is fail");
			}
			
		}
		
	}

}