package gui;

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

public class gui1 extends Applet {
	Image backGround;
	int pointStartX;
	int pointStartY;
    int pointEndX;
    int pointEndY;
    int selectedStreet = -1;
    int mode = 2; //1 = create street, 2 = create address, 3 = create neighboors

	
 public void init() {
 
	// set the size of the applet to the size of the background image.
     // Resizing the applet may cause distortion of the image.
     setSize(1232, 810);
     
     if (mode == 1) {
     //create streets
    	 System.out.println("street");
    	 createStreet a = new createStreet(this);
    	 addMouseListener(a);
    	 addMouseMotionListener(a);
     }
     else if (mode == 2) {  
    	 System.out.println("address");
	     //create address
	     StreetDAO streetDao = new StreetDAO(); 
	     List<Street> allStreets;
		try {
			allStreets = streetDao.findAll();
			int numberOfStreets = allStreets.size(); 
			 java.awt.List choices = new java.awt.List(numberOfStreets); 
		     for (Street street : allStreets) {
		    	 choices.add(Integer.toString(street.getId()));     
		     }
		     add (choices); 
		     choices.addItemListener(new listListener(choices, this)); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
     } else if (mode == 3) {
    	 //create neighbors
    	 
     }
	     

   
    
    
 }
 public void paint(Graphics p) {

	 //image background
     BufferedImage photo = null;
     try 
     {
    	 // change url to yours
        URL u = new URL(getCodeBase(),"gui/bg.png");
        photo = ImageIO.read(u);
     }   
     catch (IOException e) 
     {
        System.out.println(e);
     }

     p.drawImage(photo,0, 0, 1232, 810,null);
     
     
     //draw street
     StreetDAO s = new StreetDAO();
     try {
    	 List<Street> allStreets = s.findAll();
    	 if (allStreets != null) {
         for (Street street : allStreets) {
        	 //p.setColor(Color.BLACK);
        	 Graphics2D twoD = (Graphics2D) p;
        	 if (street.getId() == selectedStreet) {
        		 twoD.setColor(Color.red);
        	 } else {
        		 twoD.setColor(Color.orange);
        	 }
        	 twoD.setStroke(new BasicStroke(4));    	 
        	 twoD.drawLine((int)street.getX1(), (int)street.getY1(), (int)street.getX2(), (int)street.getY2());        	        	 
         }
    	 }
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
  
 
    //draw address
     AddressDAO a = new AddressDAO();
     try {
    	 List<Address> allAddress = a.findAll();
    	 if (allAddress != null) {
    	 for (Address add : allAddress) {   	 
  			 System.out.println(add.getId()+add.getStreetId()+add.getX()+add.getY());
  			 p.setColor(Color.GREEN);
  			 p.drawOval((int)add.x-5,(int)add.y-5,10,10);
    	 }
    	 }
  			
  	} catch (SQLException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  		  

 	}
 public void CalculationCost(Address x,Address y){
	 Address first= x; 				
	 Address second=y;	
	 float cost;
	 cost= DistanceEntreDeuxAddress(first.x,first.y,second.x,second.y);
	 
	 
	 
 }
 public static float DistanceEntreDeuxAddress(Address first,Address second){
	 //float,int ve double types can be change how we ll create our address
		
	 float distance=0;
	 float x = first.x-second.x;
	 float y=first.y-second.y;
		 
	distance = (float)Math.sqrt(x*x +y*y);	
	return distance;
 }
 
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
	 distance = DistanceEntreDeuxAddress(init,finale);
	 Address court=null;

	if(distance!=0){
		list = a.findVoisinById(init.getId());
		double min=9999999999999999.99;
		int j=0;
		int i= list.size();		
		for(;i>0;i--){
			Address temp = list.get(j);
			distancetemp=DistanceEntreDeuxAddress(temp,finale);
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
	 distance = DistanceEntreDeuxAddress(init,finale);
	 Address court=null;

	if(distance!=0){
		list = a.findVoisinById(init.getId());
		double min=9999999999999999.99;
		int j=0;
		int i= list.size();		
		for(;i>0;i--){
			Address temp = list.get(j);
			distancetemp=DistanceEntreDeuxAddress(temp,finale);
			distancevoisin=DistanceEntreDeuxAddress(temp,init);
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
		Algorithme1(court,finale);
	}
	else{
		return data_array;
	}	
	 	 
 } 
}
