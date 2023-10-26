package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class Jdbc_FetchData {

//	public static void main(String[] args) throws SQLException {
//		Connection conn = null;
//		ResultSet rset;
//		try {
//			Driver d1 =new Driver();
//			DriverManager.registerDriver(d1);
//			conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
//			Statement stat = conn.createStatement();
//			String quary = "select * from project";
//			ResultSet res = stat.executeQuery(quary);
//			while(res.next()){
//				String val = res.getString(1)+" "+res.getString(2)+" "+res.getString(3);
//				System.out.println(val);
//			}
//		} finally {
//			conn.close();
//		}
//		Driver dr = new Driver();
//		DriverManager.registerDriver(dr);
//		conn = DriverManager.getConnection("\"jdbc:mysql://rmgtestingserver:3333/projects\",\"root@%\",\"root\"");
//		rset = conn.createStatement().executeQuery("Select * from emp;");	
//		while (rset.next()) {
//			String value = rset.getString(1);
//		}
	Connection con;
	ResultSet res;
	 void connect() 
	 {
		 try {
			Driver dr = new Driver();
			DriverManager.registerDriver(dr);
			con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	 }
		
	String executeQuary() {
		String data = "";
		try {
			res = con.createStatement().executeQuery("Select * from emp;");
			while(res.next()) {
				data=res.getString(2);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return data;
		 
	 }
	int updateData() {
		int result = 0;
		try {
			result = con.createStatement().executeUpdate("input values('12','bor')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	// done

}