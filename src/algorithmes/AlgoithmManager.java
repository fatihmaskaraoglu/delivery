package algorithmes;

import java.awt.Point;
import java.sql.SQLException;

import DAOs.StreetDAO;
import Util.Util;
import dataModels.Address;
import dataModels.Street;

public class AlgoithmManager {
	
	Address Restaurant;
	Address a1;
	Address a2;
	Address a3;
	int algoNumber;
	StreetDAO s;
	
	public AlgoithmManager(Address resto, Address a1, Address a2, Address a3) {
		this.Restaurant = resto;
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
		s = new StreetDAO();
		
	}
	
	public float[][] executeWithBestOrder() throws SQLException {
		float[][] cheminFinal;
		
		algorithme1 way1 = new algorithme1();
		way1.Algorithme1(Restaurant,a1);
		way1.Algorithme1(a1,a2);
		way1.Algorithme1(a2,a3);
		way1.Algorithme1(a3,Restaurant);
		float distance1 = distanceTotale(way1);
//		int i = 0;
//		boolean ignore = true;
//		//int stop = 0;
//		while(ignore) {
//			if (way1.data_arrays[i][0] == 0) {
//				ignore = false;
//			} else if (way1.data_arrays[i][0] == -1) {
//				//nothing
//				
//			} else {
//				System.out.println(way1.data_arrays[i][0] + "/" + way1.data_arrays[i][1]);	
//				System.out.println(way1.data_arrays[i][2] + "/" + way1.data_arrays[i][3]);
//				
//			}
//			i++;
//	
//		}
		
		algorithme1 way2 = new algorithme1();
		way2.Algorithme1(Restaurant,a1);
		way2.Algorithme1(a1,a3);
		way2.Algorithme1(a3,a2);
		way2.Algorithme1(a3,Restaurant);
		float distance2 = distanceTotale(way2);
		
		algorithme1 way3 = new algorithme1();
		way3.Algorithme1(Restaurant,a2);
		way3.Algorithme1(a2,a1);
		way3.Algorithme1(a1,a3);
		way3.Algorithme1(a3,Restaurant);
		float distance3 = distanceTotale(way3);
		
		algorithme1 way4 = new algorithme1();
		way4.Algorithme1(Restaurant,a2);
		way4.Algorithme1(a2,a3);
		way4.Algorithme1(a3,a1);
		way4.Algorithme1(a1,Restaurant);
		float distance4 = distanceTotale(way4);
		
		algorithme1 way5 = new algorithme1();
		way5.Algorithme1(Restaurant,a3);
		way5.Algorithme1(a3,a1);
		way5.Algorithme1(a1,a2);
		way5.Algorithme1(a2,Restaurant);
		float distance5 = distanceTotale(way5);
		
		algorithme1 way6 = new algorithme1();
		way6.Algorithme1(Restaurant,a3);
		way6.Algorithme1(a3,a2);
		way6.Algorithme1(a2,a1);
		way6.Algorithme1(a1,Restaurant);
		float distance6 = distanceTotale(way6);
		
		float DistTemp;
		if (distance1 <= distance2) {
			cheminFinal = way1.data_arrays; 	
			DistTemp = distance1;
		} else {
			cheminFinal = way2.data_arrays; 
			DistTemp = distance2;
		}
		
		if (distance3 <= DistTemp) {
			cheminFinal = way3.data_arrays; 	
			DistTemp = distance3;
		}
		
		
		if (distance4 <= DistTemp) {
			cheminFinal = way4.data_arrays; 
			DistTemp = distance4;
		}
		
		if (distance5 <= DistTemp) {
			cheminFinal = way5.data_arrays; 
			DistTemp = distance5;
		}	
		
		
		if (distance6 <= DistTemp) {
			cheminFinal = way6.data_arrays; 	
			DistTemp = distance3;
		} 
		
		
		
		return cheminFinal;
	}

	public float distanceTotale(algorithme1 algo) {
		
		float[][] data = algo.data_arrays;
		boolean noStop = true;
		float cumulativeDistance = 0, x, y;
		int j = 0, stop = 0;
		while(noStop) {
		   if (data[j][0] == 0) {
				noStop = false;
			}
		   else if (data[j][0] == -1) {
			   //nothing
		   }
			else {
				if (data[j][4] == 0) {
					x = data[j][0] - data[j][2];
					y = data[j][1] - data[j][3];		
					cumulativeDistance = cumulativeDistance + (float)Math.sqrt(x*x +y*y);	
					
				} else {
					try {
						Street s1 = s.findById((int)data[j][5]);
						Street s2 = s.findById((int)data[j][6]);
						Point p = Util.intersection(s1.getX1(), s1.getY1(), s1.getX2(), s1.getY2(), s2.getX1(), s2.getY1(), s2.getX2(), s2.getY2());
						x = data[j][0] - p.x;
				  		y = data[j][1] - p.y;
				  		cumulativeDistance = cumulativeDistance + (float) Math.sqrt(x*x +y*y);
				  		x = data[j][2] - p.x;
				  		y = data[j][3] - p.y;
				  		cumulativeDistance = cumulativeDistance + (float) Math.sqrt(x*x +y*y);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			}
			j++;
		}		
		return cumulativeDistance;		
	}
	
	
}
