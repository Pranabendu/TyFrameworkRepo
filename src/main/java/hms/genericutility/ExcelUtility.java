package hms.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	/**
	 * this method is for Get Data From Excel
	 * @param filepath
	 * @param sheetname
	 * @param rownum
	 * @param colnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDatafromExcel(String filepath,String sheetname,int rownum,int colnum) throws EncryptedDocumentException, IOException {
		FileInputStream fin = new FileInputStream(filepath);
		Workbook book = WorkbookFactory.create(fin);
		String data = book.getSheet(sheetname).getRow(rownum).getCell(colnum).toString();
		book.close();
		return data;
	}
	
	/**
	 * this method is for get Data From Excel Based on TestId
	 * @param filepath
	 * @param sheetname
	 * @param testid
	 * @param colvalue
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcelBasedTestId(String filepath,String sheetname,String testid,String colvalue) throws EncryptedDocumentException, IOException {
		FileInputStream fin = new FileInputStream(filepath);
		Workbook book = WorkbookFactory.create(fin);
		Sheet sheet = book.getSheet(sheetname);
		int rownum = sheet.getLastRowNum();
		
		String alltestIds = "";
		int testidrownum = 0;
		for (int i = 0; i < rownum; i++) {
			try {
				alltestIds =sheet.getRow(i).getCell(0).toString();
				if (alltestIds.equalsIgnoreCase(testid)) {
					testidrownum = i;
					break;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		int cellcount = sheet.getRow(testidrownum).getLastCellNum(); 
		String allcellvalues = "";
		String actualvalue = "";
		for (int j = 0; j < cellcount; j++) {
			try {
				allcellvalues = sheet.getRow(testidrownum).getCell(j).toString();
				if (allcellvalues.equalsIgnoreCase(colvalue)) {
					actualvalue = allcellvalues;
					break;
				}
			} catch (Exception e) {
				
			}
		}
		
		book.close();
		return actualvalue;
				
	}

	private void setdataInExcel(String filepath,String sheetname,int rownum,int cellnum,String input) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filepath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.createRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(input);
		FileOutputStream fos = new FileOutputStream(filepath);
		book.write(fos);
		book.close();
	}
}