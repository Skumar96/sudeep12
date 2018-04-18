package abcpack;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDemo {
	WebDriver d;
	@Before
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
		d=new ChromeDriver();
	}
	@Test
	public void testWeb() throws Exception
	{
		// Load Web page
		d.get("https://www.facebook.com/");
		//System.out.println(d.getTitle());
		//Verify page title
		assertEquals("Facebook – log in or sign up",d.getTitle());
		//Verify user name textbox
		assertTrue(d.findElement(By.id("email")).isDisplayed());
		//Enter user name
		d.findElement(By.id("email")).sendKeys("selenium");
		System.out.println("User Name:"+d.findElement(By.id("email")).getAttribute("value"));
		//Enter password
		d.findElement(By.id("pass")).sendKeys("selenium");
		//Click on Login
		d.findElement(By.xpath("//label[@id='loginbutton']/input")).click();
		//pause 4sec
		Thread.sleep(4000);
	}
	@After
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
