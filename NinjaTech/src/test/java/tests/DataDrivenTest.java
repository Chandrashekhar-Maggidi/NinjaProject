package tests;

import org.testng.annotations.Test;

import utils.ExcelUtils;

public class DataDrivenTest {
	
	ExcelUtils excelutils = new ExcelUtils();
	
	@Test
	public void dataDriveTest () throws Exception
	{
		excelutils.initiate();
		excelutils.loginTest();
		excelutils.close();
	}

}
