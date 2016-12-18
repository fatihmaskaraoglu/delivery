package DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataModels.Address;
import dataModels.Cost;

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
			
			  PreparedStatement stmt=conn.prepareStatement("SELECT AddressId1 FROM Address_Neighbors WHERE AddressId2=? OR AddressId1=? ");
			  stmt.setInt(1, ad.getId());
			  stmt.setInt(1, ad.getId());
			  ResultSet rs=stmt.executeQuery();
			
			  if(rs.next()){
				  Address s=new Address(rs.getInt("AddressId"), rs.getInt("StreetId"), rs.getFloat("x"),rs.getFloat("y"));
				  list.add(s);
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
		  	float x = ad1.x - ad2.x;
		  	float y = ad1.y - ad2.y;
		  	
		  	dist = (float) Math.sqrt(x*x +y*y);
		      PreparedStatement stmt=conn.prepareStatement("INSERT INTO Cost (Distance,AddressId1,AddressId2) VALUES ( ?, ?, ?)");
		      stmt.setFloat(1, dist);
		      stmt.setInt(2, ad1.getId());
		      stmt.setInt(3, ad2.getId());
		      
		      boolean res=stmt.execute();
			  return res;		  
	  } 	
}
