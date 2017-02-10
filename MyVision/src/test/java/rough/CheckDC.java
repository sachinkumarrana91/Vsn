package rough;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import config.Configuration;
import core.Core;
import util.ExcelReader;

public class CheckDC {
	public static WebDriver d;
	public static WebElement e;
	private final static String dcn = "oracle.jdbc.driver.OracleDriver";
	private static Connection con;
	private static Statement stm;
	private static ResultSet rs;
	ExcelReader datatable = new ExcelReader("C://Users//Sachin.kumar//Desktop//get_DC.xlsx");
	String dbUrl = "jdbc:oracle:thin:@//"+"172.16.40.146"+":"+"1522"+"/"+"QA1";		

	
	
	
	@BeforeClass
	public void connectDB() throws SQLException{
		con = DriverManager.getConnection(dbUrl,"willow2k","Nissan13");			
		stm = con.createStatement();
	}
	
	@AfterClass
	public void closeDB() throws SQLException{
		con.close();
	}

	
	
	@BeforeMethod
	public void openEnv(){
		System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
		d = new InternetExplorerDriver();
/*		System.setProperty("webdriver.firefox.marionette","geckodriver.exe");
		d = new FirefoxDriver();
*/		d.get("http://vis-qa1/vision/view");
		d.findElement(By.xpath("//*[@id='j_username']")).clear();
		d.findElement(By.xpath("//*[@id='j_username']")).sendKeys("rajput");
		d.findElement(By.xpath("//*[@id='j_password']")).clear();
		d.findElement(By.xpath("//*[@id='j_password']")).sendKeys("123@wxyz");
		d.findElement(By.xpath("//*[@id='login']")).click();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.manage().window().maximize();
		
		
	}

