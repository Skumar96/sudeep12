package abcpack;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OR 
{
	WebDriver d;
	OR(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d,this);
	}
	@FindBy(id="cyclosUsername") WebElement txtuname;
	@FindBy(id="cyclosPassword") WebElement txtpassword;
	@FindBy(xpath="//input[@value='Submit']") WebElement btnsubmit;
	@FindBy(xpath="//span[text()='Logout']") WebElement btnlogout;
	
	//Fill Login
	public void fillLogin(String uname,String pwd)
	{
		txtuname.clear();
		txtuname.sendKeys(uname);
		txtpassword.clear();
		txtpassword.sendKeys(pwd);
		txtpassword.sendKeys(Keys.TAB);
		txtpassword.sendKeys(Keys.TAB);
		btnsubmit.click();
		
	}
	//ok
	public void clickOk()
	{
		d.switchTo().alert().accept();
	}
	//Cancel
	public void clickCancel()
	{
		d.switchTo().alert().dismiss();
	}

}
