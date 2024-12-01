package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class ExcelUtils {

	public  Properties config;

	public  WebDriver driver;
	public FileInputStream fis;
	public  XSSFWorkbook wb ;
	public  XSSFSheet sheet;
	public FileOutputStream fos;
	public  final String TestdataFile = "\\src\\main\\java\\utils\\Testdata.xlsx"; 
	LoginPage  lp = new LoginPage();

	
	public void initiate () throws Exception
	{
		CommonUtils.initialize();
		CommonUtils.launchBrowserAndNavigateToApp();
	}
	
	
	public void loginTest () throws Exception
	{
		//	driver = new FirefoxDriver ();
		//	driver.get("https://tutorialsninja.com/demo/");
		//	driver.manage().window().maximize();
		fis = new FileInputStream (System.getProperty("user.dir") + TestdataFile);
		wb = new XSSFWorkbook(fis);
		sheet =wb.getSheet("Sheet1");

		for (int i=1; i<=sheet.getLastRowNum(); i++)
		{
			String username =sheet.getRow(i).getCell(1).getStringCellValue();
			String password =sheet.getRow(i).getCell(2).getStringCellValue();

			//		
			//		Thread.sleep(5000);
			//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
			//		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();
			//		
			//		Thread.sleep(5000);
			//		driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys(username);
			//		driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(password);
			//		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();

			CommonUtils.clickElement(lp.getMyaccount());
			CommonUtils.clickElement(lp.getLogin());
			CommonUtils.enterValue(lp.getEmail(), username, true);
			CommonUtils.enterValue(lp.getPwd(), password, true);
			CommonUtils.clickElement(lp.getLoginBtn());

			try {
				//			String title = driver.getTitle(); 

//				Assert.assertEquals(CommonUtils.getWindowTitle(), "My Account");
				TestngUtils.assertTrue(CommonUtils.getWindowTitle(), "My Account");
				sheet.getRow(i).createCell(3).setCellValue("pass");
				System.out.println("Login Pass");
				//			driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
				CommonUtils.clickElement(lp.getLogout());

			}
			catch (AssertionError e)
			{

				System.out.println("Invalid credentails");
				sheet.getRow(i).createCell(3).setCellValue("fail");

			}
		}

		fos = new FileOutputStream (System.getProperty("user.dir") + TestdataFile);
		wb.write(fos);
		fos.close();


		
	}
	

	public void close ()
	{
		CommonUtils.quit();
	}


}
