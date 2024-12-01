package pages;

import java.util.Properties;

import org.openqa.selenium.By;

public class CurrencyDropDown {
	
	public  Properties properties;
	public  Properties config;
	
	private final By by_currency =By.xpath("//span[text()='Currency']");
	private final By by_currencylist =By.xpath("//ul[@class=\"dropdown-menu\"]//button");
	
	
	public By getCurrency ()
	{
		return by_currency;
	}
	
	public By geCurrencytList ()
	{
		return by_currencylist;
	}

}
