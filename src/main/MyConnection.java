package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	public static Connection getConnection() {
		Connection con=null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll", "root", "root");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
