package POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Appointment_History_Page {
	
	List<WebElement> allDatesAndTimes;
	
	public List<WebElement> appointmentDateAndTime(WebDriver driver) {
		
		allDatesAndTimes = driver.findElements(By.xpath("//tbody/tr/td[position()=5]"));
		return allDatesAndTimes;
	}
	
	public void validate(String expectedDateAndTime,WebDriver driver) {
		
		ArrayList<WebElement> a1 = new ArrayList<WebElement>();
		for (int i = 0; i < allDatesAndTimes.size(); i++) {

			a1.add(allDatesAndTimes.get(i));
		}
		int matchingRowNum = 0;
		for (int i = 0; i < a1.size(); i++) {
			if (a1.get(i).getText().equals(expectedDateAndTime)) {
				matchingRowNum = i;
				break;
			}
		}
		
		WebElement particularCancelButton = driver.findElement(By.xpath("(//a[@title='Cancel Appointment'])["+matchingRowNum+"]"));
		particularCancelButton.click();
	}
}
