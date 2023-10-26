package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class FetchFromTestData {
	@Test
	void data() throws EncryptedDocumentException, IOException {
		FileInputStream fin = new FileInputStream("./files/testData.xlsx");
		Workbook book = WorkbookFactory.create(fin);
		Sheet sheet = book.getSheet("Sheet1");
		
	}
}