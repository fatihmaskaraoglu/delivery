package delivery;

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
	

}
