package abcpack;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiDD {
//yaminipriya
	static WebDriver d;
	@BeforeClass
	public static void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
		d=new ChromeDriver();
	}
	@Test
	public void testMultiDD() throws Exception
	{
		// Load Web page
		d.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		
		//Switch driver focus to frame
		d.switchTo().frame(d.findElement(By.id("iframeResult")));
		//Multi DD
		Select dd=new Select(d.findElement(By.name("cars")));
		for(int i=0;i<3;i++)
		{
			dd.selectByIndex(i);
		}
		//Pause 2sec
		Thread.sleep(2000);
		dd.deselectAll();
		Thread.sleep(4000);
	}
	@AfterClass
	public static void tearDown()
	{
		//Close browser
		d.quit();
	}

	
}
