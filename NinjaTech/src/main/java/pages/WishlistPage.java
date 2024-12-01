package pages;

import java.util.Properties;

import org.openqa.selenium.By;

public class WishlistPage {

	
public static Properties properties;
	
	private final By by_wishlist = By.xpath("//span[normalize-space()='Wish List (0)']");
	private final By by_mywishtxt = By.xpath("//h2[text()='My Wish List']");
	private final By by_continu =By.xpath("//a[text()='Continue']");
	
	public By getWishlist ()
	{
		return by_wishlist;
	}
	
	public By getMywishList ()
	{
		return by_mywishtxt;
	}
	
	public By getContinue ()
	{
		return by_continu;
	}
}
