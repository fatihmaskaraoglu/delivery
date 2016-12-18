package algorithmes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAOs.AddressDAO;
import DAOs.CostDAO;
import dataModels.Address;

public class algorithme2 {
	private static float[][] data_arrays;

	public static float[][] Algorithme2 (Address x,int AdressId) throws SQLException{
		 data_arrays = null;
		 AddressDAO a = new AddressDAO();
		 CostDAO c = new CostDAO();	
		 int b=0;	 
		 List<Address> list=new ArrayList<>();
		 double distance=0;  			// distance address initial a address finale
		 double distancevoisin=0; 			// distance voisin a address finale
		 Address init= x; 					//address initial
		 Address finale=a.findById(AdressId);					 //address finale
		 double distancetemp;
		 distance = functions.DistanceEntreDeuxAddress(init,finale);
		 Address court=null;

		if(distance!=0){
			list = c.findNeighbors(init);
			double min=9999999999999999.99;
			int j=0;
			int i= list.size();		
			for(;i>0;i--){
				Address temp = list.get(j);
				distancetemp=functions.DistanceEntreDeuxAddress(temp,finale);
				distancevoisin=functions.DistanceEntreDeuxAddress(temp,init);
				if(distancetemp<distance){
					if(distancevoisin<min){
						min=distancevoisin;
						court = list.get(j);
						}
					}
					j++;
				}
			if(court==finale){
				distance=0;
			}
			else{
				data_arrays[b][0]=init.x;
				data_arrays[b][1]=init.y;
				data_arrays[b][2]=court.x;
				data_arrays[b][3]=court.y;
				b++;
			}
			Algorithme2(court,finale.getId());
		}
		else{
			
		}
		return data_arrays;	 	 
	} 
}
