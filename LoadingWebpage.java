package abcpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoadingWebpage {

	public static void main(String[] args) throws Exception {
		// Launch browser
		System.setProperty("webdriver.gecko.driver", "E:\\Driver Server\\geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		//Load web page
		d.get("https://www.facebook.com/");
		System.out.println("Page title is:"+d.getTitle());
		//Pause 4 sec
		Thread.sleep(4000);
        //Close browser
		d.quit();
	}

}
