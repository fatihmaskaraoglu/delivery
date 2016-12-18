package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import DAOs.AddressDAO;
import DAOs.CostDAO;
import DAOs.StreetDAO;
import dataModels.Address;
import dataModels.Street;

public class buttonPressed implements MouseListener {
	
	java.awt.List choices1;
	java.awt.List choices2;
	gui1 gui1;

	public buttonPressed(java.awt.List choices1, java.awt.List choices2, gui1 gui1)
    {
		System.out.println("Button created");
    	this.choices1 = choices1;
    	this.choices2 = choices2;
    	this.gui1 = gui1;
    }


	public void mouseClicked(MouseEvent e) {
		System.out.println("Button pressed address id : " + choices1.getSelectedItem() + "/" + choices2.getSelectedItem());
        AddressDAO adao = new AddressDAO();
        Address ad1 = null;
        Address ad2 = null;
        try {
        	ad1 = adao.findById(Integer.valueOf(choices1.getSelectedItem()));
        	ad2 = adao.findById(Integer.valueOf(choices2.getSelectedItem()));			
		} catch (SQLException e1) {
			System.out.println(e1);
		}
        CostDAO cdao = new CostDAO();
        try {
			cdao.insertCost(ad1, ad2);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        gui1.repaint();
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}
