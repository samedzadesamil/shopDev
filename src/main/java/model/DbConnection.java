package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static String name="postgres";
	private static String password="12345";
	private static String url="jdbc:postgresql://localhost:5432/DbShopping";
	private static Connection conn=null;
	
	public static Connection connectDb() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection(url, name, password);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return conn;
	}
}
