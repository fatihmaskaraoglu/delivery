package gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import DAOs.StreetDAO;
import dataModels.Street;

class listAddressListener implements ItemListener { 
	
	java.awt.List choices;
	gui1 gui1;
	createAddress currentCreateAdresse;
	int number;
	
    public listAddressListener(java.awt.List choices, gui1 gui1, int number)
    {
    	this.choices = choices;
    	this.gui1 = gui1;
    	this.number = number;
    }
    public void itemStateChanged (ItemEvent event) 
    { 
        int choice = Integer.valueOf(choices.getSelectedItem());
        if (number == 1) {
        	gui1.selectedAddress1 = Integer.valueOf(choices.getSelectedItem());
        }
        else if (number == 2) {
        	gui1.selectedAddress2 = Integer.valueOf(choices.getSelectedItem());
        }
       
        gui1.repaint();
   
       // g.fillOval (50, y, 30, 30); 
    } // method itemStateChanged 
} // class listListener 