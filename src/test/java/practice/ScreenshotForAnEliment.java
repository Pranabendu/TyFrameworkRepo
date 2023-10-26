package practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotForAnEliment {
	@Test
	void take() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		WebElement search = driver.findElement(By.xpath("//a[.='Mobiles']"));
		File temp = search.getScreenshotAs(OutputType.FILE);
		File per = new File("./Screenshots/take.png");
		try {
			FileHandler.copy(temp, per);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}