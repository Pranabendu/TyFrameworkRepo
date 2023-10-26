package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromExcelByDataProvider {
	
	@DataProvider(name = "roy")
	String [][] provide() throws EncryptedDocumentException, IOException{
		int lastrownum = 0;
		
		FileInputStream finp = new FileInputStream("./files/Book1.xlsx");
		Workbook book = WorkbookFactory.create(finp);
		Sheet sheet = book.getSheet("Sheet1");
		lastrownum = sheet.getLastRowNum();

		String [][] arr = new String[lastrownum][2];
		try {
			for (int i = 0; i < lastrownum; i++) {
				for (int j = 0; j < 2; j++) {
					Row row = sheet.getRow(i);
					Cell cell = row.getCell(j);
					String value = cell.toString();
					arr[i][j] = value;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arr;	
	}
	
	@Test(dataProvider = "roy")
	void use(String u,String p) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.fb.com");
		 driver.findElement(By.xpath("//input[@id='email']")).sendKeys(u);
		 Thread.sleep(1500);
		 driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(p);
		 Thread.sleep(1500);
		 driver.close();
	}
}