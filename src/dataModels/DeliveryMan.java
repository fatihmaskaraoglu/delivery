package dataModels;

public class DeliveryMan {
	
	private int id;
	private int available;
	
	public DeliveryMan(int pId, int pAvailable) {
		id = pId;
		available = pAvailable;
	}
	
	public DeliveryMan(int pAvailable) {
		available = pAvailable;
	}

}
