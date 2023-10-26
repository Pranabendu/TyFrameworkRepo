package practice;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraTask {
	@Test
	void myntra() throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://www.myntra.com");
		Actions act = new Actions(driver);
		WebElement home_Living = driver.findElement(By.xpath("//a[.='Home & Living']"));
		act.moveToElement(home_Living).perform();
		List<WebElement> home_decor = driver.findElements(By.xpath("//a[.='Home Décor']/parent::li/parent::ul/descendant::li"));
		Iterator<WebElement> it = home_decor.iterator();
		while(it.hasNext()) 
		{
			System.out.println(it.next().getText());
		}
		WebElement men = driver.findElement(By.xpath("//a[.='Men']"));
		act.moveToElement(men).perform();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//a[@href='/men-jeans']")).click();
		List<WebElement> images = driver.findElements(By.xpath("//ul[@class='results-base']/descendant::li/descendant::img"));
		System.out.println("total no of image is"+images.size());
		
		WebElement recomend = driver.findElement(By.xpath("//span[.='Recommended']"));
		act.moveToElement(recomend).perform();
		
		WebElement customer_rating = driver.findElement(By.xpath("//input[@value='Customer Rating']/parent::label"));
		customer_rating.click();
		
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		search.sendKeys("Mango-man shirts");
		search.sendKeys(Keys.ENTER);
	}
}