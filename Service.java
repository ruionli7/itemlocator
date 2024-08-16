
public class Service {
	public String serviceName;
	public int serviceInventory;
	public int servicePrice;
	
	public Service(String serviceName, int serviceInventory, int servicePrice) {
		this.serviceName = serviceName;
		this.serviceInventory = serviceInventory;
		this.servicePrice = servicePrice;
	}
	
	//getter methods
	public String getServiceName() {
		return serviceName;
	}
	public int getServiceInventory() {
		return serviceInventory;
	}
	public int getServicePrice() {
		return servicePrice;
	}
	
	//setter methods
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public void setServiceInventory(int serviceInventory) {
		this.serviceInventory = serviceInventory;
	}
	public void setServicePrice(int servicePrice) {
		this.servicePrice = servicePrice;
	}
	
	public void printService() {
		System.out.println("Service " + serviceName + ": " + serviceInventory + " units available" + " ($" + servicePrice + " per unit)");
	}
	public void returningservice(String returnService, int returnUnit, Service[] storeService) {
		for(int l = 0; l < storeService.length; l++) {
			if(storeService[l].getServiceName().equals(returnService)) {
				storeService[l].serviceInventory = storeService[l].serviceInventory + returnUnit;
			}
		}
	}
	
}

