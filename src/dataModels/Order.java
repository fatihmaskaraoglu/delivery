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

	public Order(Order o){
		this.id = o.id;
		this.addressId = o.addressId;
	 }

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
 
}
