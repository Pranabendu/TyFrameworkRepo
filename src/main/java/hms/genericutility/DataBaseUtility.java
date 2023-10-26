package hms.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	Connection conn;
	Driver dr;
	ResultSet res;
	
	FileUtility fu = new FileUtility();
	String url = "";
	String username = "";
	String password = "";
	
	public DataBaseUtility() {
		try {
			url = fu.fetchDataFromProperty("dburl");
			username = fu.fetchDataFromProperty("dbun");
			password = fu.fetchDataFromProperty("dbpass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	public void connectDB() throws SQLException {
		try { 
		dr = new Driver();
		DriverManager.registerDriver(dr);
		conn = DriverManager.getConnection(url,username,password);
		}catch (Exception e) {
			e.getMessage();
		}
	}
	public ResultSet executeQuery(String query) throws SQLException {
		res = conn.createStatement().executeQuery(query);
		return res;		
	}
	public int executeUpdate(String query) throws Throwable {
		
		int result = conn.createStatement().executeUpdate(query);
		return result;
	}
	public void closeDB() throws SQLException {
		try {
		  conn.close();
		}catch (Exception e) {
			e.getMessage();
		}
	}
	public boolean executeQuerryAndVerify(String querry,int cloumnIndex,String expectedData) throws Throwable {
		boolean flag=false;
		res=conn.createStatement().executeQuery(querry);
		while(res.next()) {
			if(res.getString(cloumnIndex).equals(expectedData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expectedData+"==>Data is verified in the data base table");
			return flag;
		}else {
			System.out.println(expectedData+"==>data is not verified in the database");
			return flag;
		}
         
	}
}