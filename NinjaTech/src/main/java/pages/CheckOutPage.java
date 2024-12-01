package pages;

import java.util.Properties;

import org.openqa.selenium.By;

public class CheckOutPage {
	
	public  Properties properties;
	
	private final By by_checkout = By.xpath("//span[text()='Checkout']");
	private final By by_checkoutbtn =By.xpath("//a[@class=\"btn btn-primary\"]");
	private final By by_continueshopping =By.xpath("//a[text()='Continue Shopping']");
	
	
	public By getCheckout ()
	{
		return by_checkout;
	}
	
	public By getCheckoutBtn ()
	{
		return by_checkoutbtn;
	}
	
	public By getContinue ()
	{
		return by_continueshopping;
	}

}
