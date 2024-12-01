package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BasePage;
import pages.CheckOutPage;
import pages.EditAccountPage;
import pages.LoginPage;
import pages.SearchProductPage;
import pages.ShoppingcartPage;
import pages.WishlistPage;
import utils.CommonUtils;
import utils.TestngUtils;

public class TestHomePage extends BasePage{
	
	public static WebDriverWait wait;
	public static Properties config;
	public static WebDriver driver;
	
	LoginPage loginpage = new LoginPage();
	SearchProductPage searchpage = new SearchProductPage();
	WishlistPage wishlistpage = new WishlistPage ();
	ShoppingcartPage shoppingcartpage = new ShoppingcartPage();
	EditAccountPage editaccountpage = new EditAccountPage();
	CheckOutPage checkoutpage = new CheckOutPage();
	
	@Test(priority=0, description ="check login functionality")
	public  void verifyLoginPage ()
	{
		loginpage.login();
	}
	
	@Test(priority=1, description="check the search functionality")
	public void verifySearchFunction ()
	{
		CommonUtils.clickElement(searchpage.getSearch());
		CommonUtils.enterValue(searchpage.getSearch(), "MacBook", true);
		CommonUtils.clickElement(searchpage.getSearchBtn());
		CommonUtils.clickElement(searchpage.getMacbook());
		CommonUtils.isElementDisplayed(searchpage.getAddcart());
		CommonUtils.clickElement(searchpage.getHomeIcon());
	}
	
	@Test(priority=2, description = "navigate to wishlist page")
	public void navigateToWislist ()
	{
		CommonUtils.clickElement(wishlistpage.getWishlist());
		CommonUtils.isElementDisplayed(wishlistpage.getMywishList());
		TestngUtils.assertTrue(CommonUtils.getElementText(wishlistpage.getMywishList()), "My Wish List");
		CommonUtils.clickElement(wishlistpage.getContinue());
	}
	
	@Test(priority=3, description=" navigate to shopping cart")
	public  void shoppingCart ()
	{
		CommonUtils.clickElement(shoppingcartpage.getShoppingCart());
		CommonUtils.scrollToElement(shoppingcartpage.getCheckout());
		CommonUtils.clickElement(shoppingcartpage.getContShopping());
	}
	
	@Test(priority=4,description="edit account details")
	public  void editAccountInformation ()
	{
		CommonUtils.clickElement(loginpage.getMyaccount());
		CommonUtils.clickElement(editaccountpage.getMyaccountDropdown());
		CommonUtils.clickElement(editaccountpage.getEditaccount());
		CommonUtils.enterValue(editaccountpage.getTelephone(), "12345234", true);
		CommonUtils.clickElement(editaccountpage.getContinue());
		CommonUtils.isElementDisplayed(editaccountpage.getSuccess());
		TestngUtils.assertTrue("Success: Your account has been successfully updated.",CommonUtils.getElementText(editaccountpage.getSuccess()));
		System.out.println("Account success Notification : " +CommonUtils.getElementText(editaccountpage.getSuccess()));
	}
	
	@Test(priority=5, description="naigate to checkout page")
	public void verifyCheckoutPage ()
	{
		CommonUtils.clickElement(checkoutpage.getCheckout());
		CommonUtils.scrollToElement(checkoutpage.getCheckoutBtn());
		CommonUtils.clickElement(checkoutpage.getContinue());
	}
	

}
