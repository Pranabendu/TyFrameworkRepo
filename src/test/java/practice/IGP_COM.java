package practice;

import java.util.List;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IGP_COM {
	@Test
	void igp() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.igp.com/cakes");
		String search = "Delish Motichoor Ladoo Cake (Half Kg)";
		List<WebElement> cakes = driver.findElements(By.xpath("//div[@class='product-list']/div/following-sibling::div[1]//child::div[@class='slick-track slick-track-revamp']/div//div[@class='row no-margin ']//p[text()='"+search+"']/ancestor::div[@class='row no-margin ']/following-sibling::div[1]//p/span"));
		
		for (WebElement cake : cakes) {
			
				System.out.println("cake prices of "+search+" is "+cake.getText());
		}
		driver.close();
	
//		int [] arr = {3,7,9,5,7};	
//		for (int i = 0; i < arr.length; i++) {
//			int c = 0;
//			for (int j = i+1; j < arr.length; j++) {
//				if (arr[i]==arr[j]) {
//					c++;
//				}
//			}
//			if (c==0) {
//				System.out.println(arr[i]);
//			}
//		}
	}
}