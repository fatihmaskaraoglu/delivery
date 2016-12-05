package dataModels;

public class Address {
	
	private int id;
	private int streetId;
	public float x;
	public float y;
	
	public Address(int pId, int pStreetId, float pX, float pY) {
		id = pId;
		streetId = pStreetId;
		x = pX;
		y = pY;	
	}
	public Address(int pStreetId, float pX, float pY) {
		streetId = pStreetId;
		x = pX;
		y = pY;	
	}
	public Address(Address a){
		this.id = a.id;
		this.streetId = a.streetId;
		this.x = a.x;
		this.y = a.y;
	}
	
	public void setStreetId(int streetId) {
		this.streetId = streetId;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public float getX() {
		return x;
		
	}
	public float getY() {
		return y;
		
	}		

}
