package DAOs;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

 
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
		      PreparedStatement stmt=conn.prepareStatement("INSERT INTO Restaurant(ListOfOrders,AddressId,NumberOfAvailableDelvryName) VALUES (?,?,?)");
		      stmt.setString(1,s.getListOfOrders());
		      stmt.setInt(2,s.getAddressId());
		      stmt.setInt(3, s.getNumberOfAvailableDelvryName());
		      boolean res = stmt.execute();
			  return true;		  
	  }

}
