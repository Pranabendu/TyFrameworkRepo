package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import hms.genericutility.WebActionUtility;

public class Scenario1 {
	@Test
	void task() {
		WebActionUtility wau = new WebActionUtility();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/");
		Actions act = new Actions(driver);
		WebElement more = driver.findElement(By.xpath("//nav[@id='site-navigation']/descendant::a[.='More']/span"));
		
		act.moveToElement(more).perform();

		wau.waitForElementInDOM(driver);
		
		WebElement WEBtable = driver.findElement(By.xpath("//nav[@id='site-navigation']/descendant::a[.='Automation Practice | WebTable']"));
		WEBtable.click();
		
		List<WebElement> countries = driver.findElements(By.xpath("//tbody//tr//td[contains(.,'Dollar')]//parent::tr//td[contains(.,'English')]//parent::tr//td[2]"));
		
		for(WebElement ele : countries) {
			System.out.println(ele.getText());
		}
		
		driver.close();
	}
}

//  https://www.aveda.com/
//  https://www.bigbasket.com/    :-  //ul[@id='navBarMegaNav']/following-sibling::div/descendant::div[@class='col-md-3 pad-rt-0 desgn-fix']/following-sibling::div//div[@class='tab-pane active']//a[.='Potato, Onion & Tomato']/parent::li/..//li