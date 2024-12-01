package base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.CommonUtils;

public class BasePage {
	
	public static WebDriverWait wait;
	public static Properties config;
	public static WebDriver driver;
	
	@BeforeClass
	public static  void setup() throws Exception {
		
	CommonUtils.initialize();
	CommonUtils.launchBrowserAndNavigateToApp();

		
	}
	


	@AfterClass
	public static void quit ()
	{
//		CommonUtils.quit();
	}

}
