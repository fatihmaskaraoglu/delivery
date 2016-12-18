package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class buttonPressed implements ActionListener {
	
	java.awt.List choices1;
	java.awt.List choices2;
	gui1 gui1;

	public buttonPressed(java.awt.List choices, java.awt.List choices2, gui1 gui1)
    {
    	this.choices1 = choices1;
    	this.choices2 = choices2;
    	this.gui1 = gui1;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
