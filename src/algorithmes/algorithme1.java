package algorithmes;
import gui.gui1;

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
import DAOs.StreetDAO;
import dataModels.Address;
import dataModels.Street;

import java.applet.Applet;
import java.math.*;
public class algorithme1{
	public static float[][] Algorithme1 (Address x,Address y){
	 float[][] data_array = null;	 
	 AddressDAO a = new AddressDAO();	 
	 List<Address> list=new ArrayList<>();
	 int b=0;	 
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
		data_array[b][0]=init.x;
		data_array[b][1]=init.y;
		data_array[b][2]=court.x;
		data_array[b][3]=court.y;
		b++;
		}
		Algorithme1(court,finale);
	}
	else{
		return data_array;
	}	
 }
}

