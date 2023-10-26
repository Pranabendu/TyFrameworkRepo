package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Jdbc_updateStatement {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		
		try {
			Driver d1 =new Driver();
			DriverManager.registerDriver(d1);
			conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement stat = conn.createStatement();
			String quary = "insert into project values('TY_Project_105','30/06/2023','HMS','Done','Roy','2')";
			                                   //       project id        date   project  current  manager team
			                                   //                                    Name   progress       member
			int res = stat.executeUpdate(quary);
			if(res==1){
				System.out.println("data has been updated");
			}else {
				System.out.println("data has not been updated");
			}
		} finally {
			conn.close();
		}
		
//		String s2 = "hms";
//		Driver d1 = new Driver();
//		DriverManager.registerDriver(d1);
//		Connection conn = DriverManager.getConnection("url","un","pass");
//		Statement stat = conn.createStatement();
//		String quary = "select * from project";
//		ResultSet res = stat.executeQuery(quary);
//		boolean flag = true;
//		while(res.next()) {
//			String s1 = res.getString(1);
//			if (s1.equalsIgnoreCase(s2)) {
//				System.out.println("project is created");
//				flag = false;
//			}
//		}
//		if (!flag) {
//			
//		} 
	}

}