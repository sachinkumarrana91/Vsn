package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DBUtills{
	private final static String dcn = "oracle.jdbc.driver.OracleDriver";
	private static Connection con;
	
	@Test
	@Parameters({"ip","port","dbName","un","pw"})
	public static void refreshQueue(String ip,String port,String dbName,String un,String pw) throws Exception{
		String dbUrl = "jdbc:oracle:thin:@//"+ip+":"+port+"/"+dbName;		
		try{
			con = DriverManager.getConnection(dbUrl,un,pw);			
			System.out.println("Connection Created");
			CallableStatement stmt = con.prepareCall("BEGIN willow2k.process_stage_maint.refresh_stages(); END;");
			System.out.println("Start Execution");
			stmt.execute();
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
	
	
}
