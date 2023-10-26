package practice;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import POM.MakeMyTrip;



public class ModayTask {

	@Test
	void task() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notification");
		
		WebDriver driver = new ChromeDriver(options);	
		
		MakeMyTrip mt = new MakeMyTrip(driver);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com");
		
		Actions act = new Actions(driver);
		act.click().perform();
		
		WebElement from = driver.findElement(By.xpath("//input[@id='fromCity']"));
		from.sendKeys("ba");
		Thread.sleep(1000);
		List<WebElement> fromPlace = driver.findElements(By.xpath("//ul[@role='listbox']/descendant::li/div//p[@class='font14 appendBottom5 blackText']"));
		for (WebElement ele : fromPlace) {
			if(ele.getText().contains("Bengaluru")) {
				ele.click();
				break;
			}
		}
		
		WebElement to = driver.findElement(By.xpath("//input[@id='toCity']"));
		to.sendKeys("go");
		Thread.sleep(1000);
		
		
		List<WebElement> toPlace = driver.findElements(By.xpath("//ul[@role='listbox']/descendant::li/div//p[@class='font14 appendBottom5 blackText']"));
		int size = toPlace.size();
		int X = toPlace.get(size-10).getLocation().x;
		int Y = toPlace.get(size-10).getLocation().y;
		System.out.println(X+" "+Y);
		js.executeScript("window.scrollBy("+X+","+Y+")");
		for (WebElement ele1 : toPlace) {
			if (ele1.getText().contains("Goa")) {				
				ele1.click();
				break;
			}
		}
		
		SimpleDateFormat sim = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 2);
		Date date = cal.getTime();
		String day = sim.format(date);
		System.out.println(day);
//		driver.close();
		
		List<WebElement> departure = driver.findElements(By.xpath("//div[@class='DayPicker-Months']/div/descendant::div[@class='DayPicker-Week']/div"));
//		List<WebElement> departureM2 = driver.findElements(By.xpath("//div[@class='DayPicker-Months']/div[2]/descendant::div[@class='DayPicker-Week']/div"));
		
		for (WebElement d1 : departure) {
			if (d1.getText().contains(day)) {
				if (d1.isEnabled()) {
					d1.click();
					break;
				}
				
			}
		}
		Thread.sleep(2000);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, 4);
		Date date2 = cal2.getTime();
		String day1 = sim.format(date2);
		System.out.println(day1);
		
		Thread.sleep(1000);
//		WebElement rtrn = driver.findElement(By.xpath("//div[@data-cy='returnArea']/label/span"));	
		
		js.executeScript("window.scrollBy("+-400+","+-700+")");

		
//		mt.clickon();
//
//		for (WebElement d2 : departure) {
//			if (d2.getText().contains(day1)) {
//				if (d2.isEnabled()) {
//					d2.click();
//					break;
//				}
//				
//			}
//		}
		
		driver.findElement(By.xpath("//a[.='Search']")).click();
		Thread.sleep(1500);
		
		WebElement airlines = driver.findElement(By.xpath("//div[@class='filterWrapper']//p[.='Airlines']"));
		int xx = airlines.getLocation().x;
		int yy = airlines.getLocation().y-150;
		
		js.executeScript("window.scrollBy("+xx+","+yy+")");
		Thread.sleep(1500);
		
		act.click().perform();
		Thread.sleep(1000);
		
		List<WebElement> planes = driver.findElements(By.xpath("//p[.='Airlines']/parent::div/descendant::div[@class='checkboxContent']/p"));
		
		try {
			for (WebElement p : planes) {
				String name = p.getText();
				String no = "";
				for (int i = 0; i < name.length(); i++) {
					if (Character.isDigit(name.charAt(i))) {
						no = no + name.charAt(i);
					}
				}
				int n = Integer.parseInt(no);
				if (n >= 1 && n <= 10) {
					p.click();
				}
			
		}
		}catch(ElementClickInterceptedException e) {
			e.printStackTrace();
		}
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy("+xx+","+yy+")");
		Thread.sleep(1000);
		
		List<WebElement> flightName = driver.findElements(By.xpath("//div[@class='appendBottom15 ']/descendant::div[@class='makeFlex spaceBetween']/div[@class='makeFlex']//p[@class='boldFont blackText airlineName']"));
		
		List<WebElement> time = driver.findElements(By.xpath("//div[@class='appendBottom15 ']/descendant::div[@class='makeFlex spaceBetween']/div[@class='makeFlex']//div[@class='timingOptionOuter']/descendant::p[@class='appendBottom2 flightTimeInfo']/span"));
		
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='appendBottom15 ']/descendant::div[@class='makeFlex spaceBetween']/div[@class='makeFlex']/following-sibling::div[@class='priceSection']/descendant::div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterSmViewPrice']"));
		
		
		for (WebElement f : flightName) {
			System.out.println("Flight Names are... "+f.getText());
		}
		
		for (WebElement p : price) {
			System.out.println("Flight prices are "+p.getText());
		}
		
		for (WebElement t : time) {
			System.out.println("Flight Times are "+t.getText());
		}
		
		driver.close();

	}

}