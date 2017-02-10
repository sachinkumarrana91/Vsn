package webPages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Core;
import config.Configuration;

public class UnitProgressChasingPage {
	
	
	WebDriver driver;
	
	public UnitProgressChasingPage(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(how = How.XPATH , using = Configuration.PurchaseOrderReleaseButton)
	public WebElement PurchaseOrderReleaseButton;
	
	@FindBy(how = How.XPATH , using = Configuration.UnitNoInput)
	public WebElement UnitNoInput;
	
	@FindBy(how = How.XPATH , using = Configuration.SearchButton)
	public WebElement SearchButton;
	
	public String UnitNo = Configuration.UnitNo;
	
	@FindBy(how = How.XPATH , using = Configuration.maintainPOButton)
	public WebElement maintainPOButton;
	
	@FindBy(how = How.XPATH , using = Configuration.StyleOfBody)
	public WebElement StyleOfBody;
	
	@FindBy(how = How.XPATH , using = Configuration.VINTextField)
	public WebElement VINTextField;
	
	@FindBy(how = How.XPATH , using = Configuration.DeliveringDealerTextField)
	public WebElement DeliveringDealerTextField;
	
	@FindBy(how = How.XPATH , using = Configuration.SaveButton)
	public WebElement SaveButton;
	
	@FindBys( {
		   @FindBy(how = How.ID , using = Configuration.OK)
	})
	public List<WebElement> OK;

	@FindBy(how = How.ID , using = Configuration.OK)
	public WebElement OKAccept;
	
	@FindBy(how = How.XPATH , using = Configuration.AcquisitionType)
	public WebElement AcquisitionType;
	
	public String SelectAcquisitionType = Configuration.SelectAcquisitionType;
	
	@FindBy(how = How.XPATH , using = Configuration.ReleasePOBtn)
	public WebElement ReleasePOBtn;
	
	@FindBy(how = How.XPATH , using = Configuration.ConfirmPOBtn)
	public WebElement ConfirmPOBtn;
	
	@FindBy(how = How.XPATH , using = Configuration.OrderingLeadTime)
	public WebElement OrderingLeadTime;

	public String DocumentList = Configuration.DocumentList;

	public String message = Configuration.message;

	
	public ArrayList<String> al = new ArrayList<String>();
	
	
	
	public void clickPurchaseOrderReleaseButton(){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		PurchaseOrderReleaseButton.click();
	}
	

	public void savePO(String UnitNo,String VIN, String DealerCode, String SelectAcquisitionType) throws InterruptedException{
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");

		if(driver.findElements(By.xpath(this.UnitNo+UnitNo+"')]")).size()==1){
			Core.isElementClickable(driver.findElement(By.xpath(this.UnitNo+UnitNo+"')]"))).click();
			Core.isElementClickable(maintainPOButton).click();
			al.add("<br> Unit# "+UnitNo+" Found to proceed");

			Core.isElementVisible(VINTextField).sendKeys(VIN);
			Core.isElementVisible(DeliveringDealerTextField).clear();
			Core.isElementVisible(DeliveringDealerTextField).sendKeys(DealerCode);
			while(!driver.findElement(By.xpath(this.SelectAcquisitionType)).isDisplayed()){
			Core.isElementClickable(AcquisitionType).click();
			}
			Core.isElementClickable(driver.findElement(By.xpath(this.SelectAcquisitionType+"//*[text()='"+SelectAcquisitionType+"']"))).click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			
			if(!Core.isElementVisible(OrderingLeadTime).getAttribute("style").contains("color: darkgray")){
				OrderingLeadTime.clear();
				OrderingLeadTime.sendKeys("10");
			}
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			
			Core.isElementClickable(SaveButton).click();
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			if(OK.size()>0 && OKAccept.isDisplayed()){
				 OKAccept.click();
			 }
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			if(OK.size()>0 && OKAccept.isDisplayed()){
				 OKAccept.click();
			 }
			while(!StyleOfBody.getAttribute("style").contains("none")){}
	/*		if(driver.findElement(By.xpath(message+"//*[contains(text(),'Purchase order for Unit No') AND contains(text(),'saved successfully')]")).isDisplayed()){
			}
	*/		
		
		}
		else
			if(driver.findElements(By.xpath(this.UnitNo+UnitNo+"')]")).size()==0){
				al.add("<br> Unit# <FONT COLOR=red>"+UnitNo+"</font> Not Found");
				System.out.println("Unit# "+UnitNo+" Not Found ");
				//throw new NoSuchElementException("Not Able to find the Unit No. on Purchase Order Release Page");
			}
			else{
				al.add("<br> Unit# "+UnitNo+" Found with multiple entries");
				System.out.println("Unit# <FONT COLOR=red>"+UnitNo+"</font> Found with multiple entries");
				//throw new NoSuchElementException("Duplicate entries for Unit No. "+UnitNo+" with the same number found on Accaptance Quote Form");
			}
		
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		
}

	
	public void releasePO(String UnitNo){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		while(!StyleOfBody.getAttribute("style").contains("none")){}
		if(driver.findElements(By.xpath(this.UnitNo+UnitNo+"')]")).size()==1){
			Core.isElementClickable(driver.findElement(By.xpath(this.UnitNo+UnitNo+"')]"))).click();
			Core.isElementClickable(maintainPOButton).click();
			al.add("<br> Unit# "+UnitNo+" Found to release");
		
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			if(ReleasePOBtn.getAttribute("aria-disabled").contentEquals("false")){
				ReleasePOBtn.click();
			}
			else{
				throw new NoSuchElementException(UnitNo+" has already been release please proceed to confirm the unit");
			}
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			if(OK.size()>0 && OKAccept.isDisplayed()){
				 OKAccept.click();
			 }
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			if(OK.size()>0 && OKAccept.isDisplayed()){
				 OKAccept.click();
			 }
			while(!StyleOfBody.getAttribute("style").contains("none")){}
			}
		else
			if(driver.findElements(By.xpath(this.UnitNo+UnitNo+"')]")).size()==0){
				al.add("<br> Unit# <FONT COLOR=red>"+UnitNo+"</font> Not Found for release");
				System.out.println("Unit# "+UnitNo+" Not Found for release");
				//throw new NoSuchElementException("Not Able to find the Unit No. on Purchase Order Release Page for Relase");
			}
			else{
				al.add("<br> Unit# <FONT COLOR=red>"+UnitNo+"</font> Found with duplicate entries");
				System.out.println("Unit# "+UnitNo+" Found with duplicate entries");
				//throw new NoSuchElementException("Duplicate entries for Unit No. "+UnitNo+" with the same number found on Purchase Order Release Page for Relase");
			}
			while(!StyleOfBody.getAttribute("style").contains("none")){}
	}
	
	public void confirmPO(String UnitNo){
		Core.APPLICATION_LOGS.debug("Test Method: "+new Object(){}.getClass().getEnclosingMethod().getName()+" Starts Running");
		if(driver.findElements(By.xpath(this.UnitNo+UnitNo+"')]")).size()==1){
			Core.isElementClickable(driver.findElement(By.xpath(this.UnitNo+UnitNo+"')]"))).click();
			Core.isElementClickable(maintainPOButton).click();
			al.add("<br> Unit# "+UnitNo+" Found to confirm");

			while(!StyleOfBody.getAttribute("style").contains("none")){}
			//Confirm Button clicking
			if(ConfirmPOBtn.getAttribute("aria-disabled").contentEquals("false")){
				ConfirmPOBtn.click();
				
				while(!StyleOfBody.getAttribute("style").contains("none")){}
				if(OK.size()>0 && OKAccept.isDisplayed()){
					 OKAccept.click();
				 }
				while(!StyleOfBody.getAttribute("style").contains("none")){}
				if(OK.size()>0 && OKAccept.isDisplayed()){
					 OKAccept.click();
				 }
				while(!StyleOfBody.getAttribute("style").contains("none")){}
			
				if(driver.findElement(By.xpath(DocumentList)).isDisplayed()){
					for(int i= 1 ; i <= driver.findElements(By.xpath(DocumentList+"/tr")).size() ; i++){
						if(driver.findElement(By.xpath(DocumentList+"/tr["+i+"]/td[2]//a")).getText().equalsIgnoreCase("View")){
							driver.findElement(By.xpath(DocumentList+"/tr["+i+"]/td[2]//a")).click();
						}
					}
				}
			
			}
			else{
				throw new NoSuchElementException(UnitNo+" may be not released yet ! Please release the Unit first than go for confirm");
			}
			while(!StyleOfBody.getAttribute("style").contains("none")){}
		}
	
		else
			if(driver.findElements(By.xpath(this.UnitNo+UnitNo+"')]")).size()==0){
				al.add("<br> Unit# <FONT COLOR=red>"+UnitNo+"</font> Not Found to confirm");
				System.out.println("Unit# "+UnitNo+" Not Found to confirm");
				//throw new NoSuchElementException("Not Able to find the Unit No. on Purchase Order Release Page for Confirm");
			}
			else{
				al.add("<br> Unit# <FONT COLOR=red>"+UnitNo+"</font> Found with duplicate entries");
				System.out.println("Unit# "+UnitNo+" Found with duplicate entries");
				//throw new NoSuchElementException("Duplicate entries for Unit No. "+UnitNo+" with the same number found on Purchase Order Release Page for ConfirmPO");
			}
	}
	
}
