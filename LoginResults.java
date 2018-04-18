package abcpack;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class LoginResults {
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		// Load Web page
		d.get("http://env-4009812.cloud.cms500.com/do/login");
		//assertEquals("SBI_NEWYORK",d.getTitle());
		
		//Read data from excel
		FileInputStream fis=new FileInputStream("E:\\Selenium_Scripts_Nov17\\Test Data\\Login.xls");
		Workbook wb=Workbook.getWorkbook(fis);
		Sheet s=wb.getSheet(0);
		
		FileOutputStream fos=new FileOutputStream("E:\\Selenium_Scripts_Nov17\\Results\\LoginResults.xls");
		WritableWorkbook wwb=Workbook.createWorkbook(fos);
		WritableSheet ws=wwb.createSheet("Result",0);
		
		//Copy data
		for(int i=0;i<s.getRows();i++)
		{
			for(int j=0;j<s.getColumns();j++)
			{
				Label l=new Label(j,i,s.getCell(j, i).getContents());
				ws.addCell(l);
			}
		}
		
		
		for(int i=1;i<s.getRows();i++)
		{
			//Enter user name
			d.findElement(By.id("cyclosUsername")).clear();
			d.findElement(By.id("cyclosUsername")).sendKeys(s.getCell(0, i).getContents());
			String uname=d.findElement(By.id("cyclosUsername")).getAttribute("value");
			//Enter password
			d.findElement(By.id("cyclosPassword")).clear();
			d.findElement(By.id("cyclosPassword")).sendKeys(s.getCell(1, i).getContents());
			d.findElement(By.id("cyclosPassword")).sendKeys(Keys.TAB);
			d.findElement(By.id("cyclosPassword")).sendKeys(Keys.TAB);
			String password=d.findElement(By.id("cyclosPassword")).getAttribute("value");
			//Click on Submit
			d.findElement(By.xpath("//input[@value='Submit']")).click();
			Thread.sleep(1000);
			
			//Blank user name & blank password
			if(uname.equals("") && password.equals(""))
			{
				Alert al=d.switchTo().alert();
				assertEquals("Login name is required\nPassword is required\n",al.getText());
				al.accept();
				Label l=new Label(2,i,"Fail");
				ws.addCell(l);
			}
			//Blank user name & Valid/Invalid password
			else if(uname.equals("") && !(password.equals("")))
			{
				Alert al=d.switchTo().alert();
				assertEquals("Login name is required\n",al.getText());
				al.accept();
				Label l=new Label(2,i,"Fail");
				ws.addCell(l);
			}
			//Blank password & Valid/Invalid user name
			else if(!(uname.equals("")) && password.equals(""))
			{
				Alert al=d.switchTo().alert();
				assertEquals("Password is required\n",al.getText());
				al.accept();
				Label l=new Label(2,i,"Fail");
				ws.addCell(l);
			}
			//Valid user name & Valid password
			else if(isElementPresent(d,By.xpath("//span[text()='Logout']")))
			{
				d.findElement(By.xpath("//span[text()='Logout']")).click();
				//ok
				d.switchTo().alert().accept();
				Label l=new Label(2,i,"Pass");
				ws.addCell(l);
			}
			//Invalid user name & Invalid password
			else if(isElementPresent(d,By.id("btn")))
			{
				d.findElement(By.id("btn")).click();
				Label l=new Label(2,i,"Fail");
				ws.addCell(l);
			}
			Thread.sleep(2000);
		}
		
		wwb.write();
		wwb.close();
		Thread.sleep(3000);
	}
	 private boolean isElementPresent(WebDriver driver,By by) 
	 {
		 driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);   
		 try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
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
