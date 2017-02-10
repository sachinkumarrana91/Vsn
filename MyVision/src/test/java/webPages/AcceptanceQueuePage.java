package webPages;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Core;
import config.Configuration;

public class AcceptanceQueuePage {
	
	
	WebDriver driver;
	
	public AcceptanceQueuePage(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(how = How.XPATH , using = Configuration.QuoteInput)
	public WebElement QuoteInput;
	
	@FindBy(how = How.XPATH , using = Configuration.SearchButton)
	public WebElement SearchButton;
	
	@FindBy(how = How.XPATH , using = Configuration.StyleOfBody)
	public WebElement StyleOfBody;

	public String QuoteNo = Configuration.QuoteNo;
	
	@FindBy(how = How.XPATH , using = Configuration.AcceptQuote)
	public WebElement AcceptQuote;
	
	@FindBy(how = How.XPATH , using = Configuration.QuoteStatus)
	public WebElement QuoteStatus;
	
	public ArrayList<String> al = new ArrayList<String>();
	
	public void AcceptQuote(String QuoteNo){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
/*		Core.isElementVisible(QuoteInput).sendKeys(QuoteNo);
		Core.isElementVisible(SearchButton).click();
*/
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		if(driver.findElements(By.xpath(this.QuoteNo+QuoteNo+"')]")).size()==1){
			Core.isElementClickable(driver.findElement(By.xpath(this.QuoteNo+QuoteNo+"')]"))).click();
			Core.isElementClickable(AcceptQuote).click();
			al.add("<br> Quote# "+QuoteNo+" Accepted");
			}
		else
			if(driver.findElements(By.xpath(this.QuoteNo+QuoteNo+"')]")).size()==0){
				al.add("<br> Quote# <FONT COLOR=red>"+QuoteNo+"</font> Not Found on Accaptance Quote Page");
				//System.out.println("Quote# "+QuoteNo+" Not Found on Accaptance Quote Page");
				//throw new NoSuchElementException("Not Able to find the Quote No. on Accaptance Quote Form, May be it has already been Accepted/Rejected");
			}
			else{
				al.add("<br> Quote# "+QuoteNo+" Found with multiple entries on Accaptance Quote Page");
				//System.out.println("Quote# <FONT COLOR=red>"+QuoteNo+"</font> Found with multiple entries on Accaptance Quote Page");
				//throw new NoSuchElementException("Duplicate Quotes with the same number found on Accaptance Quote Form");
			}
	}

	public String CheckStatus(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		while(!StyleOfBody.getAttribute("style").contains("none")){
		}
		Core.isElementClickable(QuoteStatus);
		
		return QuoteStatus.getText();
	}

	
	
}
