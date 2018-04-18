package abcpack;

import static org.testng.Assert.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_MySQL {
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		//Load the web page
		d.get("http://env-4009812.cloud.cms500.com/do/login");
		//assertEquals("City Bank of Japan",d.getTitle());
		//DB
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MySQL","root","password12");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from Login;");
			while (rs.next())
			{											
				String username = rs.getString("UserName");
				String pwd = rs.getString("Password");
				//Enter user name
				d.findElement(By.id("cyclosUsername")).clear();
				d.findElement(By.id("cyclosUsername")).sendKeys(username);
				String uname=d.findElement(By.id("cyclosUsername")).getAttribute("value");
				//Enter password
				d.findElement(By.id("cyclosPassword")).clear();
				d.findElement(By.id("cyclosPassword")).sendKeys(pwd);
				String password=d.findElement(By.id("cyclosPassword")).getAttribute("value");
				//Click on Submit
				d.findElement(By.xpath("//input[@value='Submit']")).click();
				Thread.sleep(1000);
				//Blank user name & blank password
				if(uname.equals("") && password.equals(""))
				{
					Alert al=d.switchTo().alert();
					//System.out.println(al.getText());
					assertEquals("Login name is required\nPassword is required\n",al.getText());
					al.accept();
					String sql1="UPDATE Login SET STATUS='Fail' WHERE UserName='"+username+"' and Password='"+pwd+"';";
					PreparedStatement st1=con.prepareStatement(sql1);
					st1.executeUpdate();
				}
				//Blank user name & Invalid password
				else if(uname.equals("") && !(password.equals("")))
				{
					Alert al=d.switchTo().alert();
					assertEquals("Login name is required\n",al.getText());
					al.accept();
					String sql1="UPDATE Login SET STATUS='Fail' WHERE UserName='"+username+"';";
					PreparedStatement st1=con.prepareStatement(sql1);
					st1.executeUpdate();
				}
				//Invalid user name & blank password
				else if(password.equals("") && !(uname.equals("")))
				{
					Alert al=d.switchTo().alert();
					assertEquals("Password is required\n",al.getText());
					al.accept();
					String sql1="UPDATE Login SET STATUS='Fail' WHERE Password='"+pwd+"';";
					PreparedStatement st1=con.prepareStatement(sql1);
					st1.executeUpdate();
				}
				//Valid user name & valid password
				else if(isElementPresent(d, By.xpath("//span[text()='Logout']")))
				{
					//Click on Logout
					d.findElement(By.xpath("//span[text()='Logout']")).click();
					//Switch driver focus to confirmation
					Alert al=d.switchTo().alert();
					al.accept();
					String sql1="UPDATE Login SET STATUS='Pass' WHERE UserName='"+username+"'and Password='"+pwd+"';";
					PreparedStatement st1=con.prepareStatement(sql1);
					st1.executeUpdate();
				}
				//Invalid username & Invalid password
				else if(isElementPresent(d, By.id("btn")))
				{
					d.findElement(By.id("btn")).click();
					String sql1="UPDATE Login SET STATUS='Fail' WHERE UserName='"+username+"'and Password='"+pwd+"';";
					PreparedStatement st1=con.prepareStatement(sql1);
					st1.executeUpdate();
				}
				Thread.sleep(2000);
			}
			st.close();
			con.close();
		}
		catch(Exception ex)
		   {
			System.err.print("Exception: ");
			System.err.println(ex.getMessage());
		   } 
								
		Thread.sleep(4000);
	}
	public boolean isElementPresent(WebDriver driver, By by)
	{
	    d.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
		try{
	        driver.findElement(by);
	        return true;
	    }catch(NoSuchElementException e){
	        return false;
	    }
	}
		
	@BeforeMethod
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.gecko.driver", "E:\\Driver Server\\geckodriver.exe");
		//d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
		d.manage().deleteAllCookies();
	}
	@AfterMethod
	public void tearDown()
	{
		// Close browser
		d.quit();
	}


}
