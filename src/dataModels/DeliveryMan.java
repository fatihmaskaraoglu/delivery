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
	
	public DeliveryMan(DeliveryMan dm) {
		this.id = dm.id;
		this.available = dm.available;
	}
	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}
	
}
