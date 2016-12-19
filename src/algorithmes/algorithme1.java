package algorithmes;
import java.applet.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.net.URL;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.IOException.*;

import DAOs.AddressDAO;
import DAOs.CostDAO;
import DAOs.StreetDAO;
import dataModels.Address;
import dataModels.Street;

import java.applet.Applet;
import java.math.*;

public class algorithme1{
	private static float[][] data_arrays;

	public static float[][] Algorithme1 (Address x,int AdressId) throws SQLException{
	 data_arrays = null;	 
	 AddressDAO a = new AddressDAO();
	 
	 CostDAO c = new CostDAO();	
	 List<Address> list=new ArrayList<>();
	 int b=0;	 
	 double distance=0;  			// distance address initial a address finale
	 //double distancevoisin=0; 			// distance voisin a address finale
	 Address init= x; 					//address initial
	 Address finale= a.findById(AdressId);			 //address finale
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
			if(distancetemp<min){
				min=distancetemp;
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
		Algorithme1(court,finale.getId());
	}
	else{
	}
	return data_arrays;
 }
}

