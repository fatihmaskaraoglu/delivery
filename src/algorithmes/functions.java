package algorithmes;

import dataModels.Address;

public class functions {
	 
	 
public static float DistanceEntreDeuxAddress(Address first,Address second){
	 //float,int ve double types can be change how we ll create our address
		
	 float distance=0;
	 float x = first.x-second.x;
	 float y=first.y-second.y;
		 
	distance = (float)Math.sqrt(x*x +y*y);	
	return distance;
}




}
