package gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import DAOs.StreetDAO;
import dataModels.Street;

class listListener implements ItemListener { 
	
	java.awt.List choices;
	gui1 gui1;
	createAddress currentCreateAdresse;
	
    public listListener(java.awt.List choices, gui1 gui1)
    {
    	this.choices = choices;
    	this.gui1 = gui1;
    }
    public void itemStateChanged (ItemEvent event) 
    { 
        int choice = Integer.valueOf(choices.getSelectedItem());
        gui1.selectedStreet = Integer.valueOf(choices.getSelectedItem());
        if (currentCreateAdresse != null) {
        	gui1.removeMouseListener(currentCreateAdresse);
        }
        currentCreateAdresse = new createAddress(gui1, choice);
        gui1.addMouseListener(currentCreateAdresse);
        gui1.addMouseMotionListener(currentCreateAdresse);

        gui1.repaint();
   
       // g.fillOval (50, y, 30, 30); 
    } // method itemStateChanged 
} // class listListener 