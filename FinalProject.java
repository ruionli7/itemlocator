//Rui On Li
//6/22/2022
//Final Project

import java.util.Scanner;

public class FinalProject {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
				
		Service one;
		int p = 0;
		//an array to store services
		Service [] storeService = new Service[3];
		
		System.out.println("Welcome to Item Locator!");
		System.out.println("*******************");
		System.out.println("*  *  ****  *     *");
		System.out.println("*  *  *     * * * *");
		System.out.println("*  *  ***   *  *  *");
		System.out.println("*  *  *     *     *");
		System.out.println("*  *  ****  *     *");
		
		//menu
		for (int r = 0; r < 2; r++) {
			System.out.println("Choose one of the Menu options below: "
					+ "\n1)Inventory Actions"
					+ "\n2)Sales Actions");
			int menu = input.nextInt();
			
			if(menu==1) {
				//inventory actions
				boolean add = false;
				boolean view = false;
				boolean modify = false;
				do {
					System.out.println("Please go through all options below:"
							+ "\nChoose a inventory action:"
							+ "\n1)Adding a service to the system "
							+ "\n2)Viewing inventory "
							+ "\n3)Modifying a service's available inventory ");
					int inventoryAction = input.nextInt();
					
					if(inventoryAction==1) {
						//Adding a Service to the system
						System.out.println("Do you wish to enter a service package to the system? Enter 1 for yes, 2 for no: ");
						int determineAdd = input.nextInt();
						
						if (determineAdd==1) {
							System.out.println("Enter the amount of services you would like to add: ");
							int numOfNewService = input.nextInt();
							
							for (int n = 0; n < numOfNewService; n++) {
								one = new Service(null, 0, 0);
			
								System.out.println("Enter the name of the service: ");
									input.nextLine();
								String newService = input.nextLine();
								one.setServiceName(newService);
								System.out.println("Enter how much each unit of this service costs in dollars: ");
								int newServicePrice = input.nextInt();
								one.setServicePrice(newServicePrice);
								System.out.println("Enter the amount of units for inventory: ");
								int newServiceInv = input.nextInt();
								one.setServiceInventory(newServiceInv);
								
								storeService[p] = one;	
								p++;
							}
						}
						else if (determineAdd==2) {
							break;
						}
						add = true;

					}
					else if(inventoryAction==2) {
						//Viewing inventory
						for (int q = 0; q < storeService.length; q++) {
							storeService[q].printService();	
						}
						view = true;
					}
					else if(inventoryAction==3) {
						//Modifying a Service's available inventory
						
						System.out.println("Do you wish to modify a service's available inventory? Enter 1 for yes, 2 for no");
						int determineModify = input.nextInt();
						
						if (determineModify==1) {
							System.out.println("Enter name of service inventory you would like to change: ");
								input.nextLine();
							String change = input.nextLine();
							System.out.println("Enter the new amount of inventory this service has: ");
							int changeInventory = input.nextInt();
							modifyingInventory(change, changeInventory, storeService);
						}
						else if (determineModify==2) {
							break;
						}
						modify = true;
					}
				} while (add==false || view==false || modify==false);
			}
			else if(menu==2) {
				//sales actions
		
				boolean viewAll = false;
				boolean buy = false;
				boolean returning = false;
				do {
					System.out.println("Please go through all options below:"
							+ "\nChoose a sales action: "
							+ "\n1)Viewing a list of services and their propertes, including available quantity and pricing "
							+ "\n2)Buying an amount of a service"
							+ "\n3)Returning an amount of a service");
					int salesAction = input.nextInt();
					
					if (salesAction==1) {
						//Viewing a list of Services and their propertes, including available quantity and pricing
						for (int q = 0; q < storeService.length; q++) {
							storeService[q].printService();	
						}							
						viewAll = true;
					}
					else if (salesAction==2) {
						//Buying an amount of a Service
						
						System.out.println("Do you wish to make a purchase? Enter 1 for yes, 2 for no: ");
						int determineBuy = input.nextInt();
						if (determineBuy==1) {
							 System.out.println("Enter the full name of the service you would like to purchase: ");
							 	input.nextLine();
							 String purchaseService = input.nextLine();
							 System.out.println("Enter the amount of units you would like to purchase: ");
							 int purchaseUnits = input.nextInt();
							 
							 boolean validPurchaseUnit = false;
							 for (int z = 0; z < storeService.length; z++) {
								 if (storeService[z].getServiceName().equals(purchaseService)) {
										
										do {
											if (purchaseUnits > storeService[z].serviceInventory) {
												System.out.println("The amount of units you would like to purchase is not available"
														+ "\nPlease enter an appropiate amount of units you would like to purchase: ");
												purchaseUnits = input.nextInt();
											}
											
										} while (validPurchaseUnit==false);
								 }
								 else if (purchaseUnits < storeService[z].serviceInventory || purchaseUnits==storeService[z].serviceInventory) {
										validPurchaseUnit = true;
										break;
									} 
							 }
							 purchase(purchaseService, purchaseUnits, storeService);	
							 
							 System.out.println("Enter last 4 digits of your credit card number: ");
							 int creditCard = input.nextInt();
							 
							 boolean validCard = false;
								do {
									if(creditCard > 1000 && creditCard < 9999) {
										validCard = true;
										break;
									}
									else if(creditCard < 1000 || creditCard > 9999) {
										System.out.println("The credit card you have entered is not valid. Please enter a valid credit card number:");
										creditCard = input.nextInt();
									}
								}
								while(validCard==false);
							System.out.println("Your purchase is complete.");
							
						}
						else if (determineBuy==2) {
							break;
						}
						buy = true;
						 
					}
					else if(salesAction==3) {
						//returning service units 
						
						System.out.println("If you would like to return a certain amount of units from a service enter 1, if not, enter 2:");
						int determineReturn = input.nextInt();
						if(determineReturn==1) {
							System.out.println("Enter the name of the service you would like to return: ");
								input.nextLine();
							String returnService = input.nextLine();
							System.out.println("Enter the amount of unit you would like to return: ");
							int returnUnit = input.nextInt();
							System.out.println(returnUnit + " units of " + returnService + " has been returned"
									+ "\nMoney for " + returnUnit + " unit will be returned to your bank account");
						}
						else if(determineReturn==2) {
							break;
						}
						returning = true;
					}
				} while (viewAll==false || buy==false || returning==false);
			}
		}
	System.out.println("Thank you for visiting Item Locator");
	}
	
	private static void purchase(String purchaseService, int purchaseUnits, Service[] storeService) {
		for(int l = 0; l < storeService.length; l++) {
			if(storeService[l].getServiceName().equals(purchaseService)) {
				storeService[l].serviceInventory = storeService[l].serviceInventory - purchaseUnits;
				int totalPrice = storeService[l].servicePrice * purchaseUnits;
				System.out.println("The total amount for your purchase is: $" + totalPrice);
				
			}
		}
	}
	
	private static void modifyingInventory(String change, int changeInventory, Service[] storeService) {
		for (int n = 0; n < storeService.length; n++) {
			if (storeService[n].getServiceName().equals(change)) {
				storeService[n].serviceInventory = changeInventory;
			}
		}
	}
	
}
