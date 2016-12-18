package DAOs;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

 
import dataModels.Order;

import java.util.ArrayList;
import java.util.List;


public class OrderDAO extends DAO {
	 public OrderDAO() {
			super();
		}


	public List<Order> findAll() throws SQLException{
		if(!this.isConnected){
			return null;
		}
		
		List<Order> list = new ArrayList<>();
		PreparedStatement stmt=conn.prepareStatement("SELECT AddressId,OrderId FROM Order");
		ResultSet rs=stmt.executeQuery();
		

		  while(rs.next()){
			  Order s=new Order(rs.getInt("AddressId"), rs.getInt("OrderId"));
			  list.add(s);
		  }
		  
		  return list;		
	}
	 
	public boolean insertOrder(Order s) throws SQLException{
		 if(!this.isConnected){
			  return false;
		  }
		      PreparedStatement stmt=conn.prepareStatement("INSERT INTO Order(AddressId) VALUES (?)");
		      stmt.setInt(1,s.getAddressId());
		      boolean res = stmt.execute();
			  return true;		  
	  }
		  
	  
	  
}
	
	
	   
	  