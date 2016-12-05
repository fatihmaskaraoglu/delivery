package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataModels.Address;
import dataModels.Street;

public class StreetDAO {
//  Database credentials
	  	String Server="DESKTOP-E8VNLQ9";
		int port=1433;
		String user="pizza";
		String password="admin";// Server, user, password will be chanced
		String database="LivraisondePizza";
		String jdbcurl;
		Connection conn  = null;
		boolean isConnected=false;
	  
	
	 
	 
	  
	
	  public StreetDAO() {
		// TODO Auto-generated constructor stub
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
				conn = DriverManager.getConnection(jdbcurl);
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
	
	  public List<Street> findAll() throws SQLException{
		  if(!this.isConnected){
			  return null;
		  }
		      List<Street> list=new ArrayList<>();
			  PreparedStatement stmt=conn.prepareStatement("SELECT StreetId,StreetName,x1,y1,x2,y2 FROM Street");
			  ResultSet rs=stmt.executeQuery();
			
			  while(rs.next()){
				  Street s=new Street(rs.getInt("StreetId"), rs.getString("StreetName"),rs.getFloat("x1"),rs.getLong("y1"),rs.getFloat("x2"),rs.getLong("y2"));
				  list.add(s);
			  }
			  
			  return list;		  
	  }
	  
	  public Street findById(int id) throws SQLException{
		  if(this.isConnected)
		  {
			  PreparedStatement stmt=conn.prepareStatement("SELECT StreetId,StreetName,x1,y1,x2,y2 FROM Street WHERE StreetId=?");
			  stmt.setInt(1, id);
			  ResultSet rs=stmt.executeQuery();
			
			  if(rs.next()){
				  Street s=new Street(rs.getInt("StreetId"), rs.getString("StreetName"),rs.getFloat("x1"),rs.getLong("y1"),rs.getFloat("x2"),rs.getLong("y2"));

				  return s;
			  }
			  
			  return null;		 
		  }
		  return null;
		 
	  }
	  	  
	 
	    
	  public boolean insertStreet(Street s) throws SQLException{
		  if(!this.isConnected){
			  return false;
		  }
		      PreparedStatement stmt=conn.prepareStatement("INSERT INTO Street (id, streetName,  x1, y1, x2, y2) VALUES (?, ? , ?, ?, ?, ?)");
		      stmt.setInt(1, s.getId());
		      stmt.setString(2, s.getStreetName());
		      stmt.setFloat(3, s.getX1());
		      stmt.setFloat(4, s.getY1());
		      stmt.setFloat(5, s.getX2());
		      stmt.setFloat(6, s.getY2());
		      boolean res=stmt.execute();
			  return true;		  
	  }
		  
	  public boolean updateStreet(Street oldStreet, Street newStreet) throws SQLException{
		  if(!this.isConnected){
			  return false;
		  }
		      PreparedStatement stmt=conn.prepareStatement("UPDATE Street SET id=?, streetName= ?, x1=?, y1=?, x2=?, y2=? WHERE Street.id = ?");
		      stmt.setInt(1,newStreet.getId());
		      stmt.setString(2,newStreet.getStreetName());
		      stmt.setFloat(3,newStreet.getX1());
		      stmt.setFloat(4,newStreet.getY1());
		      stmt.setFloat(5,newStreet.getX2());
		      stmt.setFloat(6,newStreet.getY2());
		      stmt.setInt(7, oldStreet.getId());
		      
		      boolean res=stmt.execute();
			  return true;		  
	  }
		 
	  public boolean deleteStreet(Street s) throws SQLException{
		  if(!this.isConnected){
			  return false;
		  }
		      PreparedStatement stmt=conn.prepareStatement("DELETE FROM Street WHERE Street.id = ?");
		      stmt.setInt(1,s.getId());
		      boolean res=stmt.execute();
			  return true;		  
	  }

	

}
