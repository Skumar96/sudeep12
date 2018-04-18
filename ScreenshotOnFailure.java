package abcpack;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ScreenshotOnFailure {
	WebDriver d;
	@Test
	public void testAjax() throws Exception
	{
		assertEquals("Pass",getScreenshot());		
		Thread.sleep(4000);
	}
	public String getScreenshot() throws Exception
	{
		try
		{
			d.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
			assertEquals("Bank IFSC Codes, MICR Codes: Find IFSC, MICR Codes for Major Banks in India",d.getTitle());
			
			selectOption(d.findElement(By.id("selBank")),"Axis Bank");
			selectOption(d.findElement(By.id("selState")),"Andhra Pradesh");
			selectOption(d.findElement(By.id("selCity")),"Hyderabad");
			selectOption(d.findElement(By.id("selBranch")),"Madhapur12");
			return "Pass";
		}
		catch(Exception e)
		{
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			Date dt = new Date();
			File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("E:\\Selenium_Scripts_Nov17\\Results\\"+dateFormat.format(dt)+".png"));
			return "Fail";
		}
	}
	
	public void selectOption(WebElement locator,String optionname)
	{
		Select dd=new Select(locator);
		dd.selectByVisibleText(optionname);
	}
	
	@Before
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
		//d=new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "E:\\Driver Server\\geckodriver.exe");
	    d = new FirefoxDriver();
	    d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@After
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
