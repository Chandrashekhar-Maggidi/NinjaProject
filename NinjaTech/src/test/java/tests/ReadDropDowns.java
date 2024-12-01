package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ReadDropDowns {

		public  Properties config;
		
		public static final String TestdataFile = "\\src\\main\\java\\utils\\Testdata.xlsx";
		
		
		@Test
		public  void readDropDownValues () throws IOException, Exception
		{
			WebDriver driver = new FirefoxDriver();
			driver.get("https://tutorialsninja.com/demo/");
			driver.manage().window().maximize();
			
			WebElement dropdown =driver.findElement(By.xpath("//span[text()='Currency']"));
			List<WebElement> dropdownlist=driver.findElements(By.xpath("//ul[@class=\"dropdown-menu\"]//button"));
			int droplistcount = dropdownlist.size();
			System.out.println("droplistsize " + droplistcount);
		
					
			FileInputStream fis = new FileInputStream (System.getProperty("user.dir")+TestdataFile);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet2");
			 int totalrows =sheet.getLastRowNum()+1;
			 System.out.println("excel rows " + totalrows);
			
			
			ArrayList <String>xlvalues = new ArrayList<String> ();
			
			for (int i=0;i<totalrows;i++)
			{
				xlvalues.add(sheet.getRow(i).getCell(0).getStringCellValue());
			}
			
			
			ArrayList<String> ddvalues = new ArrayList<String>();
			
			for (int j=0; j<dropdownlist.size();j++)
			{
				ddvalues.add(dropdownlist.get(j).getText());
			}
			
			System.out.println("drop down values " +ddvalues);
			for (int k=0; k<totalrows;k++)
			{
				for(int l=0;l<dropdownlist.size();l++)
				{
					if(xlvalues.get(k).equals(ddvalues.get(l)))
					{
						System.out.println(xlvalues.get(k)+"xl values matching with ddvalues" +ddvalues.get(l));
						break;
					}
					else
					{
						System.out.println("xl values is not matching with ddvalues");
					}
				}
			}
			
			
			driver.quit();
		}
	

	}


