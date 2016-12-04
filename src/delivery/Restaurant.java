package delivery;

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

}
