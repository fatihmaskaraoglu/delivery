package DAOs;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

 
import dataModels.DeliveryMan;
import dataModels.Order;

import java.util.ArrayList;
import java.util.List;
public class DeliveryManDAO extends DAO{
	public DeliveryManDAO(){
		super();
	}

	public boolean insertDeliveryMan(DeliveryMan dm) throws SQLException{
		 if(!this.isConnected){
			  return false;
		  }
		      PreparedStatement stmt=conn.prepareStatement("INSERT INTO Order(Available) VALUES (?)");
		      stmt.setInt(1,dm.getAvailable());
		      boolean res = stmt.execute();
			  return true;		  
	  }
		  
	  
	  
}
