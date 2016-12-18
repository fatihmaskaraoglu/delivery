package algorithmes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAOs.AddressDAO;
import DAOs.CostDAO;
import dataModels.Address;

public class algorithme3 {
	private static float[][] data_arrays;

	public static float[][] Algorithme3 (Address x,Address y) throws SQLException{
		 data_arrays = null;
		 CostDAO c = new CostDAO();	
		 int b=0;	 
		 List<Address> list=new ArrayList<>();
		 float distance=0;  			// distance address initial a address finale
		 float distancevoisin=0; 			// distance voisin a address finale
		 Address init= x; 					//address initial
		 Address finale=y;					 //address finale
		 float distancetemp;
		 distance = functions.DistanceEntreDeuxAddress(init,finale);
		 Address court=null;
		 float distancetotal=0;
		if(distance!=0){
			list = c.findNeighbors(init);
			float min=999999999;
			int j=0;
			int i= list.size();		
			for(;i>0;i--){
				Address temp = list.get(j);
				distancetemp=functions.DistanceEntreDeuxAddress(temp,finale);
				distancevoisin=functions.DistanceEntreDeuxAddress(temp,init);
				distancetotal=distancetemp+distancevoisin;
					if(distancetotal<min){
						min=distancetotal;
						court = list.get(j);
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
					Algorithme3(court,finale);
				}
		else{
			
		}
		return data_arrays;	 	 
	} 

}
