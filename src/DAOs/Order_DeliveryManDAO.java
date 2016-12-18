package DAOs;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import dataModels.DeliveryMan;
import dataModels.Order;
import dataModels.Order_DeliveryMan;

import java.util.ArrayList;
import java.util.List;

public class Order_DeliveryManDAO extends DAO {
	public Order_DeliveryManDAO(){
		super();
	}

	public boolean insertOrder_DeliveryMan(Order o, DeliveryMan dm) throws SQLException{
		 if(!this.isConnected){
			  return false;
		  }
		      PreparedStatement stmt=conn.prepareStatement("INSERT INTO Order_DeliveryMan(OrderId, DeliveryManId) VALUES (?,?)");
		      stmt.setInt(1, o.getId());
		      stmt.setInt(2, dm.getId());
		      boolean res = stmt.execute();
			  return true;		  
	  }
		  
	  
	  
	
}
