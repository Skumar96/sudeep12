package abcpack;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameDemo {
	WebDriver d;
	@Test
	public void testFrame() throws Exception
	{
		// Load Web page
		d.get("http://jqueryui.com/autocomplete/");
		assertEquals("Autocomplete | jQuery UI",d.getTitle());
		//Switch driver focus to frame
		d.switchTo().frame(d.findElement(By.className("demo-frame")));
		//Type text
		d.findElement(By.id("tags")).sendKeys("Selenium");
		Thread.sleep(2000);
		
		//Switch driver focus outside frame
		d.switchTo().defaultContent();
		//Click on Button
		d.findElement(By.linkText("Button")).click();
		Thread.sleep(3000);
	}
	@Before
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
		//d=new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "E:\\Driver Server\\geckodriver.exe");
	    d = new FirefoxDriver();
	    d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
	}
	@After
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
