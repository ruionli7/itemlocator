//assignment11


public class Employee {
	public String employeeFirst;
	public String employeeLast;
	public String employeeFull;
	public int employeeID;
	public int locationID;
	public static int totalEmployees = 0;
	
	public Employee(String employeeFirst, String employeeLast, String employeeFull, int employeeID, int locationID){
		this.employeeFirst = employeeFirst;
		this.employeeLast = employeeLast;
		this.employeeFull = employeeFull; 
		this.employeeID = employeeID;
		this.totalEmployees = totalEmployees + 1;
		this.locationID = locationID;
	}
	//getter methods
	public String getEmployeeFirst() {
		return employeeFirst;
	}
	public String getEmployeeLast() {
		return employeeLast;
	}
	public String getEmployeeFull() {
		return employeeFull; 
	}
	public int employeeID() {
		return employeeID;
	}
	public int locationID() {
		return locationID;
	}
	
	//setter methods
	public void setEmployeeFirst(String employeeFirst) {
		this.employeeFirst = employeeFirst;
	}
	public void setEmployeeLast(String employeeLast) {
		this.employeeLast = employeeLast;
	}
	public void setEmployeeFull(String employeeFull) {
		this.employeeFull = employeeFull;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public static int totalEmployees(int totalEmployees) {
		return totalEmployees;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	//print employees method
	public void printEmployees() {
		System.out.println("Team Employees: " + employeeFull);
	}
}