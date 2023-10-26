package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToWindowBasedOnUrl {
	@Test
	void switchWindow() throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		WebElement mobiles = driver.findElement(By.xpath("//a[.='Mobiles']"));
		WebElement releases = driver.findElement(By.xpath("//a[.='New Releases']"));
		WebElement sell = driver.findElement(By.xpath("//a[.='Sell']"));
		
		Actions act = new Actions(driver);
		Robot rbt = new Robot();
		
			
		act.contextClick(mobiles).perform();
		Thread.sleep(1000);
		rbt.keyPress(KeyEvent.VK_T);
		rbt.keyRelease(KeyEvent.VK_T);
		Thread.sleep(1000);

		act.contextClick(releases).perform();
		Thread.sleep(1000);
		rbt.keyPress(KeyEvent.VK_T);
		rbt.keyRelease(KeyEvent.VK_T);

		Thread.sleep(1000);

		act.contextClick(sell).perform();
		Thread.sleep(1000);
		rbt.keyPress(KeyEvent.VK_T);
		rbt.keyRelease(KeyEvent.VK_T);
		
		String url = "https://www.amazon.in/gp/new-releases/?ref_=nav_cs_newreleases";
		
		Set<String> allid = driver.getWindowHandles();
		Iterator<String> it = allid.iterator();	
		while(it.hasNext()) {
			String uid = it.next();
			driver.switchTo().window(uid);
			if (driver.getCurrentUrl().equalsIgnoreCase(url)) {
				break;
			} else {
				continue;
			}
		}
	}
}