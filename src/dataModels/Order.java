package dataModels;

public class Order {
	
	private int id;
	private int addressId;
	
	public Order(int pId, int pAddressId) {
		id = pId;
		addressId = pAddressId;
	}
	
	public Order(int pAddressId) {
		addressId = pAddressId;
	}

}
