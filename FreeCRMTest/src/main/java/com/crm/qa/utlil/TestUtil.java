package com.crm.qa.utlil;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crom.qa.base.TestBase;

public class TestUtil extends TestBase{

	private static final String sheetName = null;
	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICT_WAIT =10;
	
	public static String TESTDATA_SHEET_PATH="C:/Users/SrinivasCheruku/eclipse-workspace"
			+"/javatraining//FreeCRMTest/src/main/java/com/crm//qa/testdata/FreeCrmtestdata.xlsx";
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	public void switchtoframe()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName)	
	{
		FileInputStream file=null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}
		 catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try
		{
			book=WorkbookFactory.create(file);		
	}
	catch(IOException e)	
	{
		e.printStackTrace();
	}
		
		sheet=book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//System.out.println(sheet.getLastRowNum() + "----");
		//sheet.getRow(0).getLastCellNum());
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				//System.out.println(data[i][k]);
			}
			
		}
		
		return data;
	}
	
}
