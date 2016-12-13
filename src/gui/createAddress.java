package gui;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import DAOs.AddressDAO;
import DAOs.StreetDAO;
import dataModels.Street;
import dataModels.Address;
import Util.Util;

public class createAddress extends MouseAdapter { 
	int pointX;
	int pointY;
	int streetId;
    gui1 gui1;
    Point P;
    
    public createAddress(gui1 gui2, int streetId)
    {
    	gui1 = gui2;
    	this.streetId = streetId;
    }

	 
	  public void mousePressed(MouseEvent e) { 
	     pointX = e.getX(); 
	     pointY = e.getY();
	     StreetDAO sDao = new StreetDAO();
	     Street s;
		try {
			s = sDao.findById(streetId);
			System.out.println(s.getId());
			P = Util.getClosestPointOnSegment((int)s.getX1(), (int)s.getY1(), (int)s.getX2(),(int)s.getY2(), pointX, pointY);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Address address = new Address(streetId, (float)P.getX(), (float)P.getY());
		AddressDAO aDAO = new AddressDAO();
		try {
			aDAO.insertAddress(address);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     
	     System.out.println("adresse on " + pointX + "/" + pointY + " with : " + streetId);
	     e.consume();
	     gui1.repaint();  
	  } 
	 


}
