package dataModels;

public class Street {
	
	private int id;
	private String streetName;
	private float x1;
	private float y1;
	private float x2;
	private float y2;
	
	public Street(int pId, String pStreetName, float pX1, float pY1, float pX2, float pY2) {
		id = pId;
		streetName = pStreetName;
		x1 = pX1;
		y1 = pY1;
		x2 = pX2;
		y2 = pY2;
		
	}
	
	public Street(String pStreetName, float pX1, float pY1, float pX2, float pY2) {
		streetName = pStreetName;
		x1 = pX1;
		y1 = pY1;
		x2 = pX2;
		y2 = pY2;
		
	}

}
