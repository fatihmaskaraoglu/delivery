package dataModels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import DAOs.StreetDAO;

public class TestMain {

	public static void main(String[] args) {
		String Server="DESKTOP-E8VNLQ9";
		int port=1433;
		String user="pizza";
		String password="admin";// Server, user, password will be chanced
		String database="LivraisondePizza";
		String jdbcurl;
		Connection con  = null;
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("-> driver loaded");
			
			
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		jdbcurl = "jdbc:sqlserver://" + Server + ":" + port + ";user=" + user
				+ ";password=" + password + ";databaseName=" + database + "";
		try {
			System.out.println("-> connecting");
			con = DriverManager.getConnection(jdbcurl);
			 System.out.println("Database connected!");
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		try 
		{
			
			//PreparedStatement pst = con.prepareStatement("Select * From Address As A INNER JOIN Street AS S ON S.StreetId = A.StreetId");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * From Address");
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
