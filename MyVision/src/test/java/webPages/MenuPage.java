package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Core;
import config.Configuration;

public class MenuPage {


	WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(how = How.XPATH , using = Configuration.OrderToDelivery)
	public WebElement OrderToDelivery;
	
	@FindBy(how = How.XPATH , using = Configuration.UnitProcessingChasing)
	public WebElement UnitProcessingChasing;
	
	@FindBy(how = How.XPATH , using = Configuration.AcceptanceQueue)
	public WebElement AcceptanceQueue;

	
	
	
	
	public void clickOrderToDelivery(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		if(!OrderToDelivery.getAttribute("aria-expanded").equalsIgnoreCase("true")){
		Core.isElementVisible(OrderToDelivery).click();
		}
	}
	
	
	public UnitProgressChasingPage clickUnitProcessingChasing(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		Core.isElementVisible(UnitProcessingChasing).click();
		
		return PageFactory.initElements(driver, UnitProgressChasingPage.class);
	}
	
	public AcceptanceQueuePage clickAcceptanceQueue(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		Core.isElementVisible(AcceptanceQueue).click();
		
		return PageFactory.initElements(driver, AcceptanceQueuePage.class);
	}
	
}
