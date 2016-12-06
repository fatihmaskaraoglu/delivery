package gui;

import java.applet.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.*;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.net.URL;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.IOException.*;

import DAOs.AddressDAO;
import dataModels.Address;

import java.applet.Applet;
//temel GUI elemanlarý
public class gui1 extends Applet {
	Image backGround;
	
 public void init() {
 
	// set the size of the applet to the size of the background image.
     // Resizing the applet may cause distortion of the image.
     setSize(1000, 500);
     setBackground(Color.GRAY);
     try {
         URL pic = new URL(getDocumentBase(), "city.jpg");
         backGround = ImageIO.read(pic);
     } catch(Exception e) {
         // tell us if anything goes wrong!
         e.printStackTrace();
     }
     // Set the image name to the background you want. Assumes the image 
     // is in the same directory as the class file is
    
    
 }
 public void paint(Graphics p) {
	 super.paint(p);
  	  Font tt=new Font("Arial",Font.PLAIN,17);
  	  p.setFont(tt);
  	  p.setColor(Color.cyan);
  	 
  	 
     if (backGround!=null) {
    	 p.drawImage(backGround, 100, 100, this);
     }
     AddressDAO a = new AddressDAO();
  	  for (int i=1;i <13;i++){
  		  
  		  try {
  			Address add = new Address(a.findById(i));
  			System.out.println(add.getId()+add.getStreetId()+add.getX()+add.getY());
  			 p.drawOval(100*(int)add.x,100*(int) add.y,5,5);
  			
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		  
  	  }
  	  p.drawString("Little City Prototype", 200, 280 );
  	  
  	 }
 
 

}