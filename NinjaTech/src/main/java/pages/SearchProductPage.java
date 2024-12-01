package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProductPage {
	
	public static WebDriverWait wait;
	public static Properties config;
	public static WebDriver driver;

	private final By by_search = By.xpath("//input[@name=\"search\"]");
	private final By by_searchbtn =By.xpath("//button[@class=\"btn btn-default btn-lg\"]");
	private final By by_mackbookproduct =By.xpath("//a[text()='MacBook']");
	private final By by_addcart =By.xpath("//button[text()='Add to Cart']");
	private final By by_homeicon =By.xpath("//i[@class=\"fa fa-home\"]");
	
	
	public By getSearch ()
	{
		return by_search;
	}
	
	public By getSearchBtn ()
	{
		return by_searchbtn;
	}
	
	public By getMacbook ()
	{
		return by_mackbookproduct;
	}
	
	public By getAddcart ()
	{
		return by_addcart;
	}
	
	public By getHomeIcon ()
	{
		return by_homeicon ;
	}
}

