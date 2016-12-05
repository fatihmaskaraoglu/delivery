package dataModels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMain {

	public static void main(String[] args) {
		String Server="Server Name";
		int port=1433;
		String user="username";
		String password="password";// Server, user, password will be chanced
		String database="LivraisondePizza";
		String jdbcurl;
		Connection con = null;
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		jdbcurl = "jdbc:sqlserver://" + Server + ":" + port + ";user=" + user
				+ ";password=" + password + ";databasename=" + database + "";
		try {
			con = DriverManager.getConnection(jdbcurl);
			 System.out.println("Database connected!");
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		try 
		{
			PreparedStatement pst = con.prepareStatement("Select * From Address As A INNER JOIN Street AS S ON S.StreetId = A.StreetId");
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				System.out.println("Id="+ rs.getInt("addressId")+" StreetId=" + rs.getInt("streetId")+" x=" + rs.getInt("x")+" y="+ rs.getInt("y"));
				
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
//		String url = "jdbc:odbc:LivraisondePizza;integratedSecurity=true";
//		String username = "admin";
//		String password = "admin";
//
//		System.out.println("Connecting database...");
//
//		try (Connection connection = (Connection) DriverManager.getConnection(url, username, password)) {
//		    System.out.println("Database connected!");
//		} catch (SQLException e) {
//		    throw new IllegalStateException("Cannot connect the database!", e);
//		}
	}

}
