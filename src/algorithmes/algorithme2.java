package algorithmes;

import java.awt.Point;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAOs.AddressDAO;
import DAOs.CostDAO;
import Util.Util;
import dataModels.Address;

public class algorithme2 {
	private static float[][] data_arrays;
	int b;
	AddressDAO a;
	CostDAO c;
	
	public algorithme2() {
	// chemin =new ArrayList<>();	
	 data_arrays = new float[1000][7];
	 b = 0;
	 a = new AddressDAO();
	 c = new CostDAO();
	}
	
	
	public float[][] Algorithme2 (Address x,int AdressId) throws SQLException{
		 //data_arrays = null;
		// AddressDAO a = new AddressDAO();
		 //CostDAO c = new CostDAO();	
		 //int b=0;	 
		 List<Address> list=new ArrayList<>();
		 double distance=0;  			// distance address initial a address finale
		 double distancevoisin=0; 			// distance voisin a address finale
		 Address init= x; 					//address initial
		 Address finale=a.findById(AdressId);					 //address finale
		 double distancetemp;
		 distance = functions.DistanceEntreDeuxAddress(init,finale);
		 Address court=null;
		 double dist;
		if(distance!=0){
			list = c.findNeighbors(init);
			double min=9999999999999999.99;
			int j=0;
			int i= list.size();	
			for(;i>0;i--){
				Address temp = list.get(j);
				dist=999;
				distancetemp=functions.DistanceEntreDeuxAddress(temp,finale);
				distancevoisin = 9999;
				if (temp.getStreetId() == init.getStreetId()) {
			  		 dist = 0;
			  		 float xtemp = temp.x - init.x;
			  		 float ytemp = temp.y - init.y;
			  		distancevoisin = (float) Math.sqrt(xtemp*xtemp +ytemp*ytemp);
			  	} else {
			  		dist = 0;
			  		Point p = Util.intersection(temp, init);
			  		float xtemp = temp.x - p.x;
			  		float ytemp = temp.y - p.y;
			  		distancevoisin = (float) Math.sqrt(xtemp*xtemp +ytemp*ytemp);
			  		 xtemp =init.x - p.x;
			  		 ytemp = init.y - p.y;
			  		distancevoisin = dist + (float) Math.sqrt(xtemp*xtemp +ytemp*ytemp);
			  				  		
			  	}
				if(distancevoisin<min){
					if(distancetemp<distance){

						min=distancevoisin;
						court = list.get(j);
					}
					else{
						court = list.get(0);
					}		
				}
				else{
					j++;		
				}			
			if(court==finale){
				distance=0;
			}
			else{
				System.out.println(init.getId() + " and " + b);
				data_arrays[b][0]=init.x;
				data_arrays[b][1]=init.y;
				data_arrays[b][2]=court.x;
				data_arrays[b][3]=court.y;
				if (init.getStreetId() == court.getStreetId()) {
					data_arrays[b][4] = 0;
				}
				else {
					data_arrays[b][4] = 1;
					data_arrays[b][5] = init.getStreetId();
					data_arrays[b][6] = court.getStreetId();
				}
				b = b + 1;
			}
			Algorithme2(court,finale.getId());
			}
		}
		else{
			
		}
		data_arrays[b][0]=-1;
		data_arrays[b][1]=-1;
		return data_arrays;	 
	} 
}
