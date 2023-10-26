package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Pro {

	/** this method consist of Date,Calendar,SimpleDateFormat,classes and excel data driven
	 *  code according to the cell value
	 * 'Date' class is for getting the current time and date
	 * 'SimpleDateFormat' class is there to set the date format according to you
	 * 'Calendar' class we are using for increase or decrease the date or month and all.
	 * @param args
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
//		int r = new Random().nextInt(3000);
//		System.out.println(r);
		
//		Date d1 = new Date();
//		SimpleDateFormat s1 = new SimpleDateFormat("MM-dd-yyyy");
//		String date = s1.format(d1);
//		System.out.println(date);
		
//		Calendar c1 = Calendar.getInstance();
//		c1.add(Calendar.DATE,-20);
//		Date date = c1.getTime();
//		System.out.println(date);
//		
//		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
//		String res = sim.format(date);
//		System.out.println(res);
		
//		FileInputStream fis1 = new FileInputStream("./files/Book1.xlsx");
//		Workbook book =  WorkbookFactory.create(fis1);
//		Sheet sheet = book.getSheet("Sheet1");
//		int rowCount = sheet.getLastRowNum();
//		
//		String Testun = "kalu7%4";
//		
//		int testRowNum = 0;
//		String actTestUn="";
//		for (int i = 0; i <= rowCount; i++) {
//			try {
//				actTestUn = sheet.getRow(i).getCell(0).toString();
//				if (actTestUn.equalsIgnoreCase(Testun)) {
//					testRowNum = i;
//					break;
//				}
//			} catch (Exception e) {
//				
//			}
//			
//		}
//		System.out.println(testRowNum);
//		
//		String TestPass="ka430";
//		String actColPass = "";
//		int testCellNum = 0;
//		int actCellNum = sheet.getRow(testRowNum).getLastCellNum();
//		for (int j = 0; j < actCellNum; j++) {
//			try {
//				actColPass = sheet.getRow(testRowNum).getCell(j).toString();
//				if (actColPass.equalsIgnoreCase(TestPass)) {
//					testCellNum = j;
//					break;
//				}
//			} catch (Exception e) {
//				
//			}
//		}
//		System.out.println(testCellNum);
//	}

//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, 20);
//		Date datetime = cal.getTime();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//		String date = sdf.format(datetime);
//		System.out.println(date);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notification");
		
		WebDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://www.makemytrip.com");
		Actions act = new Actions(driver);
		act.click().perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-500)");
	}

}