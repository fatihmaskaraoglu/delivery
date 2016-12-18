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
	
	public void setListOfOrders(String ListOfOrders){
		this.listOfOrders = ListOfOrders;
	}
	
	public void setAddressId(int AddressId){
		this.addressId = AddressId;
	}
	
	public void setNumberOfAvailableDelvryName(int NumberOfAvailableDelivryName){
		this.numberOfAvailableDelvryName = NumberOfAvailableDelivryName;
	}
	
	public String getListOfOrders(){
		return listOfOrders;
	}
	
	public int getAddressId(){
		return addressId;
	}
	
	public int getNumberOfAvailableDelvryName(){
		return numberOfAvailableDelvryName;
	}
}
