package hms.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtility {
	
	int implesitwait;
	int explesitwait;
	
	public WebActionUtility() {
		String propartypath = "./files/propertyfile.properties";
		implesitwait = 10;
		explesitwait = 10;		
	}
	public void waitForElementInDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implesitwait));
	}
	public void waitForPage(WebDriver driver,WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explesitwait));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void waitAndClick(WebElement ele) throws InterruptedException {
		int count = 0;
		while(count<implesitwait) {
			try {
				ele.click();
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
						
		}
	}
	public void waitAndType(WebElement ele,String input) throws InterruptedException {
		int count = 0;
		while(count<implesitwait) {
			try {
				ele.sendKeys(input);
			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	public void swithToWindow(String partialwindowtitle,WebDriver driver) {
		Set<String> allids = driver.getWindowHandles();
		for (String id : allids) {
			driver.switchTo().window(id);			
			if (driver.getTitle().contains(partialwindowtitle)) {
				System.out.println("switching window is done succesfully according to the title");
				break;
			}
		}
	}
	public void swithToWindowBasedOnURL(String partialwindowurl,WebDriver driver) {
		Set<String> allids = driver.getWindowHandles();
		Iterator<String> id = allids.iterator();
		while(id.hasNext()) {
			String wid = id.next();
			driver.switchTo().window(wid);
			if (driver.getCurrentUrl().contains(partialwindowurl)) {
				System.out.println("switching window is done succesfully according to the url");
				break;
			}
		}
	}
	public void swithToAlertPopUpAndAccpect(String partialtest,WebDriver driver) {
		Alert alpopup = driver.switchTo().alert();
		String altext = alpopup.getText();
		if (altext.contains(partialtest)) {
			System.out.println("popup accepted successfully");
			alpopup.accept();
			
		}
	}
	public void swithToAlertPopUpAndCancel(String partialtest,WebDriver driver) {
		Alert alpopup = driver.switchTo().alert();
		String altext = alpopup.getText();
		if (altext.contains(partialtest)) {
			System.out.println("popup canceled successfully");
			alpopup.dismiss();
		}
	}
	public void switchtoFrame(WebDriver driver,WebElement frameaddress) {
		driver.switchTo().frame(frameaddress);
	}
	public void select(WebElement element , String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	public void mouseOverOnElement(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	public void rightClickOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}
	public void executeJavaScript(WebDriver driver,String javascreeptcode) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(javascreeptcode);			
	}
	public void clickonEnterKey(WebElement ele) {
		ele.sendKeys(Keys.ENTER);
	}
	public static String takeScreenShot(String screenShotName,WebDriver driver) {
		
		JavaUtility ju = new JavaUtility();
		String res = ju.getDateWithTime();
		String FailMethodName = screenShotName;
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File per = new File("./Screenshots/"+FailMethodName+"_"+res+".png");
		try {
//			FileHandler.copy(temp, per);
			FileUtils.copyFile(temp, per);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return screenShotName;
		
	}
}