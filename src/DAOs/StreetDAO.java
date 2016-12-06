package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dataModels.Street;

public class StreetDAO {
	
	  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	  //static final String DB_URL = "jdbc:sqlserver://DESKTOP-E8VNLQ9";
	  static final String DB_URL = "jdbc:mysql://localhost:3306/delivery";

	   //  Database credentials
	  //static final String USER = "pizza";
	  static final String USER = "delivery";
	  //static final String PASS = "admin";
	  static final String PASS = "delivery";
	  boolean isConnected=false;
	  private static Connection conn=null;
	
	  public StreetDAO() {
		// TODO Auto-generated constructor stub
		   try{
		      System.out.println("Connecting to database...");
		      conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);	   
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
				  PreparedStatement stmt=conn.prepareStatement("SELECT IdStreet,StreetName,x1,y1,x2,y2 FROM Street ");
				  ResultSet rs=stmt.executeQuery();
				
				  while(rs.next()){
					  Street s=new Street(rs.getInt("IdStreet"), rs.getString("StreetName"), rs.getFloat("x1"),rs.getLong("y1"), rs.getFloat("x2"),rs.getLong("y2"));
					  list.add(s);
				  }
				  
				  return list;		  
		  }
		  
		  public Street findById(int id) throws SQLException{
			  if(this.isConnected)
			  {
				  PreparedStatement stmt=conn.prepareStatement("SELECT StreetId,StreetName,x1,y1,x2,y2 FROM Street WHERE id=?");
				  stmt.setInt(1, id);
				  ResultSet rs=stmt.executeQuery();
				
				  if(rs.next()){
					  Street s=new Street(rs.getInt("StreetId"), rs.getString("StreetName"), rs.getFloat("x1"),rs.getLong("y1"), rs.getFloat("x2"),rs.getLong("y2"));

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
			      PreparedStatement stmt=conn.prepareStatement("INSERT INTO Street (StreetName,x1,y1,x2,y2) VALUES (? , ? , ?, ?, ?)");
			      //stmt.setInt(1, s.getId());
			      stmt.setString(1, s.getStreetName());
			      stmt.setFloat(2, s.getX1());
			      stmt.setFloat(3, s.getY1());
			      stmt.setFloat(4, s.getX2());
			      stmt.setFloat(5, s.getY2());
			      boolean res=stmt.execute();
				  return true;		  
		  }
			  
		  public boolean updateStreet(Street oldStreet, Street newStreet) throws SQLException{
			  if(!this.isConnected){
				  return false;
			  }
			      PreparedStatement stmt=conn.prepareStatement("UPDATE Street SET StreetId=?, streetName=?, x1=?, y1=?, x2=?, y2=? WHERE Street.id = ?");
			      stmt.setInt(1,newStreet.getId());
			      stmt.setString(2,newStreet.getStreetName());
			      stmt.setFloat(3,newStreet.getX1());
			      stmt.setFloat(4,newStreet.getY1());
			      stmt.setFloat(5,newStreet.getX2());
			      stmt.setFloat(6,newStreet.getY2());
			      stmt.setFloat(7,oldStreet.getId());
			      
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
