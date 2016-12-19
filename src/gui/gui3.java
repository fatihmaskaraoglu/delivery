package gui;

import java.applet.Applet;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import java.lang.Object;

import DAOs.AddressDAO;
import DAOs.StreetDAO;
import dataModels.Address;
import dataModels.Street;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;

import algorithmes.*;

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
import algorithmes.algorithme1;;
public class gui3 extends Applet {
	
private float[][] algorithme1(Address findById, Integer valueOf) {
	// TODO Auto-generated method stub
	return null;
}

	float[][] data_arrays=null;
	Image backGround;
	int pointStartX;
	int pointStartY;
    int pointEndX;
    int pointEndY;
    int selectedStreet = -1;
    int selectedAddress1 = -1;
    int selectedAddress2 = -1;
 public void init() {
	 setSize(1200, 800);
        JFrame frame2 = new JFrame("gui3");
     	frame2.setSize(275,700);
     	frame2.setLayout(new BorderLayout());
    	Choice cb = new Choice();		
     	AddressDAO a = new AddressDAO();
     	List<Address> allAddress;
		try {
			allAddress = a.findAll();
			if (allAddress != null) {
				for (Address add : allAddress) {
				cb.insert(String.valueOf(add.getId()),add.getId());	
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Choice cb2 = new Choice();		
	    cb2.insert("Deliveryman1",1);
	    cb2.insert("Deliveryman2",2);
	    cb2.insert("Deliveryman3",3);
		add(cb);
		add(cb2);
		
		if(cb2.getSelectedItem()=="Deliveryman1"){
			try {
				data_arrays = algorithme1(a.findById(1),Integer.valueOf(cb.getSelectedItem()));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(data_arrays);			
	}
//		cb.getSelectedItem()		
 }



public void paint(Graphics p) {
	int i=0;
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
		// draw street
		StreetDAO s = new StreetDAO();
		try {
			List<Street> allStreets = s.findAll();
			if (allStreets != null) {
				for (Street street : allStreets) {
					// p.setColor(Color.BLACK);
					Graphics2D twoD = (Graphics2D) p;
					if (street.getId() == selectedStreet) {
						twoD.setColor(Color.red);
					} else {
						twoD.setColor(Color.orange);
					}
					twoD.setStroke(new BasicStroke(4));
					twoD.drawLine((int) street.getX1(), (int) street.getY1(), (int) street.getX2(),
							(int) street.getY2());
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// draw address
		AddressDAO a = new AddressDAO();
		try {
			List<Address> allAddress = a.findAll();
			if (allAddress != null) {
				for (Address add : allAddress) {
					System.out.println(add.getId() + add.getStreetId() + add.getX() + add.getY());		
					p.setColor(Color.GREEN);
					if (add.getId() == selectedAddress1 || add.getId() == selectedAddress2) {
						p.setColor(Color.red);
							
					} else {
						p.setColor(Color.GREEN);
					}
					p.drawOval((int) add.x - 5, (int) add.y - 5, 10, 10);
				}
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}

}
