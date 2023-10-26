package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTask {
	@Test
	void amazon() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/Apple-iPhone-14-128GB-Blue/dp/B0BDK62PDX/ref=sr_1_1_sspa?crid=2D4413248ZKW5&keywords=iphone%2B14&qid=1694096698&sprefix=%2Caps%2C385&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1");
		
		WebElement conteinar = driver.findElement(By.xpath("//div[@id='inline-twister-expander-content-color_name']"));
		int X = conteinar.getLocation().x;
		int Y = conteinar.getLocation().y;
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+X+","+Y+")");
		
		List<WebElement> colours = driver.findElements(By.xpath("//div[@id='inline-twister-expander-content-color_name']/div/div[@class='a-section a-spacing-none']/ul/descendant::li[@data-csa-c-slot-id='twister-desktop-configurator-swatch-swatchAvailable']/descendant::img"));
		for (WebElement w : colours) {
			System.out.println(w.getAttribute("alt"));
		}
		driver.close();
	}
}