package gui;

import java.applet.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.*;
import java.sql.SQLException;
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

public class gui1 extends Applet {
	Image backGround;
	int pointStartX;
	int pointStartY;
    int pointEndX;
    int pointEndY;

	
 public void init() {
 
	// set the size of the applet to the size of the background image.
     // Resizing the applet may cause distortion of the image.
     setSize(1232, 810);
     
     createStreet a = new createStreet(this);
     addMouseListener(a);
     addMouseMotionListener(a);
   
    
    
 }
 public void paint(Graphics p) {

	 //image background
     BufferedImage photo = null;
     try 
     {
    	 // change url to yours
        URL u = new URL(getCodeBase(),"/Users/remi/Documents/dev/galata/devilery/delivery/src/gui/bg.png");
        photo = ImageIO.read(u);
     }   
     catch (IOException e) 
     {
        System.out.println(e);
     }

     p.drawImage(photo,0, 0, 1232, 810,null);
     
     
     //draw street
     StreetDAO a = new StreetDAO();
     try {
    	 List<Street> allStreets = a.findAll();
         for (Street street : allStreets) {
        	 //p.setColor(Color.BLACK);
        	 Graphics2D twoD = (Graphics2D) p;
        	 twoD.setColor(Color.orange);
        	 twoD.setStroke(new BasicStroke(4));    	 
        	 twoD.drawLine((int)street.getX1(), (int)street.getY1(), (int)street.getX2(), (int)street.getY2());        	        	 
         }
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
  
 

//     AddressDAO a = new AddressDAO();
 // 	  for (int i=1;i <13;i++){
  		  
//  		  try {
//  			Address add = new Address(a.findById(i));
//  			System.out.println(add.getId()+add.getStreetId()+add.getX()+add.getY());
//  			 p.drawOval(100*(int)add.x,100*(int) add.y,5,5);
//  			
//  		} catch (SQLException e) {
//  			// TODO Auto-generated catch block
//  			e.printStackTrace();
//  		}
  		  
//  	  }
//  	  p.drawString("Little City Prototype", 200, 280 );

  	  
//  	 }
 	}
 
}



