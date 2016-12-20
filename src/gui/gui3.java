package gui;

import java.applet.Applet;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import java.lang.Object;

import DAOs.AddressDAO;
import DAOs.RestaurantDAO;
import DAOs.StreetDAO;
import Util.Util;
import dataModels.Address;
import dataModels.Street;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;

import algorithmes.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.net.URL;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.IOException.*;

import DAOs.AddressDAO;
import DAOs.StreetDAO;
import dataModels.Address;
import dataModels.Street;

import java.applet.Applet;
import java.math.*;
import algorithmes.algorithme1;

public class gui3 extends Applet {

	private float[][] algorithme1(Address findById, Integer valueOf) {
		// TODO Auto-generated method stub
		return null;
	}

	float[][] data_arrays = null;
	Image backGround;

	int selectedStreet = -1;
	int selectedAddress1 = -1;
	int selectedAddress2 = -1;
	int idResto = 1;

	public void init() {

		setSize(1232, 810);

		JFrame frame2 = new JFrame("gui3");
		frame2.setSize(275, 700);
		frame2.setLayout(new BorderLayout());
		Choice cb = new Choice();
		AddressDAO a = new AddressDAO();
		List<Address> allAddress;

		// get restaurant
		RestaurantDAO rdao = new RestaurantDAO();

		try {

			 idResto = rdao.findById(1).getAddressId();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			allAddress = a.findAll();
			if (allAddress != null) {
				for (Address add : allAddress) {
					cb.insert(String.valueOf(add.getId()), add.getId());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cb.addItemListener(new listAddressListener(cb, this, 1));
		Choice cb2 = new Choice();
		cb2.insert("Choose your deliveryman", 0);
		cb2.insert("Deliveryman1", 1);
		cb2.insert("Deliveryman2", 2);
		cb2.insert("Deliveryman3", 3);
		add(cb);
		add(cb2);
		cb2.addItemListener(new ChoiceAlgoList(cb2, this, cb));

		if (cb2.getSelectedItem() == "Deliveryman1") {
			System.out.println("yoyo");
			try {
				data_arrays = algorithme1(a.findById(1), Integer.valueOf(cb.getSelectedItem()));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(data_arrays);
		}
		// cb.getSelectedItem()
	}

	public void paint(Graphics p) {
		int i = 0;
		// image background
		BufferedImage photo = null;
		try {
			// change url to yours

			URL u = new URL(getCodeBase(), "gui/bg.jpg");
			photo = ImageIO.read(u);
		} catch (IOException e) {
			System.out.println(e);
		}

		p.drawImage(photo, 0, 0, 1160, 659, null);
		// draw street
		StreetDAO s = new StreetDAO();
		try {
			List<Street> allStreets = s.findAll();
			if (allStreets != null) {
				for (Street street : allStreets) {
					// p.setColor(Color.BLACK);
					Graphics2D twoD = (Graphics2D) p;
					if (street.getId() == selectedStreet) {
						twoD.setColor(Color.red);
					} else {
						twoD.setColor(Color.orange);
					}
					twoD.setStroke(new BasicStroke(4));
					twoD.drawLine((int) street.getX1(), (int) street.getY1(), (int) street.getX2(),
							(int) street.getY2());
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// draw address
		AddressDAO a = new AddressDAO();

		try {
			List<Address> allAddress = a.findAll();
			int size = 10;
			if (allAddress != null) {
				for (Address add : allAddress) {
					p.setColor(Color.GREEN);
					if (add.getId() == idResto) {
						p.setColor(Color.BLACK);
						size = 20;

						p.drawOval((int) add.x - (size/2), (int) add.y - (size/2), size, size);
						p.drawString(Integer.toString(add.getId()), (int)add.x+10, (int)add.y+10);
						size = 10;

					} else if (add.getId() == selectedAddress1 || add.getId() == selectedAddress2) {
						p.setColor(Color.red);

					} else {
						p.setColor(Color.GREEN);

					}
					p.drawOval((int) add.x - (size / 2), (int) add.y - (size / 2), size, size);
					p.drawString(Integer.toString(add.getId()), (int)add.x+10, (int)add.y+10);
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// paint chemin
		if (data_arrays != null) {
			boolean stop = true;
			int j = 0;
			Graphics2D twoD = (Graphics2D) p;
			twoD.setColor(Color.red);
			twoD.setStroke(new BasicStroke(4));
			while (stop) {
				if (data_arrays[j][0] == -1) {
					stop = false;
				} else {

					if (data_arrays[j][4] == 0) {
						twoD.drawString(Integer.toString(j), (int)data_arrays[j][0], (int)data_arrays[j][1]); //
						twoD.drawLine((int)data_arrays[j][0] ,(int)data_arrays[j][1], (int) data_arrays[j][2],(int) data_arrays[j][3]);
					} else {
						try {
							twoD.drawString(Integer.toString(j), (int)data_arrays[j][0], (int)data_arrays[j][1]); //
							Street s1 = s.findById((int)data_arrays[j][5]);
							Street s2 = s.findById((int)data_arrays[j][6]);
							Point p2 = Util.intersection(s1.getX1(), s1.getY1(), s1.getX2(), s1.getY2(), s2.getX1(), s2.getY1(), s2.getX2(), s2.getY2());
							twoD.drawLine((int)data_arrays[j][0] ,(int)data_arrays[j][1], (int) p2.x,(int)p2.y);
							twoD.drawLine((int)data_arrays[j][2] ,(int)data_arrays[j][3], (int) p2.x,(int)p2.y);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
						j++;

				}
			}
		}

	}

}
