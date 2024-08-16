
public class Branch {
	int locationID;
	String locationName;
	int branchID;
	String address;
	Manager supervisor;
	Employee [] team;
	int numOfEmployees;
	
	public Branch(int locationID, String locationName, int branchID, String address, Manager supervisor, Employee [] team) {
		this.locationID = locationID;
		this.locationName = locationName;
		this.branchID = branchID;
		this.address = address;
		this.supervisor = supervisor;
		this.team = new Employee[5];
		this.numOfEmployees = 0;
	}
	
	//getter methods for attributes
	public int getLocationID() {
		return locationID;
	}
	public String getLocationName() {
		return locationName;
	}
	public int getBranchID() {
		return branchID;
	}
	public String getAddress() {
		return address;
	}
	public Manager getSupervisor() {
		return supervisor;
	}
	public Employee [] getTeam() {
		return team;
	}
	
	//setter methods for attributes
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setSupervisor(Manager supervisor) {
		this.supervisor = supervisor;
	}
	public void setTeam(Employee [] team) {
		this.team = team;
	}
	
	//addToTeam method that takes in an Employee object and adds it to the Team array
	public void addToTeam(Employee e) {
		team[numOfEmployees] = e;
		numOfEmployees++;
	}
	//removeFromTeam method that removes the Employee object from the Team
	public void removeFromTeam(String removeEmployee) {
		Employee [] k = new Employee[4];
		int removeNum = -1;
		for(int r = 0; r < numOfEmployees; r++) {
			if(team[r].getEmployeeFull().equals(removeEmployee)) {
				removeNum = r;
			}
		}
		for(int a = 0; a < numOfEmployees; a++) {
			if(removeNum > 0 && a!=removeNum ) {
				k[a] = team[a];
			}
		}
		team = k;
		numOfEmployees = numOfEmployees - 1;
	}
	//displayBranchInfo method to display the supervisor and team information, as well as the number of employees on the team
	public void displayBranchInfo() {
		supervisor.printManager();		
		System.out.println("Location: " + locationName + 
				"\nAddress: " + address +
				"\nTotal Number Team Employees: " + numOfEmployees);
				for (int s = 0; s < numOfEmployees; s++) {
					team[s].printEmployees();
				}
	}
}
