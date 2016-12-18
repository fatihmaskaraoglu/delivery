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

	public Address_Neighbors(Address_Neighbors an){
		this.id = an.id;
		this.addressId1 = an.addressId1;
		this.addressId2 = an.addressId2;
		
	}

	public int getAddressId1() {
		return addressId1;
	}

	public void setAddressId1(int addressId1) {
		this.addressId1 = addressId1;
	}

	public int getAddressId2() {
		return addressId2;
	}

	public void setAddressId2(int addressId2) {
		this.addressId2 = addressId2;
	}
	
	 
	
	 
}
