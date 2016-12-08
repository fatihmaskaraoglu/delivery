package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dataModels.Street;
import DAOs.StreetDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class createStreet extends MouseAdapter { 
	int pointStartX;
	int pointStartY;
    int pointEndX;
    int pointEndY;
    
    gui1 gui1;
    public createStreet(gui1 gui2)
    {
    	gui1 = gui2;
    }

	 
	  public void mousePressed(MouseEvent e) { 
	     pointStartX = e.getX(); 
	     pointStartY = e.getY(); 
	     System.out.println("pressed" + pointStartX + "/" + pointStartY);
	     e.consume();
	  } 
	 
	  public void mouseReleased(MouseEvent e) { 
	         
	         pointEndX = e.getX(); 
	         pointEndY = e.getY(); 
	         //points.addElement(new Point(ePoint)); 
	         System.out.println("release" + pointEndX + "/" + pointEndY);
	         e.consume();
	         Street s = new Street("none", pointStartX, pointStartY, pointEndX, pointEndY);
	         StreetDAO a = new StreetDAO();
	         try {
				a.insertStreet(s);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	         gui1.repaint();          
	  }

	}
