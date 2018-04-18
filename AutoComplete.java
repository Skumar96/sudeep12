package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoComplete extends Common
{
	
	@Test
	public void testDragNDrop() throws Exception
	{
		// Load Web page
		d.get("http://jqueryui.com/autocomplete/");
		assertEquals("Autocomplete | jQuery UI",d.getTitle());
		//Switch driver focus to frame
		d.switchTo().frame(0);
		//Type text
		d.findElement(By.id("tags")).sendKeys("a");
		List<WebElement> s=d.findElements(By.className("ui-menu-item"));
		System.out.println("No of suggestions:"+s.size());
		System.out.println("********** Suggestions ******************");
		for(WebElement e:s)
		{
			//System.out.println(e.getText());
			d.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
			if(e.getText().equals("Asp"))
			{
				d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
				assertEquals("Asp",d.findElement(By.id("tags")).getAttribute("value"));
				break;
			}
			Thread.sleep(1000);
		}
		
		Thread.sleep(3000);
	}
	

}
