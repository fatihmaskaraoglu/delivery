package gui;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;

import DAOs.AddressDAO;
import dataModels.Address;
import algorithmes.*;
import java.awt.Choice;
public class gui3 extends Applet { 

 public void paint(Graphics p) {
	 	setSize(1232, 810);
	 	 
	 	int i;
	 	int j=0;
	 	AddressDAO addreseDAO = new AddressDAO();	 		  
		
		 //image background
	     BufferedImage photo = null;
	     Choice AddressID = new Choice();
	     try 
	     {
	    	List<Address> allAddress = addreseDAO.findAll();
//	    	for(i=0;i<allAddress.size();i++){
//	    	AddressID.getItem(allAddress.get(i).getId());
//	    	}
	    	 // change url to yours
	        URL u = new URL(getCodeBase(),"gui/bg.png");
	        photo = ImageIO.read(u);
	        p.drawImage(photo,0, 0, 1232, 810,null);
	    	if (allAddress != null) {
	    	 for (Address add : allAddress) {
	    		 for(j=0;j<allAddress.size();j++){
	        	p.fillRect((int)add.getX()*100,(int)add.getY()*100,5,5);     	
	    		 }
	    	 }
	    	// List<Address> draw = algorithmes.algorithme1(AddressID.getSelectedItem())
	    	 // p.drawLine(x1, y1, x2, y2);
	    	}
	     }   
	     catch (IOException | SQLException e) 
	     {
	        System.out.println(e);
	     }

	   
	     
	}

}
