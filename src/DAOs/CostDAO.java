package DAOs;

import java.awt.Point;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataModels.Address;
import dataModels.Cost;
import Util.Util;

public class CostDAO extends DAO{

	public CostDAO(){
		super();
	}
	
	  public List<Cost> findAll() throws SQLException{
		  if(!this.isConnected){
			  return null;
		  }
		      List<Cost> list=new ArrayList<>();
			  PreparedStatement stmt=conn.prepareStatement("SELECT CostId,Distance,AddressId1,AddressId2 FROM Cost");
			  ResultSet rs=stmt.executeQuery();
			
			  while(rs.next()){
				  Cost c=new Cost(rs.getInt("CostId"), rs.getFloat("Distance"),rs.getInt("AddressId1"),rs.getInt("AddressId2"));
				  list.add(c);
			  }
			  
			  return list;		  
	  }
	  
	  public List<Address> findNeighbors(Address ad) throws SQLException{
		  List<Address> list = new ArrayList<>(); 
		  if (this.isConnected){
			

			  PreparedStatement stmt=conn.prepareStatement("SELECT Address.AddressId, Address.StreetId, Address.x, Address.y, "
			                                            +  "ad1.AddressId, ad1.StreetId, ad1.x, ad1.y "   
			  											+  "FROM Cost INNER JOIN Address AS ad1 ON ad1.AddressId = Cost.AddressId2 "
			  											+  "INNER JOIN Address ON Address.AddressId = Cost.AddressId1 " 
			  											+  " WHERE Cost.AddressId2=? OR Cost.AddressId1=?");
			  

			  stmt.setInt(1, ad.getId());
			  stmt.setInt(2, ad.getId());
			  ResultSet rs=stmt.executeQuery();
			
			  while(rs.next()){
				  Address s = null;
				  if (rs.getInt("ad1.AddressId") == ad.getId()) {
					   s=new Address(rs.getInt("Address.AddressId"), rs.getInt("Address.StreetId"), rs.getFloat("Address.x"),rs.getFloat("Address.y"));
				  } else if (rs.getInt("Address.AddressId") == ad.getId()) {
					   s=new Address(rs.getInt("ad1.AddressId"), rs.getInt("ad1.StreetId"), rs.getFloat("ad1.x"),rs.getFloat("ad1.y"));
			  	  }
			  	  if (s != null) {		  	
			  		  list.add(s);
			  	  }
			  }
			  
			  
			  return list;
		  }else {
			  return null;
		  }
		  
		  
		  
		  
	  }
	 
	public boolean insertCost(Address ad1, Address ad2) throws SQLException{
		  if(!this.isConnected){
			  return false;
		  }
		  	float dist = 0;
	  		float x;
	  		float y;
	  		System.out.println(ad1.getStreetId() + " and " + ad2.getStreetId());
		  	if (ad1.getStreetId() == ad2.getStreetId()) {
		  		 dist = 0;
		  		 x = ad1.x - ad2.x;
		  		 y = ad1.y - ad2.y;
		  		dist = (float) Math.sqrt(x*x +y*y);
		  	} else {
		  		dist = 0;
		  		Point p = Util.intersection(ad1, ad2);
		  		x = ad1.x - p.x;
		  		y = ad1.y - p.y;
		  		dist = (float) Math.sqrt(x*x +y*y);
		  		x = ad2.x - p.x;
		  		y = ad2.y - p.y;
		  		dist = dist + (float) Math.sqrt(x*x +y*y);
		  				  		
		  	}
		  	
		  	
		      PreparedStatement stmt=conn.prepareStatement("INSERT INTO Cost (Distance,AddressId1,AddressId2) VALUES ( ?, ?, ?)");
		      stmt.setFloat(1, dist);
		      stmt.setInt(2, ad1.getId());
		      stmt.setInt(3, ad2.getId());
		      
		      boolean res=stmt.execute();
			  return res;		  
	  } 	
}
