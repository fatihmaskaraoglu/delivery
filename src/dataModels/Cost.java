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
	
}
