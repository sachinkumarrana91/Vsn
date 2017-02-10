package testReports;


import java.io.*;

import util.TestUtil;


public class TestReports {
	public static int scriptNumber=1;
	public static String indexResultFilename;
	public static String currentDir;
	public static String currentSuiteName;
	public static int tcid;
	//public static String currentSuitePath;
	
	public static double passNumber;
	public static double failNumber;
	public static boolean newTest=true;
	
	public static void startTesting(String filename,String testStartTime,String env,String rel)
	  {
		indexResultFilename = filename;
		currentDir = indexResultFilename.substring(0,indexResultFilename.lastIndexOf("//"));
		
		System.out.println("Current directory is: "+currentDir);
		System.out.println("Current filename is: "+indexResultFilename);
		
		FileWriter fstream =null;
		 BufferedWriter out =null;
	      try{
	    // Create file 
	   
	     fstream = new FileWriter(filename);
	     out = new BufferedWriter(fstream);

        String RUN_DATE = TestUtil.now("dd.MMMMM.yyyy").toString();
	    
	    String ENVIRONMENT = env;
	    String RELEASE = rel;
	    
	    out.newLine();
	  
	    out.write("<html>\n");
	    out.write("<HEAD>\n");
	    out.write(" <TITLE>Devil Project</TITLE>\n");
	     out.write("</HEAD>\n");
	     
	     out.write("<body>\n");
	   
	   
	     out.write("<table  border=0 cellspacing=0 cellpadding=0 >\n");
	     out.write("<tr>\n");
	     
	    out.write("<td width=150 align=left><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75> <img src='cm_logo.png' align=right></img></td>\n"); 
	     
	         
	     out.write("</tr>\n");
	     
	     out.write("</table>\n");
	     out.write("<h2 align=center><FONT COLOR=660066 FACE=AriaL SIZE=6><b>Test Automation Report</b></h2>\n");
	     
	     
	     out.write("<table  border=1 cellspacing=1 cellpadding=1 >\n");
	     out.write("<tr>\n");
	   
	     		
	           out.write("<h4> <FONT COLOR=black FACE=Arial SIZE=4.5> <u>Test Details :</u></h4>\n");
	           out.write("<td width=150 align=left bgcolor=red><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>Run Date</b></td>\n");
	           out.write("<td width=150 align=left><FONT COLOR=black FACE=Arial SIZE=2.75><b>"+RUN_DATE+"</b></td>\n");
	     out.write("</tr>\n");
	     out.write("<tr>\n");
	           
	           out.write("<td width=150 align=left bgcolor=red><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75><b>Run StartTime</b></td>\n");

	           out.write("<td width=150 align=left><FONT COLOR=black FACE=Arial SIZE=2.75><b>"+testStartTime+"</b></td>\n");
	     out.write("</tr>\n");
	     out.write("<tr>\n");
	    // out.newLine();   
	           out.write("<td width=150 align= left  bgcolor=red><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>Run EndTime</b></td>\n");
	           out.write("<td width=150 align= left ><FONT COLOR=black FACE= Arial  SIZE=2.75><b>END_TIME</b></td>\n");
	     out.write("</tr>\n");
	     out.write("<tr>\n");
	   //  out.newLine();
	           
	           out.write("<td width=150 align= left  bgcolor=red><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>Environment</b></td>\n");
	           out.write("<td width=150 align= left ><FONT COLOR=black FACE= Arial  SIZE=2.75><b>"+ENVIRONMENT+"</b></td>\n");
	     out.write("</tr>\n");
	     out.write("<tr>\n");
	           
	           out.write("<td width=150 align= left  bgcolor=red><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>Release</b></td>\n");
	           out.write("<td width=150 align= left ><FONT COLOR=black FACE= Arial  SIZE=2.75><b>"+RELEASE+"</b></td>\n");
	     out.write("</tr>\n");

	     out.write("</table>\n");
	     

	    //Close the output stream
	    out.close();
	    }catch (Exception e){//Catch exception if any
	      System.err.println("Error: " + e.getMessage());
	    }finally{
	    	
		    fstream=null;
		    out=null;
	    }
	  }
	