	@Test
	public void testDC(){
		String LineDescription;
		String DC_No;
		while(!d.findElement(By.xpath("//*[@id='dvQuickModal']")).getAttribute("style").contains("none")){}
		try{
			e = d.findElement(By.xpath("//*[@id='dashboardForm']//a[text()='Search Debit/Credit Memos']"));
			//System.out.println(e.getText());
			e.click();

			for(int i = 2 ; i <= datatable.getRowCount("Sheet1") ; i++){
				System.out.println("Record : "+(i-1));
				
				if(!stm.executeQuery("select * from doc where doc_no = '"+datatable.getCellData("Sheet1", "Invoice #", i)+"'" ).next()){
					LineDescription = datatable.getCellData("Sheet1", "Line Description", i);
							
					rs = stm.executeQuery("select DC_NO from debit_credit_transactions where reason = 'Correct citation billings' and  line_description = '"+LineDescription+"'" );
					if(rs.next()){
					DC_No = rs.getString(1);
					datatable.setCellData("Sheet1", "DC#", i, DC_No);
					
					e = d.findElement(By.xpath("//*[@id='dcNumber']"));
					e.clear();
					e.sendKeys(DC_No);
					e = d.findElement(By.xpath("//*[@id='searchBtn']"));
					e.click();
					while(!d.findElement(By.xpath("//*[@id='dvQuickModal']")).getAttribute("style").contains("none")){}

					while(!d.findElement(By.xpath("//*[@id='dcMemoDataTable']//span[text()='"+DC_No+"']//preceding::span[1]")).getAttribute("class").contains("check")){
						e = d.findElement(By.xpath("//*[@id='dcMemoDataTable']//span[text()='"+DC_No+"']"));
						e.click();
					}
					while(!d.findElement(By.xpath("//*[@id='dvQuickModal']")).getAttribute("style").contains("none")){}
					e = d.findElement(By.xpath("//*[@id='editBtn']"));
					//e = core.Core.isElementClickable(d.findElement(By.xpath("//*[@id='editBtn']")));
					captureScreenshot(d, DC_No+"_Search");
					e.click();
					datatable.setCellData("Sheet1", "executed", i, "YES");
					while(!d.findElement(By.xpath("//*[@id='dvQuickModal']")).getAttribute("style").contains("none")){}
					if(d.findElement(By.xpath("//*[@id='memoType_label']")).getText().equalsIgnoreCase(datatable.getCellData("Sheet1", "Memo Type", i))){
						if(d.findElement(By.xpath("//*[@id='clientId']")).getAttribute("value").equalsIgnoreCase(datatable.getCellData("Sheet1", "Cust#", i))){
							if(d.findElement(By.xpath("//*[@id='unitNo']")).getAttribute("value").equalsIgnoreCase(datatable.getCellData("Sheet1", "Unit#", i))){
								if(d.findElement(By.xpath("//*[@id='analysisCategory_label']")).getText().equalsIgnoreCase(datatable.getCellData("Sheet1", "Analysis Category", i))){
									if(d.findElement(By.xpath("//*[@id='analysisCodeOut']")).getText().equalsIgnoreCase(datatable.getCellData("Sheet1", "Analysis Code", i))){
//										if(d.findElement(By.xpath("//*[@id='netAmount_input']//following-sibling::input[1]")).getAttribute("value").equalsIgnoreCase(datatable.getCellData("Sheet1", "Net Amount", i))){
//											if(d.findElement(By.xpath("//*[@id='taxAmount_input']//following-sibling::input[1]")).getAttribute("value").equalsIgnoreCase(datatable.getCellData("Sheet1", "Tax(full credit only)", i))){
//												if(d.findElement(By.xpath("//*[@id='totalAmountOutput']")).getText().equalsIgnoreCase(datatable.getCellData("Sheet1", "Total", i))){
													if(d.findElement(By.xpath("//*[@id='transactionDate_input']")).getAttribute("value").equalsIgnoreCase("02/07/2017")){
														if(d.findElement(By.xpath("//*[@id='invoiceNo']")).getAttribute("value").equalsIgnoreCase(datatable.getCellData("Sheet1", "Invoice #", i))){
															datatable.setCellData("Sheet1", "Fields", i, "PASS");
														}
													}
//												}
//											}
//										}
									}
								}
							}
						}
					}
					else
						datatable.setCellData("Sheet1", "Fields", i, "FAIL");
						
					e = d.findElement(By.xpath("//*[@id='saveBtn']"));
					captureScreenshot(d, DC_No+"_Record");
					e.click();
					while(!d.findElement(By.xpath("//*[@id='dvQuickModal']")).getAttribute("style").contains("none")){}
					datatable.setCellData("Sheet1", "SaveResult", i, d.findElement(By.xpath("//*[@id='j_idt36']")).getText());
					while(!d.findElement(By.xpath("//*[@id='dvQuickModal']")).getAttribute("style").contains("none")){}
					e = d.findElement(By.xpath("//*[@id='processBtn']"));
					captureScreenshot(d, DC_No+"_SaveResults");
					e.click();
					while(!d.findElement(By.xpath("//*[@id='dvQuickModal']")).getAttribute("style").contains("none")){}
					datatable.setCellData("Sheet1", "ProcessResult", i, d.findElement(By.xpath("//*[@id='j_idt36']")).getText());

					e = d.findElement(By.xpath("//*[@id='cancelBtn']"));
					captureScreenshot(d, DC_No+"_ProcessResults");
					e.click();
					}

					
				}
				else
					datatable.setCellData("Sheet1", "executed", i, "NO");

				
				
				
			}
			
			
		
		
		
		
		}catch(Exception e1){
			//System.out.println(e1);
			e1.printStackTrace();
		}
		
		
		
		
	}
	

public static void captureScreenshot(WebDriver driver, String imgName) throws IOException{
		  
		  String ImageDest = "C://DC_CHeck_SS//";
		  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		  FileUtils.copyFile(scrFile, new File(ImageDest+imgName+ ".jpeg"));
	      	      
	}

	
	
	
}
