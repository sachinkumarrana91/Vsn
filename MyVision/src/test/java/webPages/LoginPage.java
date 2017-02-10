package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Core;
import config.Configuration;

public class LoginPage {
	
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(how = How.XPATH , using = Configuration.username)
	public WebElement username;
	
	@FindBy(how = How.XPATH , using = Configuration.passsword)
	public WebElement passsword;
	
	@FindBy(how = How.XPATH , using = Configuration.loginButton)
	public WebElement loginButton;
	
	
	public MenuPage doLogin(String UserName, String Password){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		username.sendKeys(UserName);
		passsword.sendKeys(Password);
		loginButton.click();

		return PageFactory.initElements(driver, MenuPage.class);
	}
	
	
	
}
