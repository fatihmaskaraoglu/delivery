package DAOs;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


import dataModels.Address;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AddressDAO {
	  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	  static final String DB_URL = "jdbc:sqlserver://DESKTOP-E8VNLQ9";

	   //  Database credentials
	  static final String USER = "pizza";
	  static final String PASS = "admin";
	  boolean isConnected=false;
	  private static Connection conn=null;

	
	  public AddressDAO() {
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
	  
	  public void connect(){
		   try{
	 		      System.out.println("Connecting to database...");
			      conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);	   
			      isConnected=true;
			   } catch (Exception e) 
			   {
				System.out.println("Connection is lost");  		   
			   }
	  }
	
	  public List<Address> findAll() throws SQLException{
		  if(!this.isConnected){
			  return null;
		  }
		      List<Address> list=new ArrayList<>();
			  PreparedStatement stmt=conn.prepareStatement("SELECT AddressId,StreetId,x,y FROM Address ");
			  ResultSet rs=stmt.executeQuery();
			
			  while(rs.next()){
				  Address s=new Address(rs.getInt("AddressId"), rs.getInt("StreetId"),rs.getFloat("x"),rs.getLong("y"));
				  list.add(s);
			  }
			  
			  return list;		  
	  }
	  
	  public Address findById(int id) throws SQLException{
		  if(this.isConnected)
		  {
			  PreparedStatement stmt=conn.prepareStatement("SELECT AddressId,StreetId,x,y FROM Address WHERE AddressId=?");
			  stmt.setInt(1, id);
			  ResultSet rs=stmt.executeQuery();
			
			  if(rs.next()){
				  Address s=new Address(rs.getInt("AddressId"), rs.getInt("StreetId"), rs.getFloat("x"),rs.getLong("y"));

				  return s;
			  }
			  
			  return null;		 
		  }
		  return null;
		 
	  }
	  	  
	 
	    
	  public boolean insertAddress(Address s) throws SQLException{
		  if(!this.isConnected){
			  return false;
		  }
		      PreparedStatement stmt=conn.prepareStatement("INSERT INTO Address (id, streetId,  x, y) VALUES (?, ? , ?, ?)");
		      stmt.setInt(1, s.getId());
		      stmt.setInt(2, s.getStreetId());
		      stmt.setFloat(3, s.getX());
		      stmt.setFloat(4, s.getY());
		      boolean res=stmt.execute();
			  return true;		  
	  }
		  
	  public boolean updateAddress(Address oldAddress, Address newAddress) throws SQLException{
		  if(!this.isConnected){
			  return false;
		  }
		      PreparedStatement stmt=conn.prepareStatement("UPDATE Address SET id=?, streetId= ?, x=?, y=? WHERE Address.id = ?");
		      stmt.setInt(1,newAddress.getId());
		      stmt.setInt(2,newAddress.getStreetId());
		      stmt.setFloat(3,newAddress.getX());
		      stmt.setFloat(4,newAddress.getY());
		      stmt.setInt(5, oldAddress.getId());
		      
		      boolean res=stmt.execute();
			  return true;		  
	  }
		 
	  public boolean deleteAddress(Address s) throws SQLException{
		  if(!this.isConnected){
			  return false;
		  }
		      PreparedStatement stmt=conn.prepareStatement("DELETE FROM Address WHERE Address.id = ?");
		      stmt.setInt(1,s.getId());
		      boolean res=stmt.execute();
			  return true;		  
	  }
}
