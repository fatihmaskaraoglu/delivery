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
import DAOs.CostDAO;
import DAOs.StreetDAO;
import dataModels.Address;
import dataModels.Cost;
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
    int selectedAddress1 = -1;
    int selectedAddress2 = -1;
    int mode = 3; //1 = create street, 2 = create address, 3 = create neighboors

	
 public void init() {
 
	// set the size of the applet to the size of the background image.
     // Resizing the applet may cause distortion of the image.
     setSize(1200, 800);
     

    JFrame frame2 = new JFrame("Options");
 	frame2.setSize(275,700);
 	frame2.setLayout(new BorderLayout());

     
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
		     frame2.getContentPane().add(choices); 
		     choices.addItemListener(new listListener(choices, this)); 
		     frame2.setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
     } else if (mode == 3) {
    	 System.out.println("cost");   
    	 JButton b3 = new JButton("Add neighbors");
    	    
    	 AddressDAO addreseDAO = new AddressDAO();
    	 List<Address> alladdress;
 		try {
 			alladdress = addreseDAO.findAll();
 			int numberOfaddress = alladdress.size(); 
 			 java.awt.List choicesAddress1 = new java.awt.List(numberOfaddress); 
 			 java.awt.List choicesAddress2 = new java.awt.List(numberOfaddress);  
 		     for (Address address : alladdress) {
 		    	choicesAddress1.add(Integer.toString(address.getId()));
 		    	choicesAddress2.add(Integer.toString(address.getId()));
 		     }
 		     frame2.getContentPane().add(choicesAddress1, BorderLayout.WEST);
 		     frame2.getContentPane().add(choicesAddress2, BorderLayout.EAST); 
 		     frame2.getContentPane().add(b3, BorderLayout.SOUTH);  
 		     frame2.setVisible(true);
 		     choicesAddress1.addItemListener(new listAddressListener(choicesAddress1, this, 1));
 		     choicesAddress2.addItemListener(new listAddressListener(choicesAddress2, this, 2));
 		    System.out.println("before created");
 		     b3.addMouseListener(new buttonPressed(choicesAddress1, choicesAddress2, this));
 		    System.out.println("after created");
 		     //choices.addItemListener(new listListener(choices, this)); 
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}   
    	 
     }
	     

   
    
    
 }
 public void paint(Graphics p) {

	 //image background
     BufferedImage photo = null;
     try 
     {
    	 // change url to yours
        URL u = new URL(getCodeBase(),"gui/bg.jpg");
        photo = ImageIO.read(u);
     }   
     catch (IOException e) 
     {
        System.out.println(e);
     }

     p.drawImage(photo,0, 0, 1160, 659,null);
     
     
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
  			 p.setColor(Color.GREEN);
  			if (add.getId() == selectedAddress1 || add.getId() == selectedAddress2) {
  				p.setColor(Color.red);
  			} else {
  				p.setColor(Color.ORANGE);
  			}
  			 p.drawOval((int)add.x-5,(int)add.y-5,10,10);
  			 p.setColor(Color.CYAN);
  			 p.drawString(Integer.toString(add.getId()), (int)add.x, (int)add.y);
    	 }
    }
	   			
  	} catch (SQLException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
     
     //draw neighbors
	 CostDAO cdao = new CostDAO();
     try {
    	 List<Cost> allcosts = cdao.findAll();
    	 if (allcosts != null) {
        	 AddressDAO adao = new AddressDAO();
             for (Cost cost : allcosts) {
            	 Address a1 = adao.findById(cost.getAddressId1());
            	 Address a2 = adao.findById(cost.getAddressId2());
            	 
            	 Graphics2D twoD = (Graphics2D) p;
                 twoD.setColor(Color.BLACK);
            	 twoD.setStroke(new BasicStroke(2));
            	 
            	 if (a1.getStreetId() == a2.getStreetId()) {            	     	 
            		 twoD.drawLine((int)a1.getX(), (int)a1.getY(), (int)a2.getX(), (int)a2.getY());
            	 } else {
            		Point intersection = Util.Util.intersection(a1, a2);
            		twoD.drawLine((int)a1.getX(), (int)a1.getY(), (int)intersection.getX(), (int)intersection.getY());
            		twoD.drawLine((int)a2.getX(), (int)a2.getY(), (int)intersection.getX(), (int)intersection.getY());
            		
            	 }

            	
             }
    	 }
    } catch (SQLException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  		  

}
}