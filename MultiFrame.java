package abcpack;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiFrame {
	WebDriver d;
	@Test
	public void testFrame() throws Exception
	{
		// Load Web page
		d.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
		//Print no of frames
		//System.out.println("No of Frames:"+d.findElements(By.tagName("iframe")).size());
		//Switch driver focus to 1st frame
		d.switchTo().frame(0);
		d.findElement(By.linkText("com.thoughtworks.selenium")).click();
		//Switch driver focus outside frame
		d.switchTo().defaultContent();
		//Switch driver focus to 2nd frame
		d.switchTo().frame(1);
		d.findElement(By.linkText("Selenium")).click();
		//Switch driver focus outside frame
		d.switchTo().defaultContent();
		//Switch driver focus to 3rd frame
		d.switchTo().frame(2);
		d.findElement(By.linkText("DefaultSelenium")).click();
		Thread.sleep(4000);
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
