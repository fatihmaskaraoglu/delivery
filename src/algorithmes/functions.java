package algorithmes;

import java.awt.Point;

import Util.Util;
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

public static float distance2(Address temp, Address init) {
	
    float distancevoisin;
	if (temp.getStreetId() == init.getStreetId()) {
 		 float xtemp = temp.x - init.x;
 		 float ytemp = temp.y - init.y;
 		distancevoisin = (float) Math.sqrt(xtemp*xtemp +ytemp*ytemp);
 	} else {
 		Point p = Util.intersection(temp, init);
 		float xtemp = temp.x - p.x;
 		float ytemp = temp.y - p.y;
 		distancevoisin = (float) Math.sqrt(xtemp*xtemp +ytemp*ytemp);
 		 xtemp =init.x - p.x;
 		 ytemp = init.y - p.y;
 		distancevoisin = distancevoisin + (float) Math.sqrt(xtemp*xtemp +ytemp*ytemp);
 	}
	return distancevoisin;
}	




}
