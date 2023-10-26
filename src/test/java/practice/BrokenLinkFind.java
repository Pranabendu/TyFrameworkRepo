package practice;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkFind {
	@Test
	void brokenlink()  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		List<WebElement> linktags = driver.findElements(By.xpath("//a"));
		
		for(WebElement ele : linktags) {
			String link = ele.getAttribute("href");
			try {
				URL url = new URL(link);
				URLConnection conn = url.openConnection();
				HttpURLConnection httpconn = (HttpURLConnection) conn;
				int response = httpconn.getResponseCode();
				if(response>=400) {
//					System.err.println(link+" "+response);
					System.out.print(link+" ");
					System.err.print(response);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println();
		}
		driver.close();

		
//		for(WebElement tag : linktags) {
//			String link = tag.getAttribute("href");
//			try {
//				URL url = new URL(link);
//				URLConnection conn;
//				try {
//					conn = url.openConnection();
//					HttpURLConnection httpconn = (HttpURLConnection) conn;
//					if (httpconn.getResponseCode()>=400) {
//						System.out.println(link);
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//			} catch (MalformedURLException e) {
//				e.printStackTrace();
//			}
//		}
//		driver.close();
	}
}