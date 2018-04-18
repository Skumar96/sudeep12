package abcpack;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfirmationDemo {
	WebDriver d;
	@Test
	public void testConfirmation() throws Exception
	{
		// Load Web page
		d.get("http://output.jsbin.com/enifaf");
		d.findElement(By.xpath("//button[@onclick='launchConfirm()']")).click();
		Thread.sleep(1000);
		//Switch driver focus to confirmation
		Alert al=d.switchTo().alert();
		//Verify confirmation text
		assertEquals("Press a button!",al.getText());
		//Cancel
		al.dismiss();
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
