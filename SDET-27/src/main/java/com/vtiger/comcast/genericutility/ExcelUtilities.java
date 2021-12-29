package com.vtiger.comcast.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * used to read and write data from excel sheet
 * @author Priya
 *
 */
public class ExcelUtilities {
	
	/**
	 * Used to read data from excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param columnnum
	 * @return string
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetname,int rownum,int columnnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./Data/Excel/Orgname.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rownum).getCell(columnnum).getStringCellValue();
		wb.close();
		return data;
	}
	
	/**
	 * Used to write data in excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param columnnum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataToExcel(String sheetname,int rownum,int columnnum,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./Data/Excel/Orgname.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(rownum).getCell(columnnum).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./Data/Excel/Orgname.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	/**
	 * Used to get the number of rows in an excel sheet
	 * @param sheetname
	 * @return int
	 * @throws Throwable
	 * @throws IOException
	 */
	
	public int getRowCount(String sheetname) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("./Data/Excel/Orgname.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int rowCount = sh.getLastRowNum();
		return rowCount;
	}
	
}
