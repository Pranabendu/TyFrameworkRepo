package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class DataBaseScenarioTask {
	Connection conn;
	
	@Test
	void createTable() {
		
		String quary = "create table TYSS (id int,name varchar(300));";
		
		try {
			Driver dr = new Driver();
			DriverManager.registerDriver(dr);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tydatabase","root","root");
			conn.createStatement().executeQuery(quary);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				
			}
		}
		
	}
	@Test
	void verify() {
		try {
			Driver dr = new Driver();
			DriverManager.registerDriver(dr);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/automationjdbc","root","root");
			Scanner sc = new Scanner(System.in);
			System.out.println("Type the value which you want to varify");
			String input = sc.next();
			String quary = "select name from TYSS where lower(name)="+input+"";
			
			ResultSet res = conn.createStatement().executeQuery(quary);
			int a = 0;
			if(res.getString(0).equalsIgnoreCase(input))
			{
					System.out.println("Yes Data is present");
			}else {
				String quary2 = "INSERT INTO TYSS VALUES (1, '"+input+"');";
				int y = conn.createStatement().executeUpdate(quary2);
				if (y==1) {
					a++;
				}
			}
			if (a>0) {
				System.out.println("data has been created");
			}else {
				System.out.println("data has not been created");
			}
			
			System.out.println("The values are......");
			
			ResultSet res2=conn.createStatement().executeQuery("select * from TYSS where lower(name)='"+input+"'");
			System.out.println(res2.getString(0));
			
		}catch(Exception e) {
			
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
}