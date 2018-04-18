package abcpack;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiWindow {
	WebDriver d;
	@Test
	public void testMultiWindows() throws Exception
	{
		// Load Web page
		d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
		//Click on Flights
		d.findElement(By.linkText("Flights")).click();
		Thread.sleep(4000);
		Set<String> h=d.getWindowHandles();
		System.out.println("No of handles:"+h.size());
		System.out.println("***************** Handles are *********************");
		String handles[]=new String[h.size()];
		int i=0;
		for(String s:h)
		{
			System.out.println(s);
			handles[i]=s;
			i++;
		}
		//Switch driver focus IRCTC to Flights
		d.switchTo().window(handles[1]);
		assertTrue(d.findElement(By.id("origin")).isDisplayed());
		Thread.sleep(4000);
		//Switch driver focus Flights to IRCTC
		d.switchTo().window(handles[0]);
		assertTrue(d.findElement(By.id("usernameId")).isDisplayed());
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
	    d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	    d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
	}
	@After
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