    public static void startSuite(String suiteName){ // That method add the header of the table when suite execute

	    FileWriter fstream =null;
		BufferedWriter out =null;
		currentSuiteName = suiteName.replaceAll(" ", "_");
	
		tcid=1;
	    try{


	    fstream = new FileWriter(indexResultFilename,true);
	  	out = new BufferedWriter(fstream);
	      
    	out.write("<h4> <FONT COLOR=black FACE= Arial  SIZE=4.5> <u>"+suiteName+" Report :</u></h4>\n");
        out.write("<table  border=1 cellspacing=1 cellpadding=1 width=100%>\n");
    	out.write("<tr>\n");
        out.write("<td width=5%  align= center  bgcolor=red><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2><b>Test Script#</b></td>\n");

        out.write("<td width=20% align= center  bgcolor=red><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2><b>Test Case Name</b></td>\n");
        out.write("<td width=5% align= center  bgcolor=red><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2><b>Status</b></td>\n");
        out.write("<td width=35% align= center  bgcolor=red><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2><b>Description</b></td>\n");
        out.write("<td width=15% align= center  bgcolor=red><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2><b>Run Start Time</b></td>\n");
        out.write("<td width=15% align= center  bgcolor=red><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2><b>Run End Time</b></td>\n");
        out.write("<td width=5% align= center  bgcolor=red><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2><b>Screen Shot</b></td>\n");

        out.write("</tr>\n");
        out.close();
	    }catch(Exception e){
		      System.err.println("Error: " + e.getMessage());
	    }finally{
	    	
		    fstream=null;
		    out=null;
	    }
	}
    
    public static void endSuite(){
    	 FileWriter fstream =null;
 		BufferedWriter out =null;
 		
 	    try{
 	    fstream = new FileWriter(indexResultFilename,true);
 	    System.out.println(indexResultFilename);
 	  	out = new BufferedWriter(fstream);
        out.write("</table>\n");
        out.write("</body>\n");
        out.write("</html>\n");
        out.close();
 	    }catch(Exception e){
		      System.err.println("Error: " + e.getMessage());
	    }finally{
	    	
		    fstream=null;
		    out=null;
	    }

    }
	
