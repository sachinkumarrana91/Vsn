package util;

import java.net.InetAddress;
import java.util.Calendar;
import java.util.GregorianCalendar;

import core.Core;


public class TestConfig{


	
	
	public static String testSiteURL = "http://www.MyFisrtAutomationApp.com";
	public static String testBrowser = "*firefox";
	//public static String server="172.207.185.112";
	public static String server="smtp.gmail.com";
	public static String from = "pooja.sen537@gmail.com";
	//public static String from = "aaa@gmail.com";
	public static String password = "21872187";
	public static String[] to ={"sachinkumarrana91@gmail.com"};
	//public static String[] to ={"raman@abcd.com","kjhjk@abc.com"};
	public static String subject = "Test Automation Report";
	public static String port="587";
	public static String username="pooja.sen537@gmail.com";
	public static String subjectattachment = "Automation Report";
/*	public static String messageBody ="Hi,"+
										"<br>"+
										"<br>"+
										"Complete automation script has been executed, please check the attachment named Automation Report for exection results."+
										"<br>"+
										"<br>"+
										"<b>Thanks!</b><br>Automation Team";
*/	
	public static String messageBody ="Hi," +
											"<br>"+
											"<br>"+
											"Complete automation script has been executed, please check the attachment named Automation Report for exection results."+
											" <br><br><b>Please click on the below link to check the report</b>"+"<br>"+
											"<br>"+
											"http://"+TestUtil.Handeler()+":8080"+"/TestReports/"+Core.strDate+".html"+
											"<br>"+
											"<br>"+
											"<b>Thanks!</b><br>Automation Team";
		
		
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://172.168.150.127;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$qler!!1"; 
	
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "pasrd";
	public static String mysqlurl = "jdbc:mysql://172.16.150.111/monitor_dm";
	//public static String attachmentPath="C:/Selenium3.0/app/test/Framework/AutomationBvt_Hybrid/Reports.zip";
	//public static String attachmentPath="C:/Selenium3.0/app/test/Framework/testweb/WebContent/webpages/index"+DriverScript.year+"_"+DriverScript.date+"_"+(DriverScript.month+1)+"_"+DriverScript.day+"_"+DriverScript.min+"_" +DriverScript.sec+".html";
	//public static String attachmentPath="C:/Selenium3.0/app/test/Framework/testweb/WebContent/webpages/index"+DriverScript.year+"_"+DriverScript.date+"_"+(DriverScript.month+1)+"_"+DriverScript.day+"_"+DriverScript.min+"_" +DriverScript.sec+".html";
	//public static String attachmentPath="C:/CMAutomation/tomcat-6.0/webapps/ROOT/screenshots/"+DriverScript.mailscreenshotpath+".jpeg";
	public static String attachmentPath=System.getProperty("user.dir")+"//test-output//emailable-report.html";
	//public static String attachmentPath=DriverApp.mailscreenshotpath+".jpeg";
	public static String attachmentName="Automation Report";
	//public static String filepath="C:/Selenium3.0/app/test/Framework/testweb/WebContent/webpages";
	
	
	
	
	
	
	
	
}
