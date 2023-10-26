package Com.Hms.TestYantratest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.Login_Page;
import POM.WelcomePge;
import hms.genericutility.BaceClass;
import hms.genericutility.FileUtility;
import hms.genericutility.JavaUtility;

//@Listeners(hms.genericutility.ListenerImplementation.class)
public class Check_ReportTest extends BaceClass{

	@Test(groups = "smoke")
	public void report() throws InterruptedException {

		
	
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		
		
		// click on the patient module
//		WebElement patient = driver.findElement(By.xpath("//h3[.='Admin Login']/../div[@class='button']/span/a"));
//		patient.click();
//		// entering username
//		WebElement un = driver.findElement(By.xpath("//input[@name='username']"));
//		un.sendKeys("admin");
//		// entering password
//		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
//		pass.sendKeys("Test@12345");
		// clicking in login button
//		WebElement loginbtn = driver.findElement(By.xpath("//button[@name='submit']"));
//		loginbtn.click();
//		FileUtility fut = new FileUtility();
//		WelcomePge w1 = new WelcomePge(driver);
//		String Url = fut.fetchDataFromProperty("hmsurl");
		
//		driver.get(Url);
		JavaUtility jut = new JavaUtility();
		WelcomePge wlp = new WelcomePge(driver);
		FileUtility fut = new FileUtility();
		Login_Page login = new Login_Page(driver);

		
		wlp.clickonadminloginlink();
//		login.enterAllTheCredentialsAndClickOnLoginButton("pranab@gmail.com","pranab123");
		login.enterAllTheCredentialsAndClickOnLoginButton("admin","Test@12345");
		// clicking on reports tab
		WebElement reports = driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/li[last()-1]//span[.=' Reports ']/.."));
		reports.click();
		Thread.sleep(2000);
		// clicking on the  Btw_dates_reports
		WebElement Btw_dates_reports = driver.findElement(By.xpath("//span[.='B/w dates reports ']/.."));
		Btw_dates_reports.click();
		
		Thread.sleep(1000);
		// passing the data in the from date
		WebElement from_date = driver.findElement(By.xpath("//input[@id='fromdate']"));
		from_date.sendKeys("01");
		Thread.sleep(1000);
		from_date.sendKeys("01");
		Thread.sleep(1000);
		from_date.sendKeys("2023");
		
		Thread.sleep(2000);
		
		// passing the data in the to date
		WebElement to_date = driver.findElement(By.xpath("//input[@id='todate']"));
		to_date.sendKeys("28");
		Thread.sleep(1000);
		to_date.sendKeys("06");
		Thread.sleep(1000);
		to_date.sendKeys("2023");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		// fetching all 6 months dates
		List<WebElement> alldates = driver.findElements(By.xpath("//tbody/tr/td[position()=5]"));
		
		for (WebElement dates : alldates) {
			String [] arr =dates.getText().split(" ");
			String s1 = ""; // 2023-03-08
			for (int i = 0; i < 1; i++) {
				s1 = arr[i];
			}
			String s2 = ""; 
			String [] crr = s1.split("-");
			for (int i = 1; i < 2; i++) {
				s2 = crr[i];
			}
			int no = Integer.parseInt(s2);
			if (no>=01 || no<=06) {
				System.out.println("test case is pass");
			} else {
				System.out.println("test case is fail");
			}
		}
		
		
		
	}

}