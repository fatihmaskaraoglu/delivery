package gui;

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

public class makeOrder extends Applet {

	Image backGround;

	public void init() {
		// set the size of the applet to the size of the background image.
		// Resizing the applet may cause distortion of the image.
		setSize(1532, 810);

	}

	public void paint(Graphics p) {

		// image background
		BufferedImage photo = null;
		try {
			// change url to yours
			URL u = new URL(getCodeBase(), "gui/bg.png");
			photo = ImageIO.read(u);
		} catch (IOException e) {
			System.out.println(e);
		}

		p.drawImage(photo, 0, 0, 1232, 810, null);
		AddressDAO aDAO = new AddressDAO();
		try {
			List<Address> allAddress = aDAO.findAll();
			if (allAddress != null) {
				for (Address add : allAddress) {
					System.out.println(">--"+add.getId() + add.getStreetId() + add.getX() + add.getY());
					p.setColor(Color.GREEN);
					p.drawOval((int) add.x - 5, (int) add.y - 5, 10, 10);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
