package dataModels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAOs.AddressDAO;
import DAOs.StreetDAO;

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
		
		StreetDAO s = new StreetDAO();
		//Street st1 = new Street(7,"Cadde7",3,0,3,2);
//		try {
//			s.insertStreet(st1);
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		for (int i = 1; i < 8; i++) {
			try {

				Street st = new Street(s.findById(i));
				System.out.println("Id= " + st.getId() + " StreetId= " + st.getStreetName() + " X1= " + st.getX1()
						+ " Y1= " + st.getY1() + " X2= " + st.getX2() + " Y2= " + st.getY2() );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		

	}

}
