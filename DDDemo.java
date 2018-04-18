package abcpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DDDemo {

	public static void main(String[] args) throws Exception {
		// Launch browser
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		// Load Web page
		d.get("https://www.facebook.com/");
		//Select a option
		Select dd=new Select(d.findElement(By.id("month")));
		//dd.selectByIndex(4);
		//dd.selectByValue("4");
		dd.selectByVisibleText("Apr");
		System.out.println("Selected Option name is:"+dd.getFirstSelectedOption().getText());
		//pause 4sec
		Thread.sleep(4000);
        //Close browser
		d.quit();
	}

}
