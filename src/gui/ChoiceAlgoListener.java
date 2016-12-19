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
	Choice dest;
	

    public ChoiceAlgoList(Choice choiceAlgo, gui3 gui3, Choice dest)
    {
    	this.choiceAlgo = choiceAlgo;
    	this.gui3 = gui3;
    	this.dest = dest;
    }
    
    public void itemStateChanged (ItemEvent event) 
    { 
    	int idDest = Integer.valueOf(dest.getSelectedItem());
    	AddressDAO adao = new AddressDAO();
    	Address addResto=null;
		try {
			addResto = adao.findById(gui3.idResto);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	if(choiceAlgo.getSelectedItem() == "Deliveryman1"){

			System.out.println("Deliveryman1 : " + addResto.getId() + "/" + idDest);
			try {
				algorithme1 algo = new algorithme1();
				gui3.data_arrays = algo.Algorithme1(addResto,idDest);
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
			//gui3.data_arrays = algo2.Algorithme2(addResto,idDest);
			//gui3.repaint();
    	} else if (choiceAlgo.getSelectedItem() == "Deliveryman3") {
    		System.out.println("Deliveryman3");
    		algorithme3 algo3 = new algorithme3();
			//gui3.data_arrays = algo3.Algorithme3(addResto,idDest);
			//gui3.repaint();
    		
    	}
    	
    }
       
        
}  
