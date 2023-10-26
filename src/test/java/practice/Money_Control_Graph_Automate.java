package practice;

import java.net.SocketException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Money_Control_Graph_Automate {
	@Test
	void moneycontrol() throws InterruptedException {		
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.moneycontrol.com/");
		
		Actions act = new Actions(driver);
		driver.findElement(By.xpath("//a[.='moneycontrol.com']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='wzrk-cancel']")).click();
		Thread.sleep(1000);
		WebElement graph = driver.findElement(By.xpath("//div[@id='market_action']"));
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+graph.getLocation().x+","+graph.getLocation().y+")");
		Thread.sleep(1500);
		
		try {
			List<WebElement> paths = driver.findElements(By.xpath("//*[name()='svg']//*[name()='g']//*[name()='path']"));
			
			for (WebElement ele : paths) {
			
				System.out.println(ele.getText());
			}
			driver.close();
		} catch (Exception e) {
			
		}
		
	}
}