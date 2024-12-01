package pages;

import java.util.Properties;

import org.openqa.selenium.By;

public class ShoppingcartPage {
	public static Properties properties;
	
	private final By by_shoppingcart =By.xpath("//span[text()='Shopping Cart']");
	private final By by_checkout =By.xpath("//a[text()='Checkout']");
	private final By by_continushopping =By.xpath("//a[text()='Continue Shopping']");
	
	public By getShoppingCart ()
	{
		return by_shoppingcart;
	}
	
	public By getCheckout ()
	{
		return by_checkout;
	}
	
	public By getContShopping ()
	{
		return by_continushopping;
	}
}
