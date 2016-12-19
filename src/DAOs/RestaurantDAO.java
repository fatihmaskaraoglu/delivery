package DAOs;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import dataModels.Address;
import dataModels.Restaurant;

import java.util.ArrayList;
import java.util.List;


public class RestaurantDAO extends DAO {
	public RestaurantDAO(){
		super();
	}
	
	public boolean insertRestaurant(Restaurant s) throws SQLException{
		 if(!this.isConnected){
			  return false;
		  }
		      PreparedStatement stmt=conn.prepareStatement("INSERT INTO Restaurant(ListOfOrders,AddressId,NumberOfAvailableDelivryName) VALUES (?,?,?)");
		      stmt.setString(1,s.getListOfOrders());
		      stmt.setInt(2,s.getAddressId());
		      stmt.setInt(3, s.getNumberOfAvailableDelvryName());
		      boolean res = stmt.execute();
			  return true;		  
	  }
	
	public Restaurant findById(int id) throws SQLException{
		  if(this.isConnected)
		  {
			  PreparedStatement stmt=conn.prepareStatement("SELECT RestaurantId,ListOfOrders,AddressId FROM Restaurant WHERE RestaurantId=?");
			  stmt.setInt(1, id);
			  ResultSet rs=stmt.executeQuery();
			
			  if(rs.next()){
				  Restaurant r = new Restaurant(rs.getInt("RestaurantId"), rs.getString("ListOfOrders"), rs.getInt("AddressId"),3);

				  return r;
			  }
			  
			  return null;		 
		  }
		  return null;
		 
	  }

}
