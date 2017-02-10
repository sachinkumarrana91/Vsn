package rough;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.ExcelReader;
import util.Log;
public class TestDemo {

	
/*	@BeforeMethod
	public void before(){
		Log.startTestCase(new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println("Before");
		Log.endTestCase(new Object(){}.getClass().getEnclosingMethod().getName());
	}	
	
	
	@Test
	public void test1(){
		Log.startTestCase(new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println("Test_1");
		Log.endTestCase(new Object(){}.getClass().getEnclosingMethod().getName());
	}	
	
	@Test
	public void test2(){
		Log.startTestCase(new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println("Test_2");
		Log.endTestCase(new Object(){}.getClass().getEnclosingMethod().getName());
	}	
	
	@AfterMethod
	public void after(){
		Log.startTestCase(new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println("After");
		Log.endTestCase(new Object(){}.getClass().getEnclosingMethod().getName());
	}	
*/	

	public static WebDriver d;

	@Test
	public static void goDelete(){
/*		System.setProperty("webdriver.firefox.marionette","geckodriver.exe");
		d = new FirefoxDriver();
*/
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		d = new ChromeDriver();

		d.get("https://mail.google.com/");
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.manage().window().maximize();

		WebElement e  = d.findElement(By.xpath("//*[@id='Email']"));
		e.clear();
		e.sendKeys("pooja.sen537");
		
		e = d.findElement(By.xpath("//*[@id='next']"));
		e.click();
		
		e = d.findElement(By.xpath("//*[@id='Passwd']"));
		e.clear();
		e.sendKeys("21872187");
		
		e = d.findElement(By.xpath("//*[@id='signIn']"));
		e.click();
		

/*		 do{
             System.out.println(i);
             i--;
        }while(i>1);
*/		

		
		do{
		if(!d.findElement(By.xpath("//*[@id='"+d.findElement(By.xpath("//*[text()='Social']")).getAttribute("id")+"']")).getAttribute("aria-selected").equalsIgnoreCase("true")){
			e = d.findElement(By.xpath("//*[text()='Social']"));
			e.click();
			
		}
			
			
		
		}while(true);
		
		
		
		
	}

	private final static String dcn = "oracle.jdbc.driver.OracleDriver";
	private static Connection con;
	private static Statement stm;

	public static void main(String... sakjnbcdsac) throws Exception{
		
		ExcelReader datatable = new ExcelReader("C://Users//Sachin.kumar//Desktop//get_DC.xlsx");
		String dbUrl = "jdbc:oracle:thin:@//"+"172.16.40.146"+":"+"1522"+"/"+"QA1";		
		try{
			con = DriverManager.getConnection(dbUrl,"willow2k","Nissan13");			
			System.out.println("Connection Created");
			stm = con.createStatement();
			for(int i = 2; i <= datatable.getRowCount("Sheet1"); i++){
				String LineDc = datatable.getCellData("Sheet1", "Line Description", i);
				ResultSet rs = stm.executeQuery("select DC_NO from debit_credit_transactions where reason = 'Correct citation billings' and  line_description = '"+LineDc+"'" );
				//ResultSet rs = stm.executeQuery("select * from debit_credit_transactions" );
				while(rs.next()){
					datatable.setCellData("Sheet1", "getDC", i, rs.getString(1));
					System.out.println(rs.getString(1));
				}
			}
			System.out.println("Execution Finished");
		}
		catch(Exception e){
			System.out.println("Class dbUtil | Method refreshQueue | Exception desc : " + e.getMessage());
			throw(e);
		}
		finally{			
			con.close();
		}


			
			
		
		
	}

	public static String getDCno(int row) throws Exception{

		
		ExcelReader datatable = new ExcelReader("C://Users//Sachin.kumar//Desktop//get_DC.xlsx");
		String dbUrl = "jdbc:oracle:thin:@//"+"172.16.40.146"+":"+"1522"+"/"+"QA1";		
		try{
			con = DriverManager.getConnection(dbUrl,"willow2k","Nissan13");			
			System.out.println("Connection Created");
			stm = con.createStatement();
				String INV = datatable.getCellData("Sheet1", "Invoice #", row);
				ResultSet rs = stm.executeQuery("select * from doc where doc_no = '"+INV+"'" );
				//ResultSet rs = stm.executeQuery("select * from debit_credit_transactions" );
			System.out.println("Execution Finished");

			return rs.getString(1);
		}
		catch(Exception e){
			System.out.println("Class dbUtil | Method refreshQueue | Exception desc : " + e.getMessage());
			throw(e);
		}
		finally{			
			con.close();
		}
	
	}

}
