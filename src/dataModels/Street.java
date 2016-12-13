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
	public Street(Street s){
//		this.id = s.id;
//		this.streetName = s.streetName;
//		this.x1 = s.x1;
//		this.y1 = s.y1;
//		this.x2 = s.x2;
//		this.y2 = s.y2;
	}
	public void setId(int id) {
		this.id= id;
	}
	public void setStreetName(String name) {
		this.streetName = name;
	}
	
	public void setX1(float x ) {
		this.x1 = x;
	}
	public void setY1(float y){
		this.y1 = y;
	}
	
	public int getId() {
		return id;
	}
	public String getStreetName() {
		return streetName;
	}
	public float getX1() {
		return x1;
		
	}
	public float getY1() {
		return y1;
		
	}		
	public float getX2() {
		return x2;
		
	}
	public float getY2() {
		return y2;
		
	}		

}
