package algorithmes;

import java.util.ArrayList;
import java.util.List;
import gui.gui1;
import DAOs.AddressDAO;
import dataModels.Address;

public class algorithme2 {
	public static float[][] Algorithme2 (Address x,Address y){
		 float[][] data_array = null;
		 int b=0;
		 AddressDAO a = new AddressDAO();	 
		 List<Address> list=new ArrayList<>();
		 double distance=0;  			// distance address initial a address finale
		 double distancevoisin=0; 			// distance voisin a address finale
		 Address init= x; 					//address initial
		 Address finale=y;					 //address finale
		 double distancetemp;
		 distance = gui1.DistanceEntreDeuxAddress(init,finale);
		 Address court=null;

		if(distance!=0){
			list = a.findVoisinById(init.getId());
			double min=9999999999999999.99;
			int j=0;
			int i= list.size();		
			for(;i>0;i--){
				Address temp = list.get(j);
				distancetemp=gui1.DistanceEntreDeuxAddress(temp,finale);
				distancevoisin=gui1.DistanceEntreDeuxAddress(temp,init);
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
				data_array[b][0]=init.x;
				data_array[b][1]=init.y;
				data_array[b][2]=court.x;
				data_array[b][3]=court.y;
				b++;
			}
			Algorithme2(court,finale);
		}
		else{
			return data_array;
		}	
		 	 
	} 
}
