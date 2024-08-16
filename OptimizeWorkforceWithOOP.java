//Rui On Li
//12/31/2021
//Optimize your workforce with OOP
import java.util.Scanner;

public class OptimizeWorkforceWithOOP {
	public static void main(String args[]) {	
		
		Branch [] storeBranches = new Branch[3];
		int g = 0;
		Branch one;
		
		System.out.println("Welcome to Item Locator!");
		System.out.println("*******************");
		System.out.println("*  *  ****  *     *");
		System.out.println("*  *  *     * * * *");
		System.out.println("*  *  ***   *  *  *");
		System.out.println("*  *  *     *     *");
		System.out.println("*  *  ****  *     *");
		
		
		for (int i = 0; i < 3; i++) {
			
			Scanner input = new Scanner(System.in);
			//menu
			System.out.println("MENU: 1)Administration 2)Reporting");
			System.out.println("Please choose one of the above: ");
			int menu = input.nextInt();

			if(menu==1) {

				for (int t = 0; t < 3; t++) {
					one = new Branch(0, null, 0, null, null, null);

					System.out.println("Enter a 4-digit Branch ID:");
					int branchID = input.nextInt();

					//checking if brandID is valid
					boolean validBranchID = false;
					do {
						if(branchID > 1000 && branchID < 9999) {
							validBranchID = true;
							break;
						}
						else if(branchID < 1000 || branchID > 9999) {
							validBranchID = false;
							System.out.println("The Branch ID you have entered is not valid. Please enter a valid branch ID:");
							branchID = input.nextInt();
						}
					}
					while(validBranchID==false);
					one.setBranchID(branchID);
					
					//getting branch info
					System.out.println("Enter location name: ");
						input.nextLine();
					String locationName = input.nextLine();
					one.setLocationName(locationName);
					System.out.println("Enter 4-digit location ID: ");
					int locationID = input.nextInt();
					one.setLocationID(locationID);
						input.nextLine();
					System.out.println("Enter address: ");
					String address = input.nextLine();
					one.setAddress(address);
					
					boolean managerValid = false;
					boolean employeeValid = false; 
					boolean removeValid = false;
					do {
					System.out.println("Please go through all of the options provided\n"
							+ "1)Assign a manager to supervise the branch\n"
							+ "2)Assign employees to the branch team\n"
							+ "3)Remove an employee from the branch team");
					System.out.println("Choose one of the above:");
					int administrationChoice = input.nextInt();
					if(administrationChoice==1) {
						//Assign a manager to supervise the branch
						//getting manager info
						System.out.println("Enter manager first name: ");
						String managerFirst = input.nextLine();
							input.nextLine();
						System.out.println("Enter manager last name: ");
						String managerLast = input.nextLine();
						System.out.println("Enter manager full name: ");
						String managerFull = input.nextLine();
							
						Manager manager = new Manager(managerFirst, managerLast, managerFull, branchID, locationID);
						one.setSupervisor(manager);
						managerValid = true;
					}
					else if (administrationChoice==2) {
						//Assign 3 employee to the branch team
						System.out.println("Creating four employees for the branch team");	
						
						for (int r = 0; r < 4; r++) {
							//creating 4 employees
							System.out.println("Enter employee first name: ");
							String employeeFirst = input.nextLine();
								input.nextLine();
							System.out.println("Enter employee last name: ");
							String employeeLast = input.nextLine();
							System.out.println("Enter employee full name: ");
							String employeeFull = input.nextLine();
								
							System.out.println("Create a 4-digit employee ID: ");
							int employeeID = input.nextInt();
								
							//checking for valid employeeID
							boolean validEmployeeID = false;
							do {
								if(employeeID < 9999 && employeeID > 1000) {
									validEmployeeID = true;
									break;
								}
								else if(employeeID > 9999 || employeeID < 1000) {
									validEmployeeID = false;
									System.out.println("The employee ID you have entered is not valid. Please enter a valid employee ID:");
									employeeID = input.nextInt();
								}
							} while(validEmployeeID==false);
							
							Employee s = new Employee(employeeFirst, employeeLast, employeeFull, employeeID, locationID); 
							one.addToTeam(s);
						}
						employeeValid = true;
						System.out.println("You have reached the maximun amount of employees for this branch"); 
					}
						
					else if(administrationChoice==3) {
						//confirming to remove an employee
						System.out.println("If you wish to remove an employee, please enter 1, if not, enter 2: ");
						int determineRemove = input.nextInt();
						if (determineRemove==1) {
							//Remove an employee from the branch team
							System.out.println("Enter employee full name you would like to remove:");
								input.nextLine();
							String removeEmployee = input.nextLine();
							one.removeFromTeam(removeEmployee);
						}
						else if (determineRemove==2) {
							break;
						}
						removeValid = true;
					}
				}
				while(managerValid==false || employeeValid==false || removeValid==false);
				
				storeBranches[g] = one;
				g++;
				}
			}
			
			else if(menu==2) {
				//printing out branches info
				System.out.println("1)View a report of manager and employees for a specific location\n"
					+ "2)View a cumulative report of all employees sorted by branch location, including total managers and total number of employees for the company");
				System.out.println("Choose one of the above: ");
				int reportingChoice = input.nextInt();
				
				if(reportingChoice==1) {
					//View a report of manager and employees for a specific location
					System.out.println("Enter a location ID: ");
					int reportLocation = input.nextInt();

					for (int l = 0; l < storeBranches.length; l++) {
						if(storeBranches[l].getLocationID()==reportLocation) {
							storeBranches[l].displayBranchInfo();
							break;
						}
					}
				}
				else if(reportingChoice==2) {
					//View a cumulative report of all employees sorted by branch location, including total managers and total number of employees for the company
					for (int h = 0; h < storeBranches.length; h++) {
						storeBranches[h].displayBranchInfo();
					}
				}
			}
		}
	}
}