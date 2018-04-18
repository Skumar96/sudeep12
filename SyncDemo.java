package abcpack;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class SyncDemo {
	WebDriver d;
	@Test
	public void testSync() throws Exception
	{
		// Load Web page
		d.get("https://www.google.co.in");
		assertEquals("Google",d.getTitle());
		//Type text
		d.findElement(By.id("lst-ib")).sendKeys("Selenium");
		//Click on Google search button
		d.findElement(By.xpath("//input[@value='Google Search']")).click();
		//Explicit Wait
		WebDriverWait wait=new WebDriverWait(d,120);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Selenium - Web Browser Automation")));
		
		//Click Selenium - Web Browser Automation
		d.findElement(By.linkText("Selenium - Web Browser Automation")).click();
		//Click on Projects
		d.findElement(By.linkText("Projects")).click();
		Thread.sleep(4000);
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
	    d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
	}
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
