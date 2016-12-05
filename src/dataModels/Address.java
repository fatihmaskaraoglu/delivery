package dataModels;

public class Address {
	
	private int id;
	private int streetId;
	private int streetNumber;
	private float x;
	private float y;
	
	public Address(int pId, int pStreetId, int pStreetNumber, float pX, float pY) {
		id = pId;
		streetId = pStreetId;
		streetNumber = pStreetNumber;
		x = pX;
		y = pY;	
	}
	public Address(int pStreetId, int pStreetNumber, float pX, float pY) {
		streetId = pStreetId;
		streetNumber = pStreetNumber;
		x = pX;
		y = pY;	
	}
	
	public void setStreetId(int streetId) {
		this.streetId = streetId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	public void setX(float x ) {
		this.x = x;
	}
	public void setY(float y){
		this.y = y;
	}
	public int getStreetId() {
		return streetId;
	}
	public int getId() {
		return id;
	}
	public int getStreetNumber() {
		return streetNumber;
	}
	public float getX() {
		return x;
		
	}
	public float getY() {
		return y;
		
	}		

}
