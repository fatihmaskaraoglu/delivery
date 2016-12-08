package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO {
	
//  Database credentials
	
		
		// for mssql
	  	//String Server ="jdbc:sqlserver://DESKTOP-E8VNLQ9";
	    //final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//for Mysql
	  	final String Server = "jdbc:mysql://localhost:3306/LivraisondePizza";
	  	final String driver = "com.mysql.jdbc.Driver";
	  	
		int port=1433;
		final String user="pizza";
		final String password="admin";// Server, user, password will be chanced
		final String database="LivraisondePizza";
		final String jdbcurl;
		protected Connection conn  = null;
		protected boolean isConnected=false;
	  
	
	  public DAO() {
		// TODO Auto-generated constructor stub
		  try 
			{
			  
			  Class.forName(driver);
				System.out.println("-> driver loaded");
				
				
			}catch (ClassNotFoundException e){
				e.printStackTrace();
			}
		  jdbcurl =  Server + ":" + port + ";user=" + user
					+ ";password=" + password + ";databaseName=" + database + "";
		  try {
				System.out.println("-> connecting");
				//for mssql
				//conn = DriverManager.getConnection(jdbcurl);
				//for mysql
				 conn = DriverManager.getConnection(Server, user, password);
				 System.out.println("Database connected!");
				 isConnected=true;
			}catch (SQLException e){
				 System.out.println("Database connection lost!");
				e.printStackTrace();
			}
	}
	  
	  public void connect(){
		   try{
	 		      System.out.println("Connecting to database...");
			      conn = (Connection) DriverManager.getConnection(jdbcurl);	   
			      isConnected=true;
			   } catch (Exception e) 
			   {
				System.out.println("Connection is lost");  		   
			   }
	  }

}
