package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageFactoryDemo {
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		// Load Web page
		d.get("http://env-4009812.cloud.cms500.com/do/login");
		assertEquals("Cyclos",d.getTitle());
		
		OR page=new OR(d);
		page.fillLogin("admin","1234");
		
		/*//User Name
		page.txtuname.sendKeys("admin");
		//Enter password
		page.txtpassword.sendKeys("1234");
		page.txtpassword.sendKeys(Keys.TAB);
		page.txtpassword.sendKeys(Keys.TAB);
		//Click on submit
		page.btnsubmit.click();*/
		Thread.sleep(1000);
		//Click on Logout
		page.btnlogout.click();
		//ok
		//d.switchTo().alert().accept();
		page.clickOk();
		Thread.sleep(3000);
		
	}
	@BeforeMethod
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
		//d=new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "E:\\Driver Server\\geckodriver.exe");
	    d = new FirefoxDriver();
	    d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	    d.manage().deleteAllCookies();
	    d.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
	}
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
