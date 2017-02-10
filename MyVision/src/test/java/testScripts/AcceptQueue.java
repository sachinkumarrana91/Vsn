package testScripts;

import java.io.IOException;

import webPages.AcceptanceQueuePage;
import webPages.MenuPage;
import webPages.UnitProgressChasingPage;
import testReports.TestReports;
import util.TestUtil;
import core.Core;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class AcceptQueue extends Core{

	@BeforeMethod
	public void beforeMethod(){
		
		startTime=TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa");
	}

	@Test (priority = 0, enabled = true)
	public void openAcceptanceQueue() {
		try{
			String TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
			setTCName(TestCaseName);
			APPLICATION_LOGS.debug("Test Case: "+TestCaseName+" Starts Running");
			
			MenuPage menuPage = PageFactory.initElements(driver, MenuPage.class);
			menuPage.clickOrderToDelivery();
			menuPage.clickAcceptanceQueue();
			
			Description = "Pass";
			APPLICATION_LOGS.debug("Test Case: "+TestCaseName+" Passed");
			Assert.assertTrue(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
			Description = "Fail : "+e.getMessage();
			APPLICATION_LOGS.debug("Test Case: "+getTCName()+" Failed and error message is : "+e.getMessage());
			Assert.assertTrue(false);
		}
	}
  
	@Test (priority = 2, enabled = true)
	public void acceptQueue() {
		try{
			String TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
			setTCName(TestCaseName);
			APPLICATION_LOGS.debug("Test Case: "+TestCaseName+" Starts Running");
			
			AcceptanceQueuePage aqp = PageFactory.initElements(driver, AcceptanceQueuePage.class);
			for(int i = 2; i <= DataTable.getRowCount(TestCaseName); i++){
				aqp.AcceptQuote(DataTable.getCellData(TestCaseName, "Quote #", i));
			}
			
			
/*			if(aqp.CheckStatus().contains("accepted") && aqp.CheckStatus().contains(DataTable.getCellData(TestCaseName, "Quote #", 2))){
			}
*/			
			Description = "Pass";
			for(int j = 0 ; j< aqp.al.size() ; j++){
				Description = Description.concat(aqp.al.get(j));
			}
			APPLICATION_LOGS.debug("Test Case: "+TestCaseName+" Passed");
			Assert.assertTrue(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
			Description = "Fail : "+e.getMessage();
			APPLICATION_LOGS.debug("Test Case: "+getTCName()+" Failed and error message is : "+e.getMessage());
			Assert.assertTrue(false);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
  @AfterMethod
  	public void AfterMethod() throws IOException{
	  try{	
		  String ScreenShotPath = TestUtil.captureScreenshot(driver, getTCResult());
		  TestReports.addTestCase(getTCName(), 
				  startTime, 
				  TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"),
				  Description.substring(0, 4), 	
				  ScreenShotPath,
				  Description);  
	  }catch(Exception e){
		  System.out.println(e.getMessage());
	  }
	  
  }
  
  
}