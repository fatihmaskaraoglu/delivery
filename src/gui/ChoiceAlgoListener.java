package gui;

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import DAOs.AddressDAO;
import DAOs.CostDAO;
import DAOs.StreetDAO;
import dataModels.Address;
import dataModels.Street;

import algorithmes.*;

class ChoiceAlgoList implements ItemListener { 
	
	gui3 gui3;
	Choice choiceAlgo;
	Choice desta1;
	Choice desta2;
	Choice desta3;
	

    public ChoiceAlgoList(Choice choiceAlgo, gui3 gui3, Choice desta1, Choice desta2, Choice desta3)
    {
    	this.choiceAlgo = choiceAlgo;
    	this.gui3 = gui3;
    	this.desta1 = desta1;
    	this.desta2 = desta2;
    	this.desta3 = desta3;
    }
    
    public void itemStateChanged (ItemEvent event) 
    { 
    	int ida1 = Integer.valueOf(desta1.getSelectedItem());
    	int ida2 = Integer.valueOf(desta2.getSelectedItem());
    	int ida3 = Integer.valueOf(desta3.getSelectedItem());
    	AddressDAO adao = new AddressDAO();
    	Address addResto=null;
    	Address adda1=null;
    	Address adda2=null;
    	Address adda3=null;
		try {
			addResto = adao.findById(gui3.idResto);
			adda1 = adao.findById(ida1);
			adda2 = adao.findById(ida2);
			adda3 = adao.findById(ida3);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	if(choiceAlgo.getSelectedItem() == "Deliveryman1"){

			//System.out.println("Deliveryman1 : " + addResto.getId() + "/" + idDest);
			try {
				AlgoithmManager Amanager = new AlgoithmManager(addResto, adda1, adda2, adda3);
				//algorithme1 algo = new algorithme1();
				gui3.data_arrays = Amanager.executeWithBestOrder();
				//.Algorithme1(addResto,idDest);
				gui3.repaint();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	} else if (choiceAlgo.getSelectedItem() == "Deliveryman2") {
    		System.out.println("Deliveryman2");
    		algorithme2 algo2 = new algorithme2();
			try {
				gui3.data_arrays = algo2.Algorithme2(addResto,ida1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gui3.repaint();
    	} else if (choiceAlgo.getSelectedItem() == "Deliveryman3") {
    		System.out.println("Deliveryman3");
    		algorithme3 algo3 = new algorithme3();
			try {
				gui3.data_arrays = algo3.Algorithme3(addResto,ida1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gui3.repaint();
    		
    	}
    	
    }
       
        
}  
