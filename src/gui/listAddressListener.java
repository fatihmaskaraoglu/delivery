package gui;

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import DAOs.StreetDAO;
import dataModels.Street;

class listAddressListener implements ItemListener { 
	
	java.awt.List choices;
	Choice test;
	gui1 gui1;
	gui3 gui3;
	createAddress currentCreateAdresse;
	int number;
	
    public listAddressListener(java.awt.List choices, gui1 gui1, int number)
    {
    	this.choices = choices;
    	this.gui1 = gui1;
    	this.number = number;
    }
    public listAddressListener(Choice test, gui3 gui3, int number)
    {
    	this.test = test;
    	this.gui3 = gui3;
    	this.number = number;
    }
    public void itemStateChanged (ItemEvent event) 
    { 
    	if (choices == null) {
    		//int choice = Integer.valueOf(choices.getSelectedItem());
	        if (number == 1) {
	        	gui3.selectedAddress1 = Integer.valueOf(test.getSelectedItem());
	        }
	        else if (number == 2) {
	        	gui3.selectedAddress2 = Integer.valueOf(test.getSelectedItem());
	        }  
	        gui3.repaint();
    	} else {
    		//int choice = Integer.valueOf(choices.getSelectedItem());
	        if (number == 1) {
	        	gui1.selectedAddress1 = Integer.valueOf(choices.getSelectedItem());
	        }
	        else if (number == 2) {
	        	gui1.selectedAddress2 = Integer.valueOf(choices.getSelectedItem());
	        } 
	        gui1.repaint();
    	}
       
        
   
       // g.fillOval (50, y, 30, 30); 
    } // method itemStateChanged 
} // class listListener 