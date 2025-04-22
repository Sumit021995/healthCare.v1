package com.project.hrm.generic.DataProviderUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.DataProvider;

import com.project.hrm.generic.FileUtility.ExcelUtility;

public class DataProviderUtility {
	ExcelUtility eUtil = new ExcelUtility();
	@DataProvider
	public Object[][] getExcelDataFromDataProvider(String sheetname) throws EncryptedDocumentException, IOException
	{
		
		Sheet sheetRef = eUtil.getSheetRefFromExcel(sheetname);
		int firstRowNum = sheetRef.getFirstRowNum();
		int lastRowNum = sheetRef.getLastRowNum();
		Row rowRef = eUtil.getRowRefFromExcel(sheetname, firstRowNum);
		int firstCellNum = rowRef.getFirstCellNum();
		int lastCellNum  = rowRef.getLastCellNum();
		
		Object [][] objArr=new Object[lastRowNum][lastCellNum];
		for(int i=firstRowNum;i<lastRowNum;i++)
		{
			for(int j=firstCellNum;j<lastCellNum;j++)
			objArr[i][j]=eUtil.getDataFromExcelFile(sheetname, i, j);
			
		}
		return objArr;
		
	}
}
