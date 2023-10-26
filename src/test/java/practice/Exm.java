package practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exm {

	public static void main(String[] args) {
//		String [] arr = {"bablu","lalu","janu","ola"};
//		String s1 = "";
//		for (int i = 0; i < arr.length; i++) {
//			s1 = arr[i];
//		}
//		System.out.println(s1);
				
		Workbook book = null;
		try {
			FileInputStream fin = new FileInputStream("./files/Book1.xlsx");
			book = WorkbookFactory.create(fin);
			Sheet sheet = book.getSheet("Sheet1");
			String data = sheet.getRow(0).getCell(0).toString();
			System.out.println(data);
		} catch (IOException e) {
			e.getMessage();
		}
		finally {
			try {
				book.close();
				Reporter.log("DB is closed",true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Test
	void calender() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, -20);
//		System.out.println(cal.toString());
//		Date dt = cal.getTime();
//		System.out.println(dt.toString());
//		String date = sdf.format(dt);
//		System.out.println(date);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 4);
		Date date = cal.getTime();
		System.out.println(date);
		System.out.println(sdf.format(date));
	}

	@Test
	void amzon() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_3c01r1321r_e&adgrpid=60612964962&hvpone=&hvptwo=&hvadid=610714031509&hvpos=&hvnetw=g&hvrand=8112124225337082726&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062072&hvtargid=kwd-32679660&hydadcr=14454_2316419");
		WebElement signin = driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']/descendant::span"));
		WebElement mouse = driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_ya_signin']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouse).perform();
		Thread.sleep(1000);
		System.out.println(signin.getCssValue("color"));
	}

}