package gui;

import java.applet.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.*;
import java.sql.SQLException;

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
     setSize(300, 300);
     setBackground(Color.GRAY);
     // Set the image name to the background you want. Assumes the image 
     // is in the same directory as the class file is
    
    
 }
 public void paint(Graphics p) {
  	  Font tt=new Font("Arial",Font.PLAIN,17);
  	  p.setFont(tt);
  	  p.setColor(Color.cyan);
  	
  	  for (int i=1;i <13;i++){
  		  AddressDAO a = new AddressDAO();
  		  try {
  			Address add = new Address(a.findById(i));
  			 p.drawOval(100*(int)add.x,100*(int) add.y,5,5);
  			
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		  
  	  }
  	  p.drawString("Little City Prototype", 200, 280 );
  	  
  	 }
 
 

}