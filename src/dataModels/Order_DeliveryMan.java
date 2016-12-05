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

}
