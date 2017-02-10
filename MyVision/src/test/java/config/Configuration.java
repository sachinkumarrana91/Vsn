package config;

public class Configuration {
	
	//Configuration elements
	//public static final String Report_Folder="E://downloads//Data//Reports//";
	public static final String Report_Folder="C://Program Files//Apache Software Foundation//Tomcat 8.5//webapps//ROOT//TestReports";
	public static final String imgPath = "C://Program Files//Apache Software Foundation//Tomcat 8.5//webapps//ROOT//screenshots//";
	public static final String TestSite="http://vis-qa3/vision/view";
	
	//DB Configuration
	

	//Xpaths


	//LoginPage
	//public static final String signIn="//*[@id='test_to_fail']/div[1]/div/div[1]/div[2]/a[3]";
	public static final String username="//*[@id='j_username']";
	public static final String passsword="//*[@id='j_password']";
	public static final String loginButton="//*[@id='login']";

	//MenuPage
	public static final String OrderToDelivery="//*[@id='menuForm:j_idt19']//*[text()='Order To Delivery']";
	public static final String UnitProcessingChasing = "//*[@id='menuForm:j_idt19']//*[text()='Unit Progress Chasing']";
	//public static final String AcceptanceQueue = "//*[@id='menuForm:j_idt19']//a//*[text()='Acceptance Queue']";
	public static final String AcceptanceQueue = "//*[@id='menuForm']//*[text()='Acceptance Queue']";
	

	//UnitProgressChasingPage
	public static final String PurchaseOrderReleaseButton ="//*[text()='Purchase Order Release']";
	public static final String UnitNoInput ="//*[@id='j_idt65' or text()='Unit No : ']//following-sibling::input[1]";
	public static final String SearchButton ="//*[@id='filter']//span[text()='Search']";
	public static final String maintainPOButton = "//*[@id='maintainPOBtn']/span[text()='Maintain PO']";
	//public static final String UnitNo = "//*[@id='DT_UI_ID_data']//tr[1]/td[4]/span";
	public static final String UnitNo = "//*[@id='DT_UI_ID_data']//td[4]/span[contains(text(),'";//00994274')]";
	public static final String StyleOfBody = "//*[@id='dvQuickModal']";
	public static final String VINTextField = "//*[@id='vin']";
	public static final String DeliveringDealerTextField = "//*[@id='deliveringDealer']";
	public static final String AcquisitionType = "//*[@id='acquisitionType']";
	public static final String SelectAcquisitionType = "//*[@id='acquisitionType_panel']";
	public static final String SaveButton = "//*[@id='saveBtn']";
	public static final String message = "//*[@id='messages']";
	
	public static final String OK = "okBtnId";
	public static final String ReleasePOBtn = "//*[@id='releasePOBtn']";
	public static final String ConfirmPOBtn = "//*[@id='confirmPOBtn']";
	public static final String OrderingLeadTime = "//*[@id='orderingLeadTime']";
	public static final String DocumentList = "//*[@id='documentListDialog:documentListDT_data']";
	
	
	
	//00994275
	//00994274
	//*[@id='DT_UI_ID_data']//td[4]/span[text()='00994275']
	
	
	//AcceptanceQuevePage
	public static final String QuoteInput ="//*[@id='j_idt40' or text()='Quote # : ']//following-sibling::input[1]";
	//public static final String SearchButton ="//*[@id='filter']//span[text()='Search']";
	//public static final String StyleOfBody = "//*[@id='dvQuickModal']";
	//public static final String QuoteNo ="//*[@id='acceptanceTable_data']//tr[1]/td[2]/span";
	public static final String QuoteNo ="//*[@id='acceptanceTable_data']//td[2]/span[contains(text(),'";
	//*[@id='acceptanceTable_data']//td[2]/span[contains(text(),'316357')]
	public static final String AcceptQuote = "//*[@id='acceptReqBtn']/span[text()='Accept Quote']";
	public static final String CheckQuoteNo = "//*[@id='acceptReqBtn']/span[text()='Accept Quote']";
	public static final String QuoteStatus = "//*[@id='messages']/div/ul/li/span";
	
	
	
	
	
	//
	
	
	
	
	
	
	
	
	
}