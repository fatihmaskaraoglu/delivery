package dataModels;

public class Address_Neighbors {
	
	private int id;
	private int addressId1;
	private int addressId2;
	
	public Address_Neighbors(int pId, int pAddressId1, int pAddressId2) {
		id = pId;
		addressId1 = pAddressId1;
		addressId2 = pAddressId2;
	}

	public Address_Neighbors(int pAddressId1, int pAddressId2) {
		addressId1 = pAddressId1;
		addressId2 = pAddressId2;
	}

}
