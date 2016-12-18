package dataModels;

public class Order_DeliveryMan {
	
	private int id;
	private int orderId;
	private int deliveryManId;
	
	public Order_DeliveryMan(int pId, int pOrderId, int pDeliveryManId) {
		id = pId;
		orderId = pOrderId;
		deliveryManId = pDeliveryManId;	
	}
	
	public Order_DeliveryMan(int pOrderId, int pDeliveryManId) {
		orderId = pOrderId;
		deliveryManId = pDeliveryManId;	
	}
	
	public Order_DeliveryMan(Order_DeliveryMan odm) {
		this.id = odm.id;
		this.orderId = odm.orderId;
		this.deliveryManId = odm.deliveryManId;	
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getDeliveryManId() {
		return deliveryManId;
	}

	public void setDeliveryManId(int deliveryManId) {
		this.deliveryManId = deliveryManId;
	}

}
