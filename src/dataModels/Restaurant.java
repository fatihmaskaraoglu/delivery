package dataModels;

public class Restaurant {
	
	private int id;
	private String listOfOrders;
	private int addressId;
	private int numberOfAvailableDelvryName;
	
	public Restaurant(int pId, String pListOfOrders, int pAddressId, int pNumberOfAvailableDelvryName) {
		id = pId;
		listOfOrders = pListOfOrders;
		addressId = pAddressId;
		numberOfAvailableDelvryName = pNumberOfAvailableDelvryName;
	}
	
	public Restaurant(String pListOfOrders, int pAddressId, int pNumberOfAvailableDelvryName) {
		listOfOrders = pListOfOrders;
		addressId = pAddressId;
		numberOfAvailableDelvryName = pNumberOfAvailableDelvryName;
	}

	public Restaurant(Restaurant r){
		this.id = r.id;
		this.listOfOrders = r.listOfOrders;
		this.addressId = r.addressId;
		this.numberOfAvailableDelvryName = r.numberOfAvailableDelvryName;
	}

	public String getListOfOrders() {
		return listOfOrders;
	}

	public void setListOfOrders(String listOfOrders) {
		this.listOfOrders = listOfOrders;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getNumberOfAvailableDelvryName() {
		return numberOfAvailableDelvryName;
	}

	public void setNumberOfAvailableDelvryName(int numberOfAvailableDelvryName) {
		this.numberOfAvailableDelvryName = numberOfAvailableDelvryName;
	}
	
	 
}
