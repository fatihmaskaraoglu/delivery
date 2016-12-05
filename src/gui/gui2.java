package gui;

import java.applet.*; 
import java.awt.*; 
             
public class gui2 extends Applet{
   Image img;
   //NOT WORKING
   
   public void init() {
	   setSize(1000,500);
	   img = getImage(getDocumentBase(), "15357008_10211026941493716_944923547_n.jpg");
   }
   public void paint(Graphics g) {
     
      g.drawImage(img, 0, 0, this);
   } 
}