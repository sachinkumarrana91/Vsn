package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserFactory{

	static WebDriver driver;
	static WebDriverWait waitForMe;
	
	public static WebDriver startBrowser(String browserName){
		int browser_code = 0;
		if(browserName.equalsIgnoreCase("Firefox")) browser_code = 1;
		if(browserName.equalsIgnoreCase("Chrome")) browser_code = 2;
		
		switch (browser_code){
			case 1:
				if (driver == null){
					System.setProperty("webdriver.firefox.marionette","geckodriver.exe");
					driver = new FirefoxDriver();
					}
				break;

			case 2:
				if (driver == null){
					System.setProperty("webdriver.chrome.driver","chromedriver.exe");
					driver = new ChromeDriver();
				}
				break;
		}
		return driver;
	} 

	public static WebElement isElementLoaded(WebElement elementToBeLoaded){
		
		waitForMe = new WebDriverWait(driver, 30);
		WebElement element = waitForMe.until(ExpectedConditions.visibilityOf(elementToBeLoaded));		
		return element;
	}
}
