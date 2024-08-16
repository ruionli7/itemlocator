
public class Manager {
	String managerFirst;
	String managerLast;
	String managerFull;
	int branchID;
	int locationID;
	
	public Manager(String managerFirst, String managerLast, String managerFull, int branchID, int locationID) {
		this.managerFirst = managerFirst;
		this.managerLast = managerLast;
		this.managerFull = managerFull;
		this.branchID = branchID;
		this.locationID = locationID;
	}
	
	//getter methods
	public String getManagerFirst() {
		return managerFirst;
	}
	public String getManagerLast() {
		return managerLast;
	}
	public String getManagerFull() {
		return managerFull;
	}
	public int getBranchID() {
		return branchID;
	}
	public int getLocationID() {
		return locationID;
	}
	
	//setter methods
	public void setManagerFirst(String managerFirst) {
		this.managerFirst = managerFirst;
	}
	public void setManagerLast(String managerLast) {
		this.managerLast = managerLast;
	}
	public void setManagerFull(String managerFull) {
		this.managerFull = managerFull;
	}
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	
	//print manager method
	public void printManager() {
		System.out.println("Supervisor: " + managerFull
				+ "\nBranch ID: " + branchID
				+ "\nLocation ID: " + locationID);
	}
}
