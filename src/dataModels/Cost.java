package dataModels;

public class Cost {

	private int id;
	private float distance;
	private int addressId1;
	private int addressId2;
	
	public Cost(int pId, float pDistance, int pAddressId1, int pAddressId2) {
		id = pId;
		distance = pDistance;
		addressId1 = pAddressId1;
		addressId2 = pAddressId2;
	}
	
	public Cost(float pDistance, int pAddressId1, int pAddressId2) {
		distance = pDistance;
		addressId1 = pAddressId1;
		addressId2 = pAddressId2;
	}
	
	public void setAddressId1(int AddressId1){
		this.addressId1 = AddressId1;
	}
	
	public void setAddressId2(int AddressId2){
		this.addressId2 = AddressId2;
	}
	public void setDistance(float Distance){
		this.distance = Distance;
	}
	
	public int getId(){
		return this.id;
	}
	public int getAddressId1(){
		return this.addressId1;
		
	}
	public int getAddressId2(){
		return this.addressId2;
		
	}
	public float getDistance(){
		return this.distance;
	}
}	
