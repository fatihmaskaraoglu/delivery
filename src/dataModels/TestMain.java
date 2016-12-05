package dataModels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAOs.AddressDAO;

public class TestMain {

	public static void main(String[] args) {

		// example for db connection
		AddressDAO a = new AddressDAO();
	
		for (int i = 1; i < 13; i++) {
			try {

				Address add = new Address(a.findById(i));
				System.out.println("Id= " + add.getId() + " StreetId= " + add.getStreetId() + " X= " + add.getX()
						+ " Y= " + add.getY());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