	public static void addTestCase(String testCaseName,String testCaseStartTime,String testCaseEndTime,String status, String ScreenShotPath, String Description){
		newTest=true;
		FileWriter fstream=null;
		BufferedWriter out=null;
		
		
		try {
		   //<! add test case entry into main report////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		   
			 fstream = new FileWriter(indexResultFilename,true);
			 out = new BufferedWriter(fstream);
			// out.newLine();
			
			 out.write("<tr>\n");
			 //System.out.println(currentSuitePath);
		     out.write("<td width=5% align= center ><FONT COLOR=black FACE= Arial  SIZE=2><b>"+scriptNumber+"</b></td>\n");
		     if(status.equalsIgnoreCase("Skipped") || status.equalsIgnoreCase("Skip"))
		    	 out.write("<td width=20% align= center ><FONT COLOR=black FACE= Arial  SIZE=2><b>"+testCaseName+"</b></td>\n");
		     else
		    	// out.write("<td width=40% align= center ><FONT COLOR=black FACE= Arial  SIZE=2><b><a href=file:///"+currentDir+"//"+currentSuiteName+"_TC"+tcid+"_"+testCaseName.replaceAll(" ", "_")+DriverScript.year+"_"+DriverScript.date+"_"+(DriverScript.month+1)+"_"+DriverScript.day+"_"+DriverScript.min+"_" +DriverScript.sec+".html>"+testCaseName+"</a></b></td>\n");
		    	//out.write("<td width=40% align= center ><FONT COLOR=black FACE= Arial  SIZE=2><b><a href=http://"+TestUtil.Handeler()+":8080"+"//TestReports"+"//"+currentSuiteName+"_TC"+tcid+"_"+testCaseName.replaceAll(" ", "_")+PageFactory_TestCase.year+"_"+PageFactory_TestCase.date+"_"+(PageFactory_TestCase.month+1)+"_"+PageFactory_TestCase.day+"_"+PageFactory_TestCase.min+"_" +PageFactory_TestCase.sec+".html>"+testCaseName+"</a></b></td>\n");
		     	out.write("<td width=20% align= center ><FONT COLOR=black FACE= Arial  SIZE=2><b>"+testCaseName.replaceAll(" ", "_")+"</b></td>\n");
		    	 //out.write("<td width=40% align= center ><FONT COLOR=black FACE= Arial  SIZE=2><b><a href="+currentSuiteName+"_TC"+tcid+"_"+testCaseName.replaceAll(" ", "_")+".html>"+testCaseName+"</a></b></td>\n");
		     tcid++;
		     if(status.startsWith("Pass")){
		     out.write("<td width=5% align= center  bgcolor=#BCE954><FONT COLOR=black FACE=Arial SIZE=2><b>"+status+"</b></td>\n");
		     out.write("<td width=5% align= center  bgcolor=#BCE954><FONT COLOR=black FACE=Arial SIZE=2><b>"+Description+"</b></td>\n");
		     }
		     else if(status.startsWith("Fail")){
		    	 out.write("<td width=5% align= center  bgcolor=Red><FONT COLOR=black FACE= Arial  SIZE=2><b>"+status+"</b></td>\n");
		    	 out.write("<td width=5% align= center  bgcolor=yellow><FONT COLOR=black FACE= Arial  SIZE=2><b>"+Description+"</b></td>\n");
		     }
		     else if(status.equalsIgnoreCase("Skipped") || status.equalsIgnoreCase("Skip")){
			     out.write("<td width=5% align= center  bgcolor=yellow><FONT COLOR=153E7E FACE=Arial SIZE=2><b>"+status+"</b></td>\n");
			     out.write("<td width=5% align= center  bgcolor=yellow><FONT COLOR=153E7E FACE=Arial SIZE=2><b>"+Description+"</b></td>\n");
		     }
		     out.write("<td width=15% align= center ><FONT COLOR=black FACE= Arial  SIZE=2><b>"+testCaseStartTime+"</b></td>\n");
		     out.write("<td width=15% align= center ><FONT COLOR=black FACE= Arial  SIZE=2><b>"+testCaseEndTime+"</b></td>\n");
 			 out.write("<td align=center width=5%><FONT COLOR=black FACE=Arial SIZE=1><b><a href=http://"+TestUtil.Handeler()+":8080/screenshots/"+ScreenShotPath+".jpeg"+" target=_blank>Screen Shot</a></b></td>");
 			 //out.write("<td align=center width=10%><FONT COLOR=black FACE=Arial SIZE=1><b><a href=http://"+TestUtil.Handeler()+":8080/screenshots/"+ScreenShotPath+".jpeg"+" target=_blank>"+"C:/Selenium_3rd_Tools/apache-tomcat-9.0.0.M13/webapps/ROOT/screenshots/"+ScreenShotPath+".jpeg"+"</a></b></td>");

		     out.write("</tr>\n");
		     
		     scriptNumber++;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		newTest=false;
		Description = null;
	}
	
	
    
    

	public static void updateEndTime(String endTime) {
		StringBuffer buf = new StringBuffer();
		try{
		    // Open the file that is the first 
		    // command line parameter
		    FileInputStream fstream = new FileInputStream(indexResultFilename);
		    // Get the object of DataInputStream
		    DataInputStream in = new DataInputStream(fstream);
		        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		    
		    
		    
		    //Read File Line By Line
		    
		    while ((strLine = br.readLine()) != null)   {
		    	
		    
		    	
		     if(strLine.indexOf("END_TIME") !=-1){
		    	 strLine=strLine.replace("END_TIME", endTime);
		     }
		     buf.append(strLine);
		     
		     
		    }
		  //Close the input stream
		    in.close();
		    //System.out.println(buf);
		    FileOutputStream fos=new FileOutputStream(indexResultFilename);
			 DataOutputStream   output = new DataOutputStream (fos);	 
	    	 output.writeBytes(buf.toString());
	    	 fos.close();
		    
		    }catch (Exception e){//Catch exception if any
		      System.err.println("Error: " + e.getMessage());
		    }
	
		
		
		
		
		
		
		
	}
	
}
